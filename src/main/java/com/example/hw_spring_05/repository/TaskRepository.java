package com.example.hw_spring_05.repository;

import com.example.hw_spring_05.model.Task;
import com.example.hw_spring_05.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
