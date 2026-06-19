package com.proj.StudentManagement.controller;
import com.proj.StudentManagement.entity.Stud;
import com.proj.StudentManagement.service.StudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import  java.util.List;
@RestController
@RequestMapping("/student")
public class StudController {
    @Autowired
    private StudService studService;
    @GetMapping
    public List<Stud> getAllStud(){
        return studService.getAllStud();
    }
    @GetMapping("/{id}")
    public Stud getStudById(@PathVariable Integer id ){
        return studService.getStudById(id);
    }
    @PostMapping
    public Stud addStud(@RequestBody Stud stud){
        return studService.addStud(stud);
    }
    @PutMapping("/{id}")
    public Stud updateStud(@PathVariable Integer id, @RequestBody Stud updatedStud){
        return studService.updateStud(id,updatedStud);
    }
    @DeleteMapping("/{id}")
    public void deleteStud(@PathVariable Integer id){
        studService.deleteStud(id);
    }

}
