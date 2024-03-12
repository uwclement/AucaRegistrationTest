package com.auca.Implementation;

import com.auca.Dao.SemesterDao;
import com.auca.Dao.StudentDao;
import com.auca.Dao.StudentRegDao;
import com.auca.Model.StudentRegistration;
import com.auca.Service.StudentRegService;

import java.util.List;

public class StudentRegImpl implements StudentRegService {
    public StudentRegImpl() {
    }
    StudentRegDao dao = new StudentRegDao();
    StudentDao dao1 = new StudentDao();
    SemesterDao dao2 = new SemesterDao();
    @Override
    public int saveRegistration(StudentRegistration stuReg) throws Exception {
        return dao.saveRegistration(stuReg);
    }

    @Override
    public int updateRegistration(StudentRegistration stuReg) throws Exception {
        return dao.updateRegistration(stuReg);
    }

    @Override
    public int deleteRegistration(StudentRegistration stuReg) throws Exception {
        return dao.deleteRegistration(stuReg);
    }

    @Override
    public List<StudentRegistration> displayRegistration() throws Exception {
        return dao.displayRegistration();
    }

    @Override
    public List<StudentRegistration> studentPerSemester(int semid) throws Exception {
        return dao.studentPerSemester(semid);
    }

    @Override
    public Boolean isStudentExists(int studentId) throws Exception {
        return dao1.isStudentExists(studentId);
    }

    @Override
    public Boolean isSemestertExists(int semeid) throws Exception {
        return dao2.isSemestertExists(semeid);
    }
}
