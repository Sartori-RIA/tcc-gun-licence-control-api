package br.gov.pf.security;

import br.gov.pf.model.entity.User;
import br.gov.pf.model.service.UserService;
import br.gov.pf.util.BCrypt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Path("/login")
public class LoginResource {
    @Inject
    private UserService userService;
    private Login login = new Login();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Login login(Map<String, String> json) throws ServletException {
        if (json.get("cpf") == null || json.get("password") == null)
            throw new ServletException("Por favor informe um CPF e Senha");

        String cpf = json.get("cpf");
        String password = json.get("password");

        User user = userService.getByProperty("cpf", cpf);

        if (user == null)
            throw new ServletException("CPF não encontrado");

        String pwd = user.getPassword();
        if (!BCrypt.checkpw(password, pwd))
            throw new ServletException("Login invalido. Por favor verifique seu CPF/Senha");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        Date expiration = calendar.getTime();
        String base64 = "";
        try {
            base64 = Base64.getEncoder().encodeToString("SECRETKEY".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(cpf).claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, base64).compact();
        System.out.println(token);
        this.login.setToken(token);
        return this.login;

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
