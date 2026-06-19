package com.proj.StudentManagement.repository;

import com.proj.StudentManagement.entity.Stud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudRepo extends JpaRepository<Stud, Integer> {
}
