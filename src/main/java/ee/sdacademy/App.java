package ee.sdacademy;

import ee.sdacademy.configuration.HibernateUtil;

public class App {
    public static void main(String[] args) {
        HibernateUtil.init("postgres", "postgres", "thisispassword");
    }
}
