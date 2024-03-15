package com.auca.Service;

import com.auca.Model.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    int saveCourse (Course co) throws Exception;
    int updateCourse (Course co) throws Exception;
    int deleteCourse (Course co) throws Exception;
    List<Course> displayCourse () throws Exception;
    List<Course> CourseperDepartmentSemester(UUID dept_id, int sem_id) throws Exception;
}
