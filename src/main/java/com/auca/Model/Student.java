package com.auca.Model;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    private int student_id;
    private String first_name;
    private String last_name;
    private char date_of_birth;
}
