package org.example.taskmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.taskmanager.util.TaskStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "task_tag",
            joinColumns = @JoinColumn(name = "tasks_id"),
            inverseJoinColumns = @JoinColumn(name = "tage_id")
    )
    private List<Tage> tages;

    @Enumerated(EnumType.STRING)
    private TaskStatus isCompleted;

    private boolean isChanged;
    private boolean isDeleted;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "assignee_to")
    private User assigneeTo;

    public Task(String title, String description, LocalDate creationDate, LocalDate endDate, TaskStatus isCompleted, boolean isChanged, User user, User assigneeTo,List<Tage> listTages, boolean isDeleted) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.isCompleted = isCompleted;
        this.isChanged = isChanged;
        this.user = user;
        this.assigneeTo = assigneeTo;
        this.tages = listTages;
        this.isDeleted = isDeleted;
    }
    public Task() {}
}
