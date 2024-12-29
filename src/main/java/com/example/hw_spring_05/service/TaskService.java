package com.example.hw_spring_05.service;

import com.example.hw_spring_05.model.Task;
import com.example.hw_spring_05.model.TaskStatus;
import com.example.hw_spring_05.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repository;
    public TaskService(TaskRepository taskRepository) {
        this.repository = taskRepository;
    }
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public List<Task> getTaskByStatus(TaskStatus taskStatus) {
        if (taskStatus == null) {
            throw new IllegalArgumentException("Task status must not be null");
        }
        return repository.findByStatus(taskStatus);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            return repository.save(task);
        }else {
            throw new IllegalArgumentException("Не удалось распознать задачу");
        }
    }
    public void deleteTask(Long id) {
        repository.delete(repository.getReferenceById(id));
    }

}
