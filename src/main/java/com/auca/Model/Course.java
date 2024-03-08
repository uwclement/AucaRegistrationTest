package com.auca.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int course_id;
    private char course_code;
    private String course_name;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    private int department_id;

}
