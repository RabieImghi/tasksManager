package org.example.taskmanager.repository;

import jakarta.persistence.*;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.repository.impl.TaskHistoryRepositoryImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class TaskHistoryRepository implements TaskHistoryRepositoryImpl {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public TaskHistoryRepository(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("myJPAUnit");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.transaction = entityManager.getTransaction();
    }


    @Override
    public List<TaskHistory> getTaskHistoryByTaskId(Task task) {
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            LocalDate today = LocalDate.now();
            List<TaskHistory> listTask =   entityManager
                    .createQuery("FROM TaskHistory th WHERE th.task.assigneeTo.id = :userId AND th.modificationDate = :today", TaskHistory.class)
                    .setParameter("userId", task.getAssigneeTo().getId())
                    .setParameter("today", today)
                    .getResultList();
            return listTask;
        }catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Optional<TaskHistory> save(TaskHistory taskHistory){
        try {
            if(!transaction.isActive()){
                transaction.begin();
            }
            entityManager.persist(taskHistory);
            transaction.commit();
            return Optional.of(taskHistory);
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
}
