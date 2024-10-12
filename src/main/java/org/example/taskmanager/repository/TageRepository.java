package org.example.taskmanager.repository;

import jakarta.persistence.*;
import org.example.taskmanager.entity.Tage;
import org.example.taskmanager.entity.Task;
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

    public Optional<Tage> save(Tage tage){
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
        return Optional.of(tage);
    }
    public Optional<Tage> delete(Tage tage){
        EntityTransaction tx = em.getTransaction();
        try {
            if(!tx.isActive()) tx.begin();
            Tage existingTage = em.find(Tage.class, tage.getId());
            if (existingTage != null) {
                for (Task task : existingTage.getTasks()) {
                    task.getTages().remove(existingTage);
                    em.merge(task);
                }
                em.remove(existingTage);
            }
            tx.commit();
            return Optional.of(tage);
        }catch (Exception e){
            if(tx.isActive())  tx.rollback();
            throw new RuntimeException(e);
        }
    }
    public Optional<Tage> update(Tage tage){
        EntityTransaction tx = em.getTransaction();
        try {
            if(!tx.isActive()) tx.begin();
            em.merge(tage);
            return Optional.of(tage);
        }catch (Exception e){
            if(tx.isActive())  tx.rollback();
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
    public Optional<Tage> findByName(String name) {
        EntityTransaction tr = em.getTransaction();
        try {
            if (!tr.isActive()) tr.begin();
            return Optional.of(
                    em.createQuery("from Tage t where t.name = :name", Tage.class)
                            .setParameter("name", name)
                            .getSingleResult()
            );
        } catch (NoResultException e) {
            if (tr.isActive()) tr.rollback();
            return Optional.empty();
        } catch (Exception e) {
            if (tr.isActive()) tr.rollback();
            throw e;
        }
    }
}

