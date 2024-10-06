package org.example.taskmanager.service.impl;

import org.example.taskmanager.entity.Tage;

import java.util.List;
import java.util.Optional;

public interface TageServiceImpl {
    List<Tage> findAll();
    Optional<Tage> findById(Long id);
}
