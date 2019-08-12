/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.HibernateException;
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
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return true;
    }
}
