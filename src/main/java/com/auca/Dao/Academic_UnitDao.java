package com.auca.Dao;

import com.auca.Model.Academic_Unit;
import com.auca.Model.StudentRegistration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Academic_UnitDao {
    public int saveAcademicUnit (Academic_Unit au){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            transaction = session.beginTransaction();
            session.save(au);
            transaction.commit();
            session.close();
            return 1;

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public int updateAcademicUnit (Academic_Unit au){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            transaction = session.beginTransaction();
            session.update(au);
            transaction.commit();
            session.close();
            return 1;

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public int deleteAcademicUnit (Academic_Unit au){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();;
        try
        {
            transaction = session.beginTransaction();
            session.delete(au);
            transaction.commit();
            session.close();

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<Academic_Unit> displayAcademicUnit (){
        Transaction transaction = null;
        Session session =HibernateUtil.getSessionFactory().openSession();
        try
        {
            transaction = session.beginTransaction();
            List<Academic_Unit> academicData = session.createQuery("from Academic_Unit ",Academic_Unit.class).list();
            transaction.commit();
            session.close();
            return academicData;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
