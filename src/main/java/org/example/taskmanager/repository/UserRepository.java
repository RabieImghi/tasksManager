package org.example.taskmanager.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
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

    @Transactional
    public boolean save(User user){
        entityManager.persist(user);
        return true;git
    }
    public Optional<User> findByEmail(String email){
        return Optional.empty();
    }
}
