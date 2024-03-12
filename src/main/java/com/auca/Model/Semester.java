package com.auca.Model;

import com.auca.Dao.HibernateUtil;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "semester_seq")
    @SequenceGenerator(name = "semester_seq", sequenceName = "semester_SEQ", allocationSize = 1)
    private int semester_id;
    private String semester_name;
   private Timestamp starting_date;
    private Date end_date;
    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL)
    private List<Course> courseList;

    public Semester() {
    }

    public Semester(int semester_id) {
        this.semester_id = semester_id;
    }

    public Semester(int semester_id, String semester_name, Timestamp starting_date, Date end_date, List<Course> courseList) {
        this.semester_id = semester_id;
        this.semester_name = semester_name;
        this.starting_date = starting_date;
        this.end_date = end_date;
        this.courseList = courseList;
    }

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    public String getsemester_name() {
        return semester_name;
    }

    public void setsemester_name(String semester_name) {
        this.semester_name = semester_name;
    }

    public Timestamp getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(Timestamp starting_date) {
        this.starting_date = starting_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }


}
