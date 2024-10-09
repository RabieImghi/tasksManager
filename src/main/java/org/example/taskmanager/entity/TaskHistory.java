package org.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "task_history")
@Getter
@Setter
@EqualsAndHashCode
public class TaskHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeModification;
    private LocalDate modificationDate;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User oldUser;

    private boolean approve;

    public TaskHistory(String typeModification, LocalDate modificationDate, Task task,User oldUser, boolean approve) {
        this.typeModification = typeModification;
        this.modificationDate = modificationDate;
        this.task = task;
        this.oldUser = oldUser;
        this.approve = approve;
    }

    public TaskHistory() {}
}
