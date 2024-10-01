package org.example.taskmanager.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.impl.UserRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class UserRepository implements UserRepositoryImpl {

    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public UserRepository() {
        this.emf = Persistence.createEntityManagerFactory("myJPAUnit");
        this.entityManager = emf.createEntityManager();
    }

    public boolean save(User user){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.persist(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }

    }
    public Optional<User> findByEmail(String email){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            String stmFind = "SELECT u FROM User u WHERE u.email = :email";
            List<User> users = entityManager
                    .createQuery(stmFind, User.class)
                    .setParameter("email", email)
                    .getResultList();
            transaction.commit();
            if (!users.isEmpty()) return Optional.of(users.get(0));
            else return Optional.empty();
        }catch (Exception e){
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
    public Optional<User> findByUsername(String username) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            String stmFind = "SELECT u FROM User u WHERE u.username = :username";
            List<User> users = entityManager
                    .createQuery(stmFind, User.class)
                    .setParameter("username", username)
                    .getResultList();
            transaction.commit();
            if (!users.isEmpty()) return Optional.of(users.get(0));
            else return Optional.empty();
        }catch (Exception e){
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
    public Optional<User> findById(Long id){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            String stmFind = "SELECT u FROM User u WHERE u.id = :id";
            List<User> users = entityManager
                    .createQuery(stmFind, User.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
            if (!users.isEmpty()) return Optional.of(users.get(0));
            else return Optional.empty();
        }catch (Exception e){
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
    public Optional<User> deleteById(User user){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.remove(user);
            transaction.commit();
            return Optional.of(user);
        }catch (Exception e){
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
        return Optional.empty();
    }
    public Optional<User> update(User user){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.merge(user);
            transaction.commit();
            return Optional.of(user);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
