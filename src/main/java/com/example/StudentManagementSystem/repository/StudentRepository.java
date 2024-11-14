package com.example.StudentManagementSystem.repository;
import com.example.StudentManagementSystem.model.Student;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface StudentRepository extends JpaRepository<Student,Long> {
    // Find student by year of enrollment
    List <Student> findByYOE(String YOE);
    // Find department given student ID
    String getDeptById(long id);
    // Delete student by year of enrollment
    @Modifying
    @Transactional
    void deleteByYOE(String YOE);
}
