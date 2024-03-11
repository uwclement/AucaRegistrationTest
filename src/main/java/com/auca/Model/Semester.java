package com.auca.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="semester")
public class Semester {
    @Id
    private int semester_id;
    private String semsester_name;
   private Timestamp starting_date;
    private LocalDate end_date;
    private List<Course> courseList;
}
