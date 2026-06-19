package com.proj.StudentManagement.controller;

import com.proj.StudentManagement.dto.TaskReqDto;
import com.proj.StudentManagement.dto.TaskResponseDto;
import com.proj.StudentManagement.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController{
    @Autowired
    private TaskService taskService;
    @PostMapping
    public TaskResponseDto createTask(@Valid @RequestBody TaskReqDto dto){
        return taskService.createTask(dto);
    }
    @GetMapping
    public List<TaskResponseDto> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public TaskResponseDto getTaskById(@PathVariable Integer id){
        return taskService.getTaskById(id);
    }
    @PutMapping("/{id}")
    public TaskResponseDto updateTask(
            @PathVariable Integer id,
            @Valid @RequestBody TaskReqDto dto){
        return taskService.updateTask(id,dto);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return "task deleted";
    }
}