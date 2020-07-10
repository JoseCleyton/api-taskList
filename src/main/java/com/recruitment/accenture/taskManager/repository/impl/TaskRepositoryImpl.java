package com.recruitment.accenture.taskManager.repository.impl;

import com.recruitment.accenture.taskManager.model.Task;
import com.recruitment.accenture.taskManager.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class TaskRepositoryImpl implements TaskRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Task> findAll() {
        return this.em.createQuery("SELECT t FROM Task t").getResultList();
    }

    @Override
    public Optional<Task> findById(Long id) {
       return Optional.ofNullable(this.em.find(Task.class, id));
    }

    @Override
    public Task addTask(Task task) {
        this.em.persist(task);
        return task;
    }

    @Override
    public void delete(Long id) {
        this.em.remove(this.em.find(Task.class, id));
    }

    @Override
    public Task taskDone(Task task) {
        this.em.persist(task);
        return task;
    }
}
