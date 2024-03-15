package com.auca.Implementation;

import com.auca.Dao.CourseDao;
import com.auca.Model.Course;
import com.auca.Service.CourseService;

import java.util.List;
import java.util.UUID;

public class CourseImpl implements CourseService {
    public CourseImpl() {
    }
    CourseDao dao = new CourseDao();
    @Override
    public int saveCourse(Course co) throws Exception {
        return dao.saveCourse(co);
    }

    @Override
    public int updateCourse(Course co) throws Exception {
        return dao.updateCourse(co);
    }

    @Override
    public int deleteCourse(Course co) throws Exception {
        return dao.deleteCourse(co);
    }

    @Override
    public List<Course> displayCourse() throws Exception {
        return dao.displayCourse();
    }

    @Override
    public List<Course> CourseperDepartmentSemester(UUID dept_id, int sem_id) throws Exception {
        return dao.CourseperDepartmentSemester(dept_id,sem_id);
    }
}
