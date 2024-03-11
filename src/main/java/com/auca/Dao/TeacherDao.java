package com.auca.Dao;

import com.auca.Model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeacherDao {
    public int saveTeacher(Student st){
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

    public int UpdateTeacher(Student st){
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

    public int DeleteTeacher(Student st){
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
