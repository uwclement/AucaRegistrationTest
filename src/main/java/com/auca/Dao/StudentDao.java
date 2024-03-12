package com.auca.Dao;
import org.hibernate.HibernateException;
import com.auca.Model.Student;
import org.hibernate.*;
import org.hibernate.query.Query;


import java.util.List;


public class StudentDao {
    public  int saveStudent(Student st){
        Transaction transaction= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(st);
            transaction.commit();
            session.close();
            return 1;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public  int updateStudent(Student st){
        Transaction transaction= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(st);
            transaction.commit();
            session.close();
            return 1;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public  int deleteStudent(Student st){
        Transaction transaction= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(st);
            transaction.commit();
            session.close();
            return 1;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }
    public List<Student> displayStudents(){
        Transaction transaction= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            List<Student> students = null;
            students = session.createQuery("from Student",Student.class).list();
            transaction.commit();
            session.close();
            return students;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean isStudentExists(int studentId) {
        boolean exists = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String sql = "SELECT COUNT(*) FROM Student WHERE student_id = :studentId";
            Query<Long> query = session.createQuery(sql, Long.class);
            query.setParameter("studentId", studentId);
            Long count = query.uniqueResult();
            exists = count > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return exists;
    }
}
