package com.recruitment.accenture.taskManager.repository;

import com.recruitment.accenture.taskManager.model.Task;
import com.recruitment.accenture.taskManager.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TaskListRepository{
    List<TaskList> findAll();
    Optional<TaskList> findById(Long id);
    TaskList createTaskList(TaskList taskList);
    TaskList updateTaskList(TaskList taskList);
}
