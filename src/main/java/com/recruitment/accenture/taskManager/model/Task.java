package com.recruitment.accenture.taskManager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean isDone;
    @ManyToOne(targetEntity = TaskList.class, fetch = FetchType.LAZY)
    @JsonBackReference
    private TaskList taskList;
}