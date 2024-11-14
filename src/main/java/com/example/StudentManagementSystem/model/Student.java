package com.example.StudentManagementSystem.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "first_name", nullable = false)
    private String firstName;
    @Column (name = "last_name", nullable = false)
    private String lastName;
    @Column (name = "email_id", nullable = false, unique = true)
    private String email;
    @Column (name = "department", nullable = false)
    private String Dept;
    @Column (name = "year_of_enrollment", nullable = false)
    private String YOE;
}
