package br.com.ucs.eln.globals;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String passwordMD5(String text) {
        return hexString(generateHash(text)).toLowerCase();
    }

    private static byte[] generateHash(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(content.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String hexString(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int high = ((bytes[i] >> 4) & 0xf) << 4;
            int low = bytes[i] & 0xf;
            if (high == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(high | low));
        }
        return s.toString();
    }

}
