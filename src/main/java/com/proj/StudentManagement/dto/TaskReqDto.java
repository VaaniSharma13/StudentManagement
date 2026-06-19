package com.proj.StudentManagement.dto;

import jakarta.validation.constraints.NotBlank;

public class TaskReqDto {
    @NotBlank(message = "title required")
    private String title;
    @NotBlank(message = "status required")
    private String status;
    @NotBlank(message = "stud id required")
    private Integer studId;
    public String getTitle() {
        return title;
    }
    public String getStatus() {
        return status;
    }
    public Integer getStudId() {
        return studId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setStudId(Integer studId) {
        this.studId = studId;
    }
}