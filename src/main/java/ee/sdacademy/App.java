package ee.sdacademy;

import ee.sdacademy.configuration.HibernateUtil;
import ee.sdacademy.models.ShoppingLists;
import ee.sdacademy.repository.ShoppingListsRepository;

import java.security.MessageDigest;

public class App {
    public static void main(String[] args) {

        HibernateUtil.init("postgres", "", "");

    }

}
