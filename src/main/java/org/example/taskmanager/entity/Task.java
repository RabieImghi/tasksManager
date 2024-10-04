package org.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Data
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate creationDate;
    private LocalDate endDate;
    private boolean isCompleted;
    private boolean isChanged;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "assignee_to")
    private User assigneeTo;

    public Task(String title, String description, LocalDate creationDate, LocalDate endDate, boolean isCompleted, boolean isChanged, User user, User assigneeTo) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.isCompleted = isCompleted;
        this.isChanged = isChanged;
        this.user = user;
        this.assigneeTo = assigneeTo;
    }
    public Task() {}
}
