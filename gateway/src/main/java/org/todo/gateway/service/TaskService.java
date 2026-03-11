package org.todo.gateway.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.todo.gateway.model.Task;

import java.util.UUID;

public interface TaskService {
    Task getTask(UUID id);
    Task createTask(Task task);
}
