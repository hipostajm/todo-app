package org.todo.gateway.repository;

import org.springframework.stereotype.Repository;
import org.todo.gateway.model.Task;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TaskRepositoryMemoryImpl implements TaskRepository {

    private Map<UUID, Task> taskMap;

    public TaskRepositoryMemoryImpl() {
        this.taskMap = new ConcurrentHashMap<>();
    }

    @Override
    public Task getTaskByID(UUID id) {
        return taskMap.get(id);
    }

    @Override
    public Task createTask(Task task) {
        taskMap.put(task.getId(), task);
        return task;
    }
}
