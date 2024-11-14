package com.example.StudentManagementSystem.controller;
import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent (@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
    }

    // Get All Rest API
    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    // Get by ID Rest API
    @GetMapping("{id}")
    // localhost:8080/api/employees/1
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentID) {
        return new ResponseEntity<Student>(studentService.getStudentById(studentID), HttpStatus.OK);
    }

    // Update Rest API
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    // Delete Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted successfully.", HttpStatus.OK);
    }

    // Find student by year of enrollment
    @GetMapping("/year/{YOE}")
    public ResponseEntity<List<Student>> getStudentByYOE(@PathVariable("YOE") String YOE) {
        return new ResponseEntity<>(studentService.getStudentByYOE(YOE), HttpStatus.OK);
    }

    // Find department given student ID
    @GetMapping("/{id}/Dept")
    public ResponseEntity<String> getDeptById(@PathVariable("id") long id) {
        return new ResponseEntity<>(studentService.getDeptById(id), HttpStatus.OK);
    }

    // Delete student by year of enrollment
    @DeleteMapping("/year/{YOE}")
    public ResponseEntity<String> deleteStudentByYOE(@PathVariable("YOE") String YOE) {
        studentService.deleteStudentByYOE(YOE);
        return new ResponseEntity<String>("Students enrolled in the year " +YOE+ " were deleted successfully.", HttpStatus.OK);
    }
}
