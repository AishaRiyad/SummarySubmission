package com.example.taskflow.repository;

import com.example.taskflow.model.entity.Project;
import com.example.taskflow.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByOwner(User owner);
}
