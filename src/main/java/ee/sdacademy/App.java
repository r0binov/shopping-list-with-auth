package ee.sdacademy;

import ee.sdacademy.configuration.HibernateUtil;
import ee.sdacademy.models.ShoppingList;

import java.security.MessageDigest;

public class App {
    public static void main(String[] args) {

        HibernateUtil.init("postgres", "postgres", "thisispassword");

    }
    public static String encrypt(String str) {
        try {
            var md = MessageDigest.getInstance("SHA-512");
            var data = md.digest(str.getBytes());
            var sb = new StringBuilder();
            for (byte datum : data) {
                sb.append(Integer.toString((datum & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Encryption failed");
        }
    }
}
