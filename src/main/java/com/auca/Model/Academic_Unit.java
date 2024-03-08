package com.auca.Model;

import jakarta.persistence.*;

@Entity
@Table(name ="academic_unit")
public class Academic_Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int academic_id;
    private char academic_code;
    private String academic_name;
    private char type;
    private int parent_id;
}
