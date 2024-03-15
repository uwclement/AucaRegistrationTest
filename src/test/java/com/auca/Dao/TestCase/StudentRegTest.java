package com.auca.Dao.TestCase;

import com.auca.Dao.StudentRegDao;
import com.auca.Model.Academic_Unit;
import com.auca.Model.Course;
import com.auca.Model.Semester;
import com.auca.Model.StudentRegistration;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class StudentRegTest {

    @Test
    public void studentPerSemester() {
        int semesterId = 1;
        StudentRegDao dao = new StudentRegDao();
        List<StudentRegistration> studentRegistration =dao.studentPerSemester(semesterId);
        assertNotNull("Not Null", studentRegistration);
        assertFalse("not empty", studentRegistration.isEmpty());
        for (StudentRegistration reg :studentRegistration) {
            assertEquals("Semester id",semesterId, reg.getSemester().getSemester_id());
        }
    }

    @Test
    public void studentPerDepartmentSemester() {
        UUID DeptID = UUID.fromString("2b534c4f-05b0-400f-ac09-f501504cef77");
        int seme_id = 1 ;
        StudentRegDao studentRegDao = new StudentRegDao();
        List<Object[]> result = studentRegDao.StudentPerDepartmentSemester(new Academic_Unit(DeptID),seme_id);
        assertNotNull("Result should not be null", result);
        assertFalse("Result should not be empty", result.isEmpty());
        for (Object[] obj : result) {
            assertNotNull("Student ID should not be null", obj[0]);
            assertNotNull("Department should not be null", obj[1]);
            assertNotNull("Semester  should not be null", obj[2]);
        }

    }

    @Test
    public void studentPerCourseSemester() {
        UUID course = UUID.fromString("d65a84ae-794f-4c59-9f79-ac40661570bd");
        int seme_id = 3 ;
        StudentRegDao studentRegDao = new StudentRegDao();
        List<Object[]> result = studentRegDao.StudentPerCourseSemester(new Course(course),new Semester(3));
        assertNotNull("Result should not be null", result);
        assertFalse("Result should not be empty", result.isEmpty());
        for (Object[] obj : result) {
            assertNotNull("Student ID should not be null", obj[0]);
            assertNotNull("Semester name should not be null", obj[1]);
            assertNotNull("Course name should not be null", obj[2]);
        }

    }

    @Test
    public void courseperStudernt() {
    }
}