package com.recruitment.accenture.taskManager.service;

import com.recruitment.accenture.taskManager.model.TaskList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TaskListService {
    List<TaskList> findAll();
    Optional<TaskList> findById(Long id);
    TaskList createTaskList(TaskList taskList);
    TaskList updateTaskList(TaskList taskList);
}
