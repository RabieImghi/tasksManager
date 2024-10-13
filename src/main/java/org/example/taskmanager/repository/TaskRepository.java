package org.example.taskmanager.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.taskmanager.entity.Tage;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.impl.TaskRepositoryImpl;

import java.time.LocalDate;
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
            List<Task> taskList =entityManager.createQuery("from Task t where t.isDeleted = false ", Task.class).getResultList();
            taskList.forEach(task -> {
                entityManager.refresh(task);
            });
            return taskList;
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
            entityManager.refresh(task);
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

    public Optional<Task> delete(Task task) {
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            entityManager.remove(task);
            transaction.commit();
            return Optional.of(task);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
    public  List<Task> statManager(User manager, LocalDate startDate, LocalDate endDate, List<String> tags){
        try {
            if (!transaction.isActive()) transaction.begin();
            String str = "SELECT t FROM Task t JOIN t.tages tag WHERE t.user = :user AND t.creationDate BETWEEN :startDate AND :endDate";
            if (tags != null && !tags.isEmpty()) {
                str += " AND tag.name IN :tags";
            }

            var query = entityManager.createQuery(str, Task.class);
            query.setParameter("user", manager);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);

            if (tags != null && !tags.isEmpty()) {
                query.setParameter("tags", tags);
            }

            return query.getResultList();
        }catch (Exception e){
            if (transaction.isActive()) transaction.rollback();
            throw e;
        }
    }

}
