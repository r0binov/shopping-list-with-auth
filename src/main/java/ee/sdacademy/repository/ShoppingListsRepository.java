package ee.sdacademy.repository;

import ee.sdacademy.configuration.HibernateUtil;
import ee.sdacademy.models.ShoppingLists;

import java.util.List;

public class ShoppingListsRepository {

    public ShoppingLists save(ShoppingLists shoppingList) {
        return HibernateUtil.queryWithTransaction(entityManager -> entityManager.merge(shoppingList));
    }

    public List<ShoppingLists> getAll() {
        return HibernateUtil.queryWithoutTransaction(entityManager -> entityManager.createQuery("from ShoppingLists", ShoppingLists.class).getResultList());
    }

    public void delete(ShoppingLists shoppingList) {
        HibernateUtil.queryWithTransactionNoResult(entityManager -> entityManager.remove(shoppingList));
    }

}
