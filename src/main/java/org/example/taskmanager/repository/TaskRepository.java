package org.example.taskmanager.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.repository.impl.TaskRepositoryImpl;

import java.util.Optional;

public class TaskRepository implements TaskRepositoryImpl {

    private EntityManagerFactory emf;
    private EntityManager entityManager;


    public TaskRepository() {
        this.emf = Persistence.createEntityManagerFactory("myJPAUnit");
        this.entityManager = emf.createEntityManager();
    }
    @Override
    public Optional<Task> save(Task task) {
        EntityTransaction transaction =  entityManager.getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.persist(task);
            transaction.commit();
            return Optional.of(task);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
