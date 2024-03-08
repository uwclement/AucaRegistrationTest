package com.auca.Model;

import jakarta.persistence.*;

@Entity
@Table(name ="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacher_id;
    private String first_name;
    private String last_name;
    private char qualification;
//    @OneToMany
//    @JoinColumn(name ="course")
//    private Course course;

}
