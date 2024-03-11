package com.auca.Implementation;

import com.auca.Dao.StudentDao;
import com.auca.Model.Student;
import com.auca.Service.StudentService;

public class StudentImpl implements StudentService {
    public StudentImpl() {
    }
   StudentDao dao = new StudentDao();
    @Override
    public int saveStudent(Student stu) throws Exception {
        return dao.saveStudent(stu);
    }

    @Override
    public int updateStudent(Student stu) throws Exception {
        return dao.updateStudent(stu);
    }

    @Override
    public int deleteStudent(Student stu) throws Exception {
        return dao.deleteStudent(stu);
    }
}
