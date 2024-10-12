package org.example.taskmanager.service;

import org.example.taskmanager.entity.Tage;
import org.example.taskmanager.repository.TageRepository;
import org.example.taskmanager.service.impl.TageServiceImpl;

import java.util.List;
import java.util.Optional;

public class TageService implements TageServiceImpl {
    TageRepository tageRepository;
    public TageService() {
        tageRepository = new TageRepository();
    }
    public List<Tage> findAll(){
        return tageRepository.findAll();
    }
    public Optional<Tage> findById(Long id){
        return tageRepository.findById(id);
    }
    public Optional<Tage> findByName(String name){
        return tageRepository.findByName(name);
    }
    public Optional<Tage> save(Tage tage){
        return tageRepository.save(tage);
    }
    public Optional<Tage> delete(Tage tage){
        return tageRepository.delete(tage);
    }
    public Optional<Tage> update(Tage tage){
        return tageRepository.update(tage);
    }

}
