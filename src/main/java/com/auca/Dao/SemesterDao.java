package com.auca.Dao;

import com.auca.Model.Semester;
import com.auca.Model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SemesterDao {
    public  int saveSemester(Semester sem){
        Transaction transaction= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(sem);
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

    public  int updateSemester(Semester sem){
        Transaction transaction= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(sem);
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

    public  int deleteSemester(Semester sem){
        Transaction transaction= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(sem);
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
    public List<Semester> displaySemester(){
        Transaction transaction= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            List<Semester> semesters = null;
            semesters = session.createQuery("from Semester ",Semester.class).list();
            transaction.commit();
            session.close();
            return semesters;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean isSemestertExists(int semeid) {
        boolean exists = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String sql = "SELECT COUNT(*) FROM Semester  WHERE semester_id = :semesterid";
            Query<Long> query = session.createQuery(sql, Long.class);
            query.setParameter("semesterid", semeid);
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
