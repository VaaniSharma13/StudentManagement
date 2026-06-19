package com.proj.StudentManagement.service;

import com.proj.StudentManagement.dto.TaskReqDto;
import com.proj.StudentManagement.dto.TaskResponseDto;
import com.proj.StudentManagement.entity.Stud;
import com.proj.StudentManagement.entity.Task;
import com.proj.StudentManagement.repository.StudRepo;
import com.proj.StudentManagement.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private StudRepo studRepo;
    public TaskResponseDto createTask(TaskReqDto dto) {
        Stud stud = studRepo.findById(dto.getStudId()).orElse(null);
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setStatus(dto.getStatus());
        task.setStud(stud);
        Task savedTask = taskRepo.save(task);
        return convertToDto(savedTask);
    }
    public List<TaskResponseDto> getAllTasks() {
        List<Task> tasks = taskRepo.findAll();
        List<TaskResponseDto> responseList = new ArrayList<>();
        for (Task task : tasks) {
            responseList.add(convertToDto(task));
        }
        return responseList;
    }
    public TaskResponseDto getTaskById(Integer id) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task == null) {
            return null;
        }
        return convertToDto(task);
    }
    public TaskResponseDto updateTask(Integer id, TaskReqDto dto) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task == null) {
            return null;
        }
        task.setTitle(dto.getTitle());
        task.setStatus(dto.getStatus());
        Task updatedTask = taskRepo.save(task);
        return convertToDto(updatedTask);
    }
    public void deleteTask(Integer id) {
        taskRepo.deleteById(id);
    }
    private TaskResponseDto convertToDto(Task task) {
        TaskResponseDto dto = new TaskResponseDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setStatus(task.getStatus());
        if (task.getStud() != null) {
            dto.setStudId(task.getStud().getId());
        }
        return dto;
    }
}