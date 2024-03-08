package com.auca.Model;

import jakarta.persistence.*;

@Entity
@Table(name="semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int semester_id;
    private String semsester_name;
//    private Timestamp starting_date;
//    private Timestamp end_date;
}
