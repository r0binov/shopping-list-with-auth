package ee.sdacademy.configuration;

import ee.sdacademy.models.Items;
import ee.sdacademy.models.ShoppingList;
import ee.sdacademy.models.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;
import java.util.function.Function;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static void init(String database, String user, String password) {
        Configuration configuration = new Configuration();

        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.postgresql.Driver");
        settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/" + database);
        settings.put(Environment.USER, user);
        settings.put(Environment.PASS, password);
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "validate");
        settings.put(Environment.ALLOW_JTA_TRANSACTION_ACCESS, "true");
        configuration.setProperties(settings);

        configuration.addAnnotatedClass(Users.class);
        configuration.addAnnotatedClass(ShoppingList.class);
        configuration.addAnnotatedClass(Items.class);

        sessionFactory = configuration.buildSessionFactory(
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build()
        );
    }

    public static EntityManager getEntityManager() {
        if (sessionFactory == null) {
            throw new RuntimeException("Session factory was not initialized");
        }

        return sessionFactory.createEntityManager();
    }

    public static <R> R queryWithoutTransaction(Function<EntityManager, R> queryExecutor) {
        return queryExecutor.apply(getEntityManager());
    }

    public static <R> R queryWithTransaction(Function<EntityManager, R> queryExecutor) {
        R result = null;
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            result = queryExecutor.apply(em);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        return result;
    }
}
