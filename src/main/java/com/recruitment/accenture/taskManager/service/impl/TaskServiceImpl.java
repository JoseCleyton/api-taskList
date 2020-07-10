package com.recruitment.accenture.taskManager.service.impl;

import com.recruitment.accenture.taskManager.model.Task;
import com.recruitment.accenture.taskManager.repository.TaskRepository;
import com.recruitment.accenture.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.taskRepository.findById(id)
                .map(task -> Optional.of(task))
                .orElse(Optional.empty());
    }

    @Override
    public Task addTask(Task task) {
        return this.taskRepository.addTask(task);
    }

    @Override
    public Task taskDone(Task task) {
        return this.taskRepository.taskDone(task);
    }

    @Override
    public void delete(Long id) {
        this.taskRepository.delete(id);
    }
}
