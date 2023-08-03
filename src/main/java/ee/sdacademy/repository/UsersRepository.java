package ee.sdacademy.repository;

import ee.sdacademy.configuration.HibernateUtil;
import ee.sdacademy.models.Users;

import java.util.List;

public class UsersRepository {
    public void createUser(Users user) {
        HibernateUtil.queryWithTransactionNoResult(entityManager -> entityManager.persist(user));
    }

    public List<Users> getAllUsers() {
        return HibernateUtil.queryWithoutTransaction(entityManager ->
                entityManager.createQuery("FROM Users", Users.class).getResultList()
        );
    }

    public Users findUserById(Long id) {
        return HibernateUtil.queryWithoutTransaction(entityManager ->
                entityManager.find(Users.class, id));
    }

    public Users updateUser(Users users) {
        return HibernateUtil.queryWithTransaction(entityManager ->
                entityManager.merge(users));
    }

    public void deleteUser(Users user) {
        HibernateUtil.queryWithTransactionNoResult(entityManager -> entityManager.remove(user));
    }
}
