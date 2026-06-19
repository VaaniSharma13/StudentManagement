package com.proj.StudentManagement.repository;

import com.proj.StudentManagement.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface FileRepo extends JpaRepository<File,Integer> {
    List<File> findByStudId(Integer studId);

}