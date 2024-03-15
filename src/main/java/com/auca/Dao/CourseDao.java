package com.auca.Dao;

import com.auca.Model.Course;
import com.auca.Model.StudentRegistration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class CourseDao {
    public int saveCourse(Course co){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(co);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public int updateCourse(Course co){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(co);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public int deleteCourse(Course co){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(co);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<Course> displayCourse (){
        Transaction transaction =null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            List<Course> courses = session.createQuery("from Course ",Course.class).list();
            transaction.commit();
            session.close();
            return courses;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    public List<Course> CourseperDepartmentSemester(UUID dept_id, int sem_id)
    {
        try {
            Transaction transaction = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql =  "SELECT DISTINCT cor FROM Course cor WHERE cor.semester.semester_id = :semid " +
                                                            "AND cor.academic_Unit.academic_id = :deptid ";
            List<Course> courperDeptSem = session.createQuery(hql,Course.class).
                    setParameter("deptid",dept_id).setParameter("semid",sem_id).list();
            transaction.commit();
            session.close();
            return courperDeptSem;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
