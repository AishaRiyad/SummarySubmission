package com.example.taskflow.repository;

import com.example.taskflow.model.entity.Project;
import com.example.taskflow.model.entity.Task;
import com.example.taskflow.model.entity.TaskStatus;
import com.example.taskflow.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject(Project project);

    List<Task> findByAssignee(User assignee);

    List<Task> findByStatus(TaskStatus status);
}
