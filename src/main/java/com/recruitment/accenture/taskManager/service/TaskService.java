package com.recruitment.accenture.taskManager.service;

import com.recruitment.accenture.taskManager.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task addTask(Task task);
    Task taskDone(Task task);
    void delete(Long id);
}
