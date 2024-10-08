package org.example.taskmanager.repository;

import jakarta.persistence.*;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.impl.TaskHistoryRepositoryImpl;

import java.time.LocalDate;
import java.time.YearMonth;
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
    public List<TaskHistory> getTaskHistoryByTaskId(User user, String typeModification) {
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            if(typeModification.equals("change")){
                LocalDate today = LocalDate.now();
                return   entityManager
                        .createQuery("FROM TaskHistory th WHERE th.oldUser.id = :userId AND th.modificationDate = :today AND th.typeModification = :typeModification", TaskHistory.class)
                        .setParameter("userId", user.getId())
                        .setParameter("today", today)
                        .setParameter("typeModification", typeModification)
                        .getResultList();
            }else {
                LocalDate startDateMonth = YearMonth.now().atDay(1);
                LocalDate endMonthDay = YearMonth.now().atEndOfMonth();
                String que = "FROM TaskHistory th where th.task.assigneeTo.id = : userId " +
                        "AND th.modificationDate BETWEEN :startDateMonth AND :endMonthDay " +
                        "AND th.typeModification = :typeModification";
                return entityManager
                        .createQuery(que, TaskHistory.class)
                        .setParameter("userId",user.getId())
                        .setParameter("startDateMonth", startDateMonth )
                        .setParameter("endMonthDay", endMonthDay)
                        .setParameter("typeModification",typeModification)
                        .getResultList();
            }

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
    public List<TaskHistory> findAll(User user){
        try {
            if(!transaction.isActive()){
                transaction.begin();
            }
            return entityManager
                    .createQuery("FROM TaskHistory th where th.task.user.id = :id and th.typeModification = :type " +
                            " and th.task.isChanged = :isChanged ", TaskHistory.class)
                    .setParameter("id", user.getId())
                    .setParameter("type", "change")
                    .setParameter("isChanged", false)
                    .getResultList();
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
    public Optional<TaskHistory> findById(Long id){
        try {
            if(!transaction.isActive()){
                transaction.begin();
            }
            Optional<TaskHistory> taskHistory = Optional.of(entityManager.find(TaskHistory.class, id));
            transaction.commit();
            return taskHistory;
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
    public Optional<TaskHistory> update(TaskHistory taskHistory){
        try {
            if (!transaction.isActive()){
                transaction.begin();
            }
            Optional<TaskHistory> taskHistoryUpdated= Optional.of(entityManager.merge(taskHistory));
            transaction.commit();
            return taskHistoryUpdated;
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
}
