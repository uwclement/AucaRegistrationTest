package com.auca.Service;

import com.auca.Model.*;

import java.util.List;
import java.util.UUID;

public interface StudentRegService {
    int saveRegistration (StudentRegistration stuReg) throws Exception;
    int updateRegistration (StudentRegistration stuReg) throws Exception;
    int deleteRegistration (StudentRegistration stuReg) throws Exception;
    List<StudentRegistration> displayRegistration () throws Exception;
    List<Object[]> studentPerSemester (int semid) throws Exception;
    Boolean isStudentExists (int studentId) throws Exception;
    Boolean isSemestertExists (int semeid) throws Exception;
    List<Object[]> StudentPerDepartmentSemester(Academic_Unit dept_id, int sem_id) throws Exception;
    List<Object[]> StudentPerCourseSemester (Course course, Semester seme) throws Exception;
    List<Object[]> courseperStudernt (Student student) throws Exception;
}
