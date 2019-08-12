/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.CalenderCourse;
import util.HibernateUtil;

/**
 *
 * @author DoDuyPhuong
 */
public class CalenderCourseDAO {

    public static boolean createCalenderCourse(CalenderCourse cCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(cCourse);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

    public static CalenderCourse getCalenderCourse(String maClass, String maCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CalenderCourse cCourse = null;
        
        try {
            String hql = "select cc";
            hql += " from CalenderCourse cc";
            hql += " where cc.maClass=:maClass and cc.maCourse=:maCourse";
            Query query = session.createQuery(hql);
            query.setParameter("maClass", maClass);
            query.setParameter("maCourse", maCourse);
            cCourse =  (CalenderCourse) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        
        return cCourse;
    }
}
