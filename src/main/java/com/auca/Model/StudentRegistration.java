package com.auca.Model;

import com.google.protobuf.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name ="studentRegistration")
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
