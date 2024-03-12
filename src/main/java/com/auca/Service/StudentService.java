package com.auca.Service;

import com.auca.Model.Student;

import java.util.List;

public interface StudentService {
    int saveStudent(Student stu) throws Exception;
    int updateStudent(Student stu) throws Exception;
    int deleteStudent(Student stu) throws Exception;
    List<Student> displayStudents() throws Exception;
}
