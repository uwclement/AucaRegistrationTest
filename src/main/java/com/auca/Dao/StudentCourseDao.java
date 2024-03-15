package com.auca.Dao;

import com.auca.Model.StudentRegistration;
import com.auca.Model.Student_Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class StudentCourseDao {
    public int saveStudentCourse(Student_Course sc){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction= session.beginTransaction();
            session.save(sc);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }


}
