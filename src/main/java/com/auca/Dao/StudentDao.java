package com.auca.Dao;
import org.hibernate.HibernateException;
import com.auca.Model.Student;
import org.hibernate.*;


public class StudentDao {
    public  int saveStudent(Student st){
        Transaction transaction= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(st);
            transaction.commit();
            session.close();
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
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }
}
