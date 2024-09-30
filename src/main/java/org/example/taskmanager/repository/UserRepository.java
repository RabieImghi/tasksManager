package org.example.taskmanager.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.impl.UserRepositoryImpl;
import java.util.Optional;

public class UserRepository implements UserRepositoryImpl {

    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public UserRepository() {
        this.emf = Persistence.createEntityManagerFactory("myJPAUnit");
        this.entityManager = emf.createEntityManager();
    }

    public void save(User user){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    public Optional<User> findByEmail(String email){
        return Optional.empty();
    }
}
