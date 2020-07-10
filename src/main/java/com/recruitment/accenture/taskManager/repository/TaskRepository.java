package com.recruitment.accenture.taskManager.repository;

import com.recruitment.accenture.taskManager.model.Task;
import com.recruitment.accenture.taskManager.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository{
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task addTask(Task task);
    void delete(Long id);
    Task taskDone(Task task);
}
