package com.proj.StudentManagement.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fileName;
    private String fileType;
    private String filePath;
    @ManyToOne
    @JoinColumn(name = "stud_id")
    private Stud stud;
    public Integer getId() {
        return id;
    }
    public String getFileName(){
        return fileName;
    }
    public String getFileType(){
        return fileType;
    }
    public String getFilePath(){
        return filePath;
    }
    public Stud getStud(){
        return stud;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public void setFileType(String fileType){
        this.fileType = fileType;
    }
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }
    public void setStud(Stud stud){
        this.stud = stud;
    }
}