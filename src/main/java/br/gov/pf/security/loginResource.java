package br.gov.pf.security;

import br.gov.pf.model.entity.User;
import br.gov.pf.model.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.Map;

@Path("/login")
public class loginResource {
    @Inject
    private UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String login(Map<String, String> json) throws ServletException {
        if (json.get("cpf") == null || json.get("password") == null)
            throw new ServletException("Por favor informe um CPF e Senha");

        String cpf = json.get("cpf");
        String password = json.get("password");

        User user = userService.getByProperty("cpf", cpf);

        if (user == null)
            throw new ServletException("CPF não encontrado");

        String pwd = user.getPassword();

        if (!password.equals(pwd))
            throw new ServletException("Login invalido. Por favor verifique seu CPF/Senha");

        return Jwts.builder().setSubject(cpf).claim("roles", user.getRole()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

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
