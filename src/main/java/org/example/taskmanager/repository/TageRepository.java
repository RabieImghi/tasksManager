package org.example.taskmanager.repository;

import jakarta.persistence.*;
import org.example.taskmanager.entity.Tage;
import org.example.taskmanager.repository.impl.TageRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class TageRepository implements TageRepositoryImpl {
    EntityManagerFactory emf;
    EntityManager em;

    public TageRepository() {
        emf = Persistence.createEntityManagerFactory("myJPAUnit");
        em = emf.createEntityManager();
    }

    public void save(Tage tage){
        EntityTransaction tx = em.getTransaction();
        try {
            if(!tx.isActive()){
                tx.begin();
            }
            em.persist(tage);
            tx.commit();
        }catch (Exception e){
            if(tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }
    }
    public List<Tage> findAll(){
        EntityTransaction tx = em.getTransaction();
        try {
            if(!tx.isActive()){
                tx.begin();
            }
            return em.createQuery("from Tage", Tage.class).getResultList();
        }catch (Exception e){
            if(tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }
    }
    public Optional<Tage> findById(Long id){
        EntityTransaction tx = em.getTransaction();
        try {
            if(!tx.isActive()){
                tx.begin();
            }
            return Optional.of(em.find(Tage.class, id));
        }catch (Exception e){
            if(tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }
    }
}

