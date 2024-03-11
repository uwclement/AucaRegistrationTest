package com.auca.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="academic_unit")
public class Academic_Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int academic_id;
    private char academic_code;
    private String academic_name;
    @Enumerated(EnumType.STRING)
    private EAcademicUnit type;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name ="parent_id", nullable = true)
    private Academic_Unit parent;
    @OneToMany(mappedBy = "academicUnit")
    private List<Course> courses;
}
