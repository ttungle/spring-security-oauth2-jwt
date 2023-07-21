package site.thanhtungle.springsecurityoauth2rs.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratorUtility {
    public static KeyPair generateRsaKey() {
        KeyPair keyPair;

        try {
            // Generate the RSA key pair with the standard Java cryptographic facilities
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch(Exception e) {
            throw new IllegalStateException();
        }

        return keyPair;
    };
}
