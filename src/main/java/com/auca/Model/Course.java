package com.auca.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID course_id;
    private String course_code;
    private String course_name;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Academic_Unit academic_Unit;

    public Course() {
    }

    public Course(UUID course_id) {
        this.course_id = course_id;
    }

    public Course(UUID course_id, String course_code, String course_name, Semester semester, Academic_Unit academic_Unit, List<StudentRegistration> studentRegistrations) {
        this.course_id = course_id;
        this.course_code = course_code;
        this.course_name = course_name;
        this.semester = semester;
        this.academic_Unit = academic_Unit;
    }

    public UUID getCourse_id() {
        return course_id;
    }

    public void setCourse_id(UUID course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
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

    public Academic_Unit getAcademic_Unit() {
        return academic_Unit;
    }

    public void setAcademic_Unit(Academic_Unit academic_Unit) {
        this.academic_Unit = academic_Unit;
    }

}
