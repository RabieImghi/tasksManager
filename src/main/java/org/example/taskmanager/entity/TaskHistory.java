package org.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "task_history")
@Data
public class TaskHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeModification;
    private LocalDate modificationDate;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public TaskHistory(String typeModification, LocalDate modificationDate, Task task) {
        this.typeModification = typeModification;
        this.modificationDate = modificationDate;
        this.task = task;
    }

    public TaskHistory() {}
}
