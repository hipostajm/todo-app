package org.todo.gateway.repository;

import org.todo.gateway.model.Task;

import java.util.UUID;

public interface TaskRepository {
    Task getTaskByID(UUID id);
    Task createTask(Task task);
}
