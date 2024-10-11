package org.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime modificationDate;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User oldUser;

    private boolean requestStatusAccept;

    public TaskHistory(String typeModification, LocalDateTime modificationDate, Task task,User oldUser, boolean requestStatusAccept) {
        this.typeModification = typeModification;
        this.modificationDate = modificationDate;
        this.task = task;
        this.oldUser = oldUser;
        this.requestStatusAccept = requestStatusAccept;
    }

    public TaskHistory() {}
}
