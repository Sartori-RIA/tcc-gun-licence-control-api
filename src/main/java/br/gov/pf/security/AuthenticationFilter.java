package br.gov.pf.security;

import br.gov.pf.util.Util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Date;

import static org.jboss.security.auth.callback.RFC2617Digest.REALM;


@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    private String AUTHENTICATION_SCHEME = "Bearer";


    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        String authorizationHeader = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (!isTokenBasedAuthentication(authorizationHeader)) {
            abortWithUnauthorized(containerRequestContext);
            return;
        }
        String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

        try {
            validateToken(token);
        } catch (Exception e) {
            abortWithUnauthorized(containerRequestContext);
        }
    }

    /**
     * Check if the Authorization header is valid
     * It must not be null and must be prefixed with "Bearer" plus a whitespace
     * The authentication scheme comparison must be case-insensitive
     *
     * @param authorizationHeader
     * @return
     */
    private boolean isTokenBasedAuthentication(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.toLowerCase()
                .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }

    /**
     * Abort the filter chain with a 401 status code response
     * The WWW-Authenticate header is sent along with the response
     *
     * @param requestContext
     */
    private void abortWithUnauthorized(ContainerRequestContext requestContext) {
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .header(HttpHeaders.WWW_AUTHENTICATE, AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
                        .build());
    }

    /**
     * Check if the token was issued by the server and if it's not expired
     * Throw an Exception if the token is invalid
     *
     * @param token
     * @throws Exception
     */
    private Response validateToken(String token) throws Exception {
        Algorithm algorithm = Algorithm.HMAC256(Util.secret);
        try {

            DecodedJWT decodedJWT = JWT.decode(token);
            Date exp = decodedJWT.getExpiresAt();

        } catch (JWTDecodeException e) {
            System.out.println("===============================================");
            System.out.println("=============TOKEN NAO CONFIAVEL ==============");
            System.out.println("===============================================");
            return Response.status(401).build();
        } catch (TokenExpiredException e) {
            System.out.println("===============================================");
            System.out.println("=============TOKEN EXPIRADO ===================");
            System.out.println("===============================================");
            return Response.status(401).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(401).build();
        }
        return Response.ok().build();
    }

    private String tokenRefresh(String token, String base64) {
       /* Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        Date expiration = calendar.getTime();
        Jwts.parser().setSigningKey(base64).parseClaimsJws(token).getBody().setExpiration(expiration);
        return token;*/
        return token;
    }
}

