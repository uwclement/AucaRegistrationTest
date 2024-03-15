package com.auca.Dao;

import com.auca.Model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

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


    public List<Object[]> StudentPerDepartmentSemester(Academic_Unit dept_id, int sem_id)
    {
        try {
            Transaction transaction = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql =  "SELECT sr.student.first_name, sr.student.last_name, c.course_name, sr.semester.semester_name, au.academic_name  " +
                    "FROM StudentRegistration sr " +
                    "JOIN sr.courses c " +
                    "JOIN sr.academic_Unit au " +
                    "JOIN sr.semester s " +
                    "WHERE sr.academic_Unit = :deptId " +
                    "AND s.semester_id = :semesterId";
            List stuperDeptSem = session.createQuery(hql).
            setParameter("deptId",dept_id).setParameter("semesterId",sem_id).list();
            transaction.commit();
            session.close();
            return stuperDeptSem;
        }catch (Exception ex){
            ex.printStackTrace();
        }
     return null;
    }

    public List<Object[]> StudentPerCourseSemester (Course course,Semester seme){
        try {
            Transaction transaction = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql ="SELECT SR.student.id,SR.semester.semester_name, cs.course.course_name FROM StudentRegistration SR " +
                         " JOIN Student_Course cs on SR.registration_id = cs.studentRegistration  " +
                         " WHERE cs.course = :course_id " +
                         " AND SR.semester = :semester_id";
            List<Object[]> stuperCourSem = session.createQuery(hql)
                    .setParameter("course_id",course).setParameter("semester_id",seme).list();
            transaction.commit();
            session.close();
            return stuperCourSem;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }


    public List<Object[]> courseperStudernt (Student student) {
        try {
            Transaction transaction = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "SELECT c.course_name, c.course_code, sr.student.first_name " +
                    "FROM  StudentRegistration sr " +
                    "JOIN Student_Course sc ON sr.registration_id = sc.studentRegistration " +
                    "JOIN Course c ON sc.course = c.course_id " +
                    "WHERE sr.student = :studentId ";
            List<Object[]> courses = session.createQuery(hql).setParameter("studentId",student).list();
            transaction.commit();
            session.close();
            return courses;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
