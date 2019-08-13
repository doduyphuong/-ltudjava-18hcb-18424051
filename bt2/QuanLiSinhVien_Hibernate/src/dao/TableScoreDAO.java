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
import pojos.TableScore;
import util.HibernateUtil;

/**
 *
 * @author DoDuyPhuong
 */
public class TableScoreDAO {
    public static TableScore getRowInTableScore(Integer idCalenderCourse, String maStudent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<TableScore> result = null;
        
        try {
            String hql = "select tb"; 
            hql += " from TableScore tb";
            hql += " where tb.idCalenderCourse=:idCalenderCourse and tb.maStudent=:maStudent";
            Query query = session.createQuery(hql);
            query.setParameter("idCalenderCourse", idCalenderCourse);
            query.setParameter("maStudent", maStudent);
            result = query.list();  
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return result.get(0);
    }
    
    public static List<TableScore> getTableScoreByCourse(Integer idCalenderCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<TableScore> result = null;
        
        try {
            String hql = "select tb"; 
            hql += " from TableScore tb";
            hql += " where tb.idCalenderCourse=:idCalenderCourse";
            Query query = session.createQuery(hql);
            query.setParameter("idCalenderCourse", idCalenderCourse);
            result = query.list();  
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return result;
    }
}
