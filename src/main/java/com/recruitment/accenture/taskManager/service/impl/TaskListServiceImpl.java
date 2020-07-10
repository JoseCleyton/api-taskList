package com.recruitment.accenture.taskManager.service.impl;

import com.recruitment.accenture.taskManager.model.TaskList;
import com.recruitment.accenture.taskManager.repository.TaskListRepository;
import com.recruitment.accenture.taskManager.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskListServiceImpl implements TaskListService {
    @Autowired
    TaskListRepository taskListRepository;

    @Override
    public List<TaskList> findAll() {
        return this.taskListRepository.findAll();
    }

    @Override
    public Optional<TaskList> findById(Long id) {
        return this.taskListRepository.findById(id)
                .map(taskList -> Optional.of(taskList))
                .orElse(Optional.empty());
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        return  this.taskListRepository.createTaskList(taskList);
    }

    @Override
    public TaskList updateTaskList(TaskList taskList) {
        return this.taskListRepository.updateTaskList(taskList);
    }
}
