package com.proj.StudentManagement.repository;

import com.proj.StudentManagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TaskRepo extends JpaRepository<Task, Integer> {
}