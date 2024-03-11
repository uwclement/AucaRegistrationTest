package com.auca.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int semester_id;
    private String semsester_name;
   private Timestamp starting_date;
    private LocalDate end_date;
    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL)
    private List<Course> courseList;
}
