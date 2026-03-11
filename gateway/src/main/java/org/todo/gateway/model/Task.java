package org.todo.gateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;



@Getter
@Setter
@ToString
public class Task {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime endTime;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime startTime;
    private PriorityLevel priority;

    public Task(UUID id, String name, String description, LocalDateTime endTime, PriorityLevel priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.endTime = endTime;
        this.priority = priority;
    }

    public Task() {
        this.id = UUID.randomUUID();
        this.name = UUID.randomUUID().toString();
        this.description = UUID.randomUUID().toString();
        this.endTime = LocalDateTime.now();
        this.priority = PriorityLevel.LOW;
    }
}
