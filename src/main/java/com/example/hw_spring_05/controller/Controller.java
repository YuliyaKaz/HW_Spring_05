package com.example.hw_spring_05.controller;

import com.example.hw_spring_05.model.Task;
import com.example.hw_spring_05.model.TaskStatus;
import com.example.hw_spring_05.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class Controller {
    private final TaskService service;

    @Autowired // Внедрение зависимости
    public Controller(TaskService service) {
        this.service = service;
    }
    //просмотр всех задач
    @GetMapping
    public List<Task> getAllTask() {
        return  service.getAllTasks();
    }
    //добавление задачи
    @PostMapping
    public Task addNewTask(@RequestBody Task task) {
        return service.save(task);
    }
    //просмотр задач по статусу
    @GetMapping("/status/{id}")
    public List<Task> getAllTasks(@PathVariable TaskStatus status) {
        return service.getTaskByStatus(status);
    }
    //Изменение статуса задачи
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    //удаление задачи
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
