package com.proj.StudentManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Email(message = "enter email")
    @NotNull(message = "email required")
    @Column(unique = true)
    private String email;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "password should be 8 char, with 1 special char, no. and alphabet"
    )
    @NotBlank(message = "password required")
    private String pswd;
    public Integer getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getPswd(){
        return pswd;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPswd(String pswd){
        this.pswd = pswd;
    }
}