package org.example.taskmanager.repository;

import jakarta.persistence.*;
import org.example.taskmanager.entity.Task;
import org.example.taskmanager.entity.TaskHistory;
import org.example.taskmanager.entity.User;
import org.example.taskmanager.repository.impl.TaskHistoryRepositoryImpl;
import org.example.taskmanager.util.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            List<TaskHistory> taskHistoryList;
            if(typeModification.equals("change")){
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime minus120Seconds = now.minusSeconds(121);
                taskHistoryList=   entityManager
                        .createQuery("FROM TaskHistory th WHERE th.oldUser.id = :userId AND th.modificationDate BETWEEN :minus120Seconds AND :now AND th.typeModification = :typeModification", TaskHistory.class)
                        .setParameter("userId", user.getId())
                        .setParameter("minus120Seconds", minus120Seconds)
                        .setParameter("now", now)
                        .setParameter("typeModification", typeModification)
                        .getResultList();
            }else {
                LocalDate startDateMonth = YearMonth.now().atDay(1);
                LocalDate endMonthDay = YearMonth.now().atEndOfMonth();
                String que = "FROM TaskHistory th where th.task.assigneeTo.id = : userId " +
                        "AND th.modificationDate BETWEEN :startDateMonth AND :endMonthDay " +
                        "AND th.typeModification = :typeModification";
                taskHistoryList = entityManager
                        .createQuery(que, TaskHistory.class)
                        .setParameter("userId",user.getId())
                        .setParameter("startDateMonth", startDateMonth )
                        .setParameter("endMonthDay", endMonthDay)
                        .setParameter("typeModification",typeModification)
                        .getResultList();
            }
            taskHistoryList.forEach(taskHistory -> entityManager.refresh(taskHistory));
            return taskHistoryList;


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
            List<TaskHistory> taskHistoryList = entityManager
                    .createQuery("FROM TaskHistory th where th.task.user.id = :id and th.typeModification = :type " +
                            " and th.task.isChanged = :isChanged ", TaskHistory.class)
                    .setParameter("id", user.getId())
                    .setParameter("type", "change")
                    .setParameter("isChanged", false)
                    .getResultList();
            taskHistoryList.forEach(taskHistory -> entityManager.refresh(taskHistory));
            return taskHistoryList;
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
            taskHistory.ifPresent(taskHistory1 -> entityManager.refresh(taskHistory1));
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
            entityManager.merge(taskHistory);
            Optional<TaskHistory> taskHistoryUpdated= Optional.of(taskHistory);
            transaction.commit();
            return taskHistoryUpdated;
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
    public List<TaskHistory> getAllTaskHistoryForChangeStatus(User user){
        try {
            if(!transaction.isActive()){
                transaction.begin();
            }
            List<TaskHistory> list = entityManager
                    .createQuery("FROM TaskHistory th where th.oldUser.id = :id", TaskHistory.class)
                    .setParameter("id",user.getId())
                    .getResultList();
            list.forEach(taskHistory -> entityManager.refresh(taskHistory));
            return list;
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
    public List<TaskHistory> getAllTaskHistory(){
        try {
            if(!transaction.isActive()){
                transaction.begin();
            }
            List<TaskHistory> taskHistoryList = entityManager
                    .createQuery("from TaskHistory th",TaskHistory.class)
                    .getResultList();
            taskHistoryList.forEach(taskHistory -> entityManager.refresh(taskHistory));
            transaction.commit();
            return taskHistoryList;
        }catch (Exception e){
            if(transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
