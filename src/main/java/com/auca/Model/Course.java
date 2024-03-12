package com.auca.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int course_id;
    private char course_code;
    private String course_name;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    private int department_id;
    @ManyToOne
    @JoinColumn(name = "academic_unit_id")
    private Academic_Unit academic_Unit;


    public Course() {
    }

    public Course(int course_id) {
        this.course_id = course_id;
    }

    public Course(int course_id, char course_code, String course_name, Semester semester, int department_id) {
        this.course_id = course_id;
        this.course_code = course_code;
        this.course_name = course_name;
        this.semester = semester;
        this.department_id = department_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public char getCourse_code() {
        return course_code;
    }

    public void setCourse_code(char course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
