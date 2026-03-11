package org.todo.gateway.service;

import org.springframework.stereotype.Service;
import org.todo.gateway.exception.ToOldEndDateException;
import org.todo.gateway.model.Task;
import org.todo.gateway.repository.TaskRepository;

import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task getTask(UUID id) {
        return this.taskRepository.getTaskByID(id);
    }

    @Override
    public Task createTask(Task task) {

        if(task.getStartTime() != null && task.getStartTime().isAfter(task.getEndTime())){
            throw new ToOldEndDateException("To old end date");
        }

        return this.taskRepository.createTask(task);
    }
}
