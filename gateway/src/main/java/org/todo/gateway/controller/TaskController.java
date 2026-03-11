package org.todo.gateway.controller;

import org.springframework.web.bind.annotation.*;
import org.todo.gateway.model.Task;
import org.todo.gateway.service.TaskService;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable UUID id) {
        return this.taskService.getTask(id);
    }

    @PostMapping("/task")
    public Task createTask(@RequestBody Task task) {
        task.setId(UUID.randomUUID());
        task.setStartTime(LocalDateTime.now());
        return this.taskService.createTask(task);
    }
}
