package com.example.StudentManagementSystem.service;
import com.example.StudentManagementSystem.model.Student;
import java.util.List;

public interface StudentService {
    Student saveStudent (Student student);
    List<Student> getAllStudents();
    Student getStudentById(long id);
    Student updateStudent(Student student, long id);
    void deleteStudent (long id);

    // Find student by year of enrollment
    List<Student> getStudentByYOE(String YOE);
    // Find department given student ID
    String getDeptById(long id);
    // Delete student by year of enrollment
    void deleteStudentByYOE(String YOE);
}
