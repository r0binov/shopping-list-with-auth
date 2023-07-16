package ee.sdacademy.repository;

import ee.sdacademy.configuration.HibernateUtil;
import ee.sdacademy.models.Items;
import java.util.List;

public class ItemsRepository {
    public static Items save(Items item) {
        return HibernateUtil.queryWithTransaction(entityManager -> entityManager.merge(item));
    }

    public List<Items> getAll() {
        return HibernateUtil.queryWithoutTransaction(entityManager -> entityManager.createQuery("from Items", Items.class).getResultList());
    }

    public static void delete(Items item) {
        HibernateUtil.queryWithTransactionNoResult(entityManager -> entityManager.remove(item));
    }
}
