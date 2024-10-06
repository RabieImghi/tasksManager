package org.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tages")
@Data
public class Tage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "tages")
    private List<Task> tasks;

    public Tage(String name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }
    public Tage() {}
}
