package com.recruitment.accenture.taskManager.controller;

import com.recruitment.accenture.taskManager.model.Task;
import com.recruitment.accenture.taskManager.model.TaskList;
import com.recruitment.accenture.taskManager.repository.TaskListRepository;
import com.recruitment.accenture.taskManager.repository.TaskRepository;
import com.recruitment.accenture.taskManager.service.TaskListService;
import com.recruitment.accenture.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/task"})
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskListService taskListService;

    @GetMapping
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable(name="id") Long id){
        return taskService.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TaskList create(@RequestBody Task task){
        TaskList taskList = this.taskListService.findById(task.getTaskList().getId()).get();
        taskList.getTasks().add(task);
        task.setTaskList(taskList);
        this.taskService.addTask(task);
        return this.taskListService.createTaskList(taskList);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable(name="id") long id,
                                 @RequestBody Task task) {
        return taskService.findById(id)
                .map(t -> {
                    t.setTitle(task.getTitle());
                    t.setDescription(task.getDescription());
                    t.setDone(true);
                    Task updated = taskService.taskDone(t);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return taskService.findById(id)
                .map(task -> {
                    taskService.delete(task.getId());
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
