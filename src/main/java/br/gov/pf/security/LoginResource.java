package br.gov.pf.security;

import br.gov.pf.model.entity.User;
import br.gov.pf.model.service.*;
import br.gov.pf.util.Util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Path("/login")
public class LoginResource {

    private static final String PASSWORD = "password";
    private static final String CPF = "cpf";
    private final Login login = new Login();

    @Inject
    private UserService userService;
    @Inject
    private GenderService genderService;
    @Inject
    private StateService stateService;
    @Inject
    private CountryService countryService;
    @Inject
    private CityService cityService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Map<String, String> json) throws UnsupportedEncodingException {
        if (isLoginJson(json))
            return Response.status(401).build();

        String cpf = json.get(CPF);
        String password = json.get(PASSWORD);
        password = password.trim();

        User user = userService.getByProperty(CPF, cpf);

        if (user == null)
            return Response.status(401).build();
        Argon2 argon2 = Argon2Factory.create();
        if (!argon2.verify(user.getPassword(), password))
            return Response.status(401).build();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        Date expiration = calendar.getTime();


        Algorithm algorithm = Algorithm.HMAC256(Util.getSecret());
        String token = JWT.create()
                .withIssuer(Util.issuer)
                .withSubject(cpf)
                .withClaim("role", user.getRole().getDescription())
                .withIssuedAt(new Date())
                .withExpiresAt(expiration)
                .sign(algorithm);

        login.setToken(token);

        return Response.ok(login).build();

    }

    private boolean isLoginJson(Map<String, String> json) {
        return (json.get(CPF) == null) || (json.get(PASSWORD) == null) ||
                json.get(CPF).equals("") || (json.get(PASSWORD) == "");
    }

    @GET
    @Path("/genders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response genders() {
        try {
            return Response.ok(genderService.findAll()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/cities")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cities() {
        try {
            return Response.ok(cityService.findAll()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }


    @GET
    @Path("/states")
    @Produces(MediaType.APPLICATION_JSON)
    public Response states() {
        try {
            return Response.ok(stateService.findAll()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countries() {
        try {
            return Response.ok(countryService.findAll()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(User user) throws Exception {
        try {
            return Response.ok(userService.save(user)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }
}
