package com.auca.Service;

import com.auca.Model.StudentRegistration;

import java.util.List;

public interface StudentRegService {
    int saveRegistration (StudentRegistration stuReg) throws Exception;
    int updateRegistration (StudentRegistration stuReg) throws Exception;
    int deleteRegistration (StudentRegistration stuReg) throws Exception;
    List<StudentRegistration> displayRegistration () throws Exception;
    List<StudentRegistration> studentPerSemester (int semid) throws Exception;
    Boolean isStudentExists (int studentId) throws Exception;
    Boolean isSemestertExists (int semeid) throws Exception;
}
