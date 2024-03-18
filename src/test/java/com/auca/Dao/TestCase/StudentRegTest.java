package com.auca.Dao.TestCase;

import com.auca.Dao.StudentRegDao;
import com.auca.Model.*;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class StudentRegTest {
    StudentRegDao dao = new StudentRegDao();
    @Test
    public void studentPerSemester() {
        int semesterId = 6;
        List<Object[]> List =dao.studentPerSemester(semesterId);
        assertNotNull("Not Null", List);
        assertFalse("not empty", List.isEmpty());
        for (Object[] reg :List) {
            assertNotNull("Student ID should not be null", reg[0]);
            assertNotNull("Student Fname should not be null", reg[1]);
            assertNotNull("Student Lname  should not be null", reg[2]);
            assertNotNull("Student Semester  should not be null", reg[3]);
        }
    }

    @Test
    public void studentPerDepartmentSemester() {
        UUID DeptID = UUID.fromString("bbfabe8e-86ca-4a6a-bde9-e5a86edd75c2");
        int seme_id = 5 ;
        List<Object[]> result = dao.StudentPerDepartmentSemester(new Academic_Unit(DeptID),seme_id);
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
        UUID course = UUID.fromString("ebc6e926-e7d2-45ba-9dca-4d0fd94185ff");
        int seme_id = 5 ;
        List<Object[]> result = dao.StudentPerCourseSemester(new Course(course),new Semester(seme_id));
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
     Student studentId = new Student(24604);
     List<Object[]> list = dao.courseperStudernt(studentId);
     assertNotNull("List should not be null", list);
     assertFalse("List Should not be empty",list.isEmpty());
     for(Object[] obj : list){
         assertNotNull("The Course Name Should not be null",obj[0]);
         assertNotNull("The course code should not be null",obj[1]);
         assertNotNull("The Student Name not null",obj[2]);

     }
    }
}