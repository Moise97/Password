package com.project.Password.models;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;

@Service
public class PBKDF2 {

    private Password password;
    private static final String SALT = "1234";
    private static final Integer ITERATIONS = 10000;
    private static final Integer KEY_LENGTH = 512;

    public void setPassword(Password password) {
        this.password = password;
    }

    public String encodePassword() {

        char[]  passwordChars = password.getPassword().toCharArray();
        byte[] saltBytes = SALT.getBytes();

        byte[] hashedBytes = hashPassword(passwordChars, saltBytes);

        return Hex.encodeHexString((Objects.requireNonNull(hashedBytes)));
    }

    private static byte[] hashPassword(final char[] password, final byte[] salt){
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, PBKDF2.ITERATIONS, PBKDF2.KEY_LENGTH);
            SecretKey key = skf.generateSecret(spec);
            return key.getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

}
