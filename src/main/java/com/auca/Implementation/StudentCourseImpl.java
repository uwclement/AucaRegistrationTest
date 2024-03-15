package com.auca.Implementation;

import com.auca.Dao.StudentCourseDao;
import com.auca.Model.Student_Course;
import com.auca.Service.StudentCourseService;

public class StudentCourseImpl implements StudentCourseService {
    public StudentCourseImpl() {
    }
     StudentCourseDao dao = new StudentCourseDao();
    @Override
    public int saveStudentCourse(Student_Course cs) throws Exception {
        return dao.saveStudentCourse(cs);
    }
}
