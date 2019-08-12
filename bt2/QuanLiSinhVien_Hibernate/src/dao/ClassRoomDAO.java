/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.CalenderCourse;
import pojos.ClassRoom;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class ClassRoomDAO {

    public static List<ClassRoom> getListClassRoom() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ClassRoom> listClassRoom = null;
        try {
            String hql = "select cr from ClassRoom cr";
            Query query = session.createQuery(hql);
            listClassRoom = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return listClassRoom;
    }
    
    public static ArrayList<CalenderCourse> getListCalenderCourse(String maClass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<CalenderCourse> listCalenderCourse = null;
        try {
            String hql = "select cc"; 
            hql += " from CalenderCourse cc";
            hql += " where cc.maClass=:maClass";
            Query query = session.createQuery(hql);
            query.setParameter("maClass", maClass);
            listCalenderCourse = (ArrayList<CalenderCourse>) query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return listCalenderCourse;
    }

    public static ClassRoom getClassRoom(String maClass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ClassRoom cr = null;
        
        try {
            cr = (ClassRoom) session.get(ClassRoom.class, maClass);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return cr;
    }

    public static boolean createClassRoom(ClassRoom cr) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(ClassRoomDAO.getClassRoom(cr.getMaClass()) != null) {
            return false;
        }
        
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cr);
            transaction.commit();
        } catch(HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return true;
    }
}
