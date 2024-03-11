package com.auca.Model;

import jakarta.persistence.*;

@Entity
@Table(name ="course_definition")
public class Course_Definition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int course_definition_id;
    private char course_definition_code;
    private String course_definition_description;
//  @OneToOne
//  @JoinColumn(name = "course_id")
//  private Course course;
}
