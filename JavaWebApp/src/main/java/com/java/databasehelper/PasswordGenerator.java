package com.java.databasehelper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
public class PasswordGenerator {
	public static String hashPassword(String password, String salt) {
        try {
            // 1. Combine password and salt
            String passwordWithSalt = password + salt;

            // 2. Hash the combined string
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(passwordWithSalt.getBytes());

            // 3. Convert bytes to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
}
