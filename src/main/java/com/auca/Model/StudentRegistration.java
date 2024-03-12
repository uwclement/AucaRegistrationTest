package com.auca.Model;

import java.sql.Timestamp;

import com.auca.Dao.HibernateUtil;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name ="studentRegistration")
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_seq")
    @SequenceGenerator(name = "registration_seq", sequenceName = "studentRegistration_SEQ", allocationSize = 1)
    private int registration_id;

    private char registration_code;
    private Timestamp registration_date;
    @OneToOne
    @JoinColumn(name ="student_id")
    private Student student;
    @OneToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    private int department_id;

    public StudentRegistration() {
    }

    public StudentRegistration(int registration_id) {
        this.registration_id = registration_id;
    }

    public StudentRegistration(int registration_id, char registration_code, Timestamp registration_date, Student student, Semester semester, int department_id) {
        this.registration_id = registration_id;
        this.registration_code = registration_code;
        this.registration_date = registration_date;
        this.student = student;
        this.semester = semester;
        this.department_id = department_id;
    }

    public int getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(int registration_id) {
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

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
    public void setStudent(int studentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            this.student = student;
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void setSemester(int semester_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Semester semester = session.get(Semester.class, semester_id);
            this.semester = semester;
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

}
