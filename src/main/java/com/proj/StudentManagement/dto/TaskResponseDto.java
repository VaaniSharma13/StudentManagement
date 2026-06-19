package com.proj.StudentManagement.dto;
public class TaskResponseDto {
    private Integer id;
    private String title;
    private String status;
    private Integer studId;

    public Integer getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getStatus(){
        return status;
    }
    public Integer getStudId(){
        return studId;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setStudId(Integer studId){
        this.studId = studId;
    }
}