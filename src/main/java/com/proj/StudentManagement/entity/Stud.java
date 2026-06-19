package com.proj.StudentManagement.entity;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "student")
public class Stud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String mail;
    private String studClass;
    @OneToMany(mappedBy = "stud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;
    @OneToMany(mappedBy = "stud", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files;
    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getMail(){
        return mail;
    }
    public String getStudClass(){
        return studClass;
    }
    public List<Task> getTasks(){
        return tasks;
    }
    public List<File> getFiles(){
        return files;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public void setStudClass(String studClass){
        this.studClass = studClass;
    }
    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
    }
    public void setFiles(List<File> files){
        this.files = files;
    }
}