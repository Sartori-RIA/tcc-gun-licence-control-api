package br.gov.pf.security;

import br.gov.pf.model.entity.User;
import br.gov.pf.model.service.UserService;
import br.gov.pf.util.BCrypt;
import br.gov.pf.util.Util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Path("/login")
public class LoginResource {
    @Inject
    private UserService userService;
    private final Login login = new Login();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Map<String, String> json) throws UnsupportedEncodingException {
        if (json.get("cpf") == null || json.get("password") == null ||
                json.get("cpf") == "" || json.get("password") == "")
            return Response.status(401).build();

        String cpf = json.get("cpf");
        String password = json.get("password");

        User user = userService.getByProperty("cpf", cpf);

        if (user == null)
            return Response.status(401).build();
        Argon2 argon2 = Argon2Factory.create();
        if(!argon2.verify(user.getPassword(), password))
            return Response.status(401).build();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        Date expiration = calendar.getTime();
        String base64 = "";
        try {
            base64 = Base64.getEncoder().encodeToString("SECRETKEY".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Algorithm algorithm = Algorithm.HMAC256(Util.secret);
        String token = JWT.create()
                .withIssuer(Util.issuer)
                .withSubject(cpf)
                .withClaim("role", user.getRole().getDescription())
                .withIssuedAt(new Date())
                .withExpiresAt(expiration)
                .sign(algorithm);

        this.login.setToken(token);

        return Response.ok(this.login).build();

    }


    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User registerUser(User user) throws Exception {
        try {
            return userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
