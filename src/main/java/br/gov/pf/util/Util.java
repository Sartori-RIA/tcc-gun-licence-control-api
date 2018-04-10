package br.gov.pf.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Util {

    public static final String issuer = "auth0";

    private static final String SECRETKEY = "SECRETKEY";

    public static String getSecret() {
        String base64 = "";
        try {
            base64 = Base64.getEncoder().encodeToString(SECRETKEY.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return base64;
    }
}
