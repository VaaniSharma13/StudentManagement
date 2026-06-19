package com.proj.StudentManagement.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String status;
    @ManyToOne
    @JoinColumn(name = "stud_id")
    private Stud stud;

    public Integer getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getStatus(){
        return status;
    }
    public Stud getStud(){
        return stud;
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
    public void setStud(Stud stud){
        this.stud = stud;
    }
}