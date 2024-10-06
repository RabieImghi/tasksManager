package org.example.taskmanager.repository.impl;

import org.example.taskmanager.entity.Tage;

import java.util.List;
import java.util.Optional;

public interface TageRepositoryImpl {
    List<Tage> findAll();
    Optional<Tage> findById(Long id);
}
