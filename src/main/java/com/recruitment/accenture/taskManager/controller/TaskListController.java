package com.recruitment.accenture.taskManager.controller;

import com.recruitment.accenture.taskManager.model.TaskList;
import com.recruitment.accenture.taskManager.repository.impl.TaskListRepositoryImpl;
import com.recruitment.accenture.taskManager.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/taskList"})
@CrossOrigin
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @GetMapping
    public List<TaskList> findAll(){
        return taskListService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return taskListService.findById(id)
                .map(taskList -> ResponseEntity.ok().body(taskList))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public TaskList create(@RequestBody TaskList taskList){
        return taskListService.createTaskList(taskList);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody TaskList taskList) {
        return taskListService.findById(id)
                .map(taskL -> {
                    taskL.setTitle(taskList.getTitle());
                    taskL.setDescription(taskList.getDescription());
                    TaskList updated = taskListService.updateTaskList(taskL);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

}
