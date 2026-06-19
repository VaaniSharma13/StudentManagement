package com.proj.StudentManagement.service;

import com.proj.StudentManagement.entity.Stud;
import com.proj.StudentManagement.repository.StudRepo;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudService {
    @Autowired
    private StudRepo studRepo;
    public List<Stud> getAllStud(){
        return studRepo.findAll();
    }
    public Stud getStudById(Integer id){
        return studRepo.findById(id).orElse(null);
    }
    public Stud addStud(Stud stud){
        return studRepo.save(stud);
    }
    public Stud updateStud(Integer id, Stud updatedStud){
        Stud existing= getStudById(id);
        existing.setName(updatedStud.getName());
        existing.setMail(updatedStud.getMail());
        existing.setStudClass(updatedStud.getStudClass());
        return studRepo.save(existing);
    }
    public void deleteStud(Integer id){
        studRepo.deleteById(id);
    }
}
