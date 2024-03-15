package com.auca.Model;

import com.auca.Dao.HibernateUtil;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

@Entity
@Table(name ="academic_unit")
public class Academic_Unit {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID academic_id;
    private String academic_code;
    private String academic_name;
    @Enumerated(EnumType.STRING)
    private EAcademicUnit type;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name ="parent_id", nullable = true)
    private Academic_Unit parent;
    @OneToMany(mappedBy = "academic_Unit", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public Academic_Unit() {
    }

    public Academic_Unit(UUID academic_id) {
        this.academic_id = academic_id;
    }

    public Academic_Unit(UUID academic_id, String academic_code, String academic_name, EAcademicUnit type, Academic_Unit parent, List<Course> courses) {
        this.academic_id = academic_id;
        this.academic_code = academic_code;
        this.academic_name = academic_name;
        this.type = type;
        this.parent = parent;
        this.courses = courses;
    }

    public UUID getAcademic_id() {
        return academic_id;
    }

    public void setAcademic_id(UUID academic_id) {
        this.academic_id = academic_id;
    }

    public String getAcademic_code() {
        return academic_code;
    }

    public void setAcademic_code(String academic_code) {
        this.academic_code = academic_code;
    }

    public String getAcademic_name() {
        return academic_name;
    }

    public void setAcademic_name(String academic_name) {
        this.academic_name = academic_name;
    }

    public EAcademicUnit getType() {
        return type;
    }

    public void setType(EAcademicUnit type) {
        this.type = type;
    }

    public Academic_Unit getParent() {
        return parent;
    }

    public void setParent(Academic_Unit parent) {
        this.parent = parent;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


}
