/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.ClassRoomCourse;
import pojos.Student;
import util.HibernateUtil;

/**
 *
 * @author DoDuyPhuong
 */
public class ClassRoomCourseDAO {
    public static List<Student> getListStudent(Integer idCalenderCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> listStudent = null;
        
        try {
            String hql = "select sd";
            hql += " from ClassRoomCourse crc, Student sd";
            hql += " where crc.idCalenderCourse=:idCalenderCourse and crc.maStudent=sd.maStudent";
            Query query = session.createQuery(hql);
            query.setParameter("idCalenderCourse", idCalenderCourse);
            listStudent =  query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return listStudent;
    }
    
    public static ClassRoomCourse getOneRowToCourse(ClassRoomCourse crc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ClassRoomCourse _crc = null;
        
        try {
            _crc = (ClassRoomCourse) session.get(ClassRoomCourse.class, crc);
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return _crc;
    }
    
    public static boolean addStudentInCourse(ClassRoomCourse crc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(ClassRoomCourseDAO.getOneRowToCourse(crc) != null) {
            return false;
        }
        
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(crc);
            transaction.commit();
        } catch (HibernateException ex) {
           System.err.println(ex);
        } finally {
            session.close();
        }
        
        return true;
    }
    
    public static boolean deleteStudentOutCourse(ClassRoomCourse crc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(ClassRoomCourseDAO.getOneRowToCourse(crc) == null) {
            return false;
        }
        
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(crc);
            transaction.commit();;
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return true;
    }
}
