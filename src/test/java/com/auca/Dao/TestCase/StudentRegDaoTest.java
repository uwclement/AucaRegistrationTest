package com.auca.Dao.TestCase;

import com.auca.Dao.StudentDao;
import com.auca.Dao.StudentRegDao;
import com.auca.Model.StudentRegistration;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentRegDaoTest {

    @Test
    public void testStudentPerSemester() {
        int semesterId = 1;
        StudentRegDao dao = new StudentRegDao();
        List<StudentRegistration> studentRegistration =dao.studentPerSemester(semesterId);
        assertNotNull("Not Null", studentRegistration);
        assertFalse("not empty", studentRegistration.isEmpty());
        for (StudentRegistration reg :studentRegistration) {
            assertEquals("Semester id",semesterId, reg.getSemester().getSemester_id());
        }
    }
}