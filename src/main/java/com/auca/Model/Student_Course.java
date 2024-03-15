package com.auca.Model;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "student_course")
public class Student_Course {
    @Id
    @GeneratedValue ( strategy = GenerationType.SEQUENCE , generator = "StudentCourse_seq" )
    @SequenceGenerator(name = "StudentCourse_seq", sequenceName = "student_course_seq", allocationSize = 1)
    private int regID;
    @ManyToOne
    @JoinColumn(name = "registration_id")
    private StudentRegistration studentRegistration;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course ;


    public Student_Course() {
    }

    public Student_Course(int regID) {
        this.regID = regID;
    }

    public Student_Course(int regID, StudentRegistration studentRegistration, Course course) {
        this.regID = regID;
        this.studentRegistration = studentRegistration;
        this.course = course;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public StudentRegistration getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(StudentRegistration studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
