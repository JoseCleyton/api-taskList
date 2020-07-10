package com.recruitment.accenture.taskManager.repository.impl;

import com.recruitment.accenture.taskManager.model.TaskList;
import com.recruitment.accenture.taskManager.repository.TaskListRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class TaskListRepositoryImpl implements TaskListRepository {

    @PersistenceContext
    private EntityManager em;

    @Override

    public List<TaskList> findAll() {
        return this.em.createQuery("SELECT t FROM TaskList t").getResultList();
    }

    @Override
    public Optional<TaskList> findById(Long id) {
        return Optional.ofNullable(this.em.find(TaskList.class, id));
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        this.em.persist(taskList);
        return taskList;
    }

    @Override
    public TaskList updateTaskList(TaskList taskList) {
        this.em.persist(taskList);
        return taskList;
    }
}
