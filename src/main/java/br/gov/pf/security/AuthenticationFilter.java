package br.gov.pf.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import static org.jboss.security.auth.callback.RFC2617Digest.REALM;


@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    private String AUTHENTICATION_SCHEME = "Bearer";


    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        // Get the Authorization header from the request
        String authorizationHeader = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Validate the Authorization header
        if (!isTokenBasedAuthentication(authorizationHeader)) {
            abortWithUnauthorized(containerRequestContext);
            return;
        }
        // Extract the token from the Authorization header
        String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

        try {
            // Validate the token
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
        try {
            String base64 = "";
            try {
                base64 = Base64.getEncoder().encodeToString("SECRETKEY".getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Jwts.parser().setSigningKey(base64).parseClaimsJws(token).getBody().getExpiration();
            return Response.ok().build();
        } catch (ExpiredJwtException e) {
            System.out.println("===============================================");
            System.out.println("=============TOKEN EXPIRADO ===================");
            System.out.println("===============================================");
            return Response.status(401).build();
        } catch (SignatureException e) {
            System.out.println("===============================================");
            System.out.println("ASSINATURA NÃO É VALIDA, NÃO PODE SER CONFIAVEL");
            System.out.println("===============================================");
            return Response.status(401).build();
        } catch (Exception e) {
            System.out.println("===============================================");
            System.out.println("=============TOKEN NÃO É VALIDO================");
            System.out.println("===============================================");
            return Response.status(401).build();
        }
    }
}

