package com.auca.Model;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.auca.Dao.HibernateUtil;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="studentRegistration")
public class StudentRegistration {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID registration_id;

    private char registration_code;
    private Timestamp registration_date;
    @OneToOne
    @JoinColumn(name ="student_id")
    private Student student;
    @OneToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Academic_Unit academic_Unit;
    @ManyToMany
    @JoinTable( name = "student_course" ,
    joinColumns = @JoinColumn(name = "registration_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
   private List<Course> courses;

    public StudentRegistration() {
    }

    public StudentRegistration(UUID registration_id) {
        this.registration_id = registration_id;
    }

    public UUID getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(UUID registration_id) {
        this.registration_id = registration_id;
    }

    public char getRegistration_code() {
        return registration_code;
    }

    public void setRegistration_code(char registration_code) {
        this.registration_code = registration_code;
    }

    public Timestamp getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Timestamp registration_date) {
        this.registration_date = registration_date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
