package com.auca.Dao;

import com.auca.Model.StudentRegistration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentRegDao {
    public int saveRegistration(StudentRegistration stuReg){
        Transaction transaction= null;
        Session session =HibernateUtil.getSessionFactory().openSession();
        try {
            transaction =session.beginTransaction();
            session.save(stuReg);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public int updateRegistration(StudentRegistration stuReg){
        Transaction transaction= null;
        Session session =HibernateUtil.getSessionFactory().openSession();
        try {
            transaction =session.beginTransaction();
            session.update(stuReg);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public int deleteRegistration(StudentRegistration stuReg){
        Transaction transaction = null;
        Session session =HibernateUtil.getSessionFactory().openSession();
        try {
            transaction =session.beginTransaction();
            session.delete(stuReg);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<StudentRegistration> displayRegistration (){
        Transaction transaction = null;
        Session session =HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            List<StudentRegistration> stuRegData = session.createQuery("from StudentRegistration ",StudentRegistration.class).list();
            transaction.commit();
            session.close();
            return stuRegData;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
     return null;
    }

    public List<StudentRegistration> studentPerSemester(int semid){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String sql ="SELECT DISTINCT sr FROM StudentRegistration sr WHERE sr.semester.semester_id = :semid";
            List<StudentRegistration> stuPerSem = session.createQuery(sql,StudentRegistration.class).setParameter("semid", semid).list();
            transaction.commit();
            session.close();
            return stuPerSem;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
