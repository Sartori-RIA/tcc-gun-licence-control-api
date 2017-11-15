package br.gov.pf.security;

import br.gov.pf.util.BCrypt;
import org.jboss.security.Base64Encoder;

import java.security.MessageDigest;

public class PassGeneretor {

    public static void main(String[] args) {
        System.out.println("sha-256 " + new PassGeneretor().generate("123"));
    }

    String teste = "123";

    public String generate(String passwd) {

        System.out.println("salto 5 " + BCrypt.hashpw(passwd, BCrypt.gensalt(5)));
        System.out.println("salto default " + BCrypt.hashpw(passwd, BCrypt.gensalt()));
        System.out.println("salto 4 " + BCrypt.hashpw(passwd, BCrypt.gensalt(4)));
        try {
            byte[] bytes = new byte[0];
            bytes = MessageDigest.getInstance("sha-256").digest(passwd.getBytes());
            return Base64Encoder.encode(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifyPassword(String passwd) {
        return (BCrypt.checkpw(passwd, teste));
    }
}
