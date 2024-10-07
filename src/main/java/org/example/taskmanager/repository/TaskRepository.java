package org.example.taskmanager.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.taskmanager.entity.Tage;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.repository.impl.TaskRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class TaskRepository implements TaskRepositoryImpl {

    private EntityManagerFactory emf;
    private EntityManager entityManager;
    EntityTransaction transaction;


    public TaskRepository() {
        this.emf = Persistence.createEntityManagerFactory("myJPAUnit");
        this.entityManager = emf.createEntityManager();
        this.transaction =  entityManager.getTransaction();
    }
    @Override
    public Optional<Task> save(Task task) {
        try {
            updateTasksTags(task);
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

    public List<Task> findAll() {
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            return entityManager.createQuery("from Task", Task.class).getResultList();
        }catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
    public Optional<Task> findById(Long id){
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Task task= entityManager.createQuery("from Task where id = :id", Task.class)
                    .setParameter("id",id)
                    .getResultList().get(0);
            return Optional.of(task);
        }catch (Exception e) {
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }

    public Optional<Task> update(Task task) {
        try {
            updateTasksTags(task);

            entityManager.merge(task);

            transaction.commit();
            return Optional.of(task);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    private void updateTasksTags(Task task) {
        if (!transaction.isActive()) {
            transaction.begin();
        }

        if (task.getTages() != null) {
            for (int i = 0; i < task.getTages().size(); i++) {
                Tage tag = task.getTages().get(i);
                if (tag.getId() != null) {
                    task.getTages().set(i, entityManager.merge(tag));
                } else {
                    entityManager.persist(tag);
                }
            }
        }
    }

}
