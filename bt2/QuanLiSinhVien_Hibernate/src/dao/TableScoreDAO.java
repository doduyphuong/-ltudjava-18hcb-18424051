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
import pojos.Student;
import pojos.TableScore;
import util.HibernateUtil;

/**
 *
 * @author DoDuyPhuong
 */
public class TableScoreDAO {

    public static TableScore getRowInTableScore(Integer idCalenderCourse, Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<TableScore> result = null;

        try {
            String hql = "select tb";
            hql += " from TableScore tb";
            hql += " where tb.idCalenderCourse=:idCalenderCourse and tb.student=:student";
            Query query = session.createQuery(hql);
            query.setParameter("idCalenderCourse", idCalenderCourse);
            query.setParameter("student", student);
            result = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        if(result.size() > 0) {
            return result.get(0);
        }
        
        return null;
    }

    public static List<TableScore> getTableScoreByCourse(Integer idCalenderCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<TableScore> result = null;

        try {
            String hql = "select tb from TableScore tb ";
            hql += " where tb.idCalenderCourse=:idCalenderCourse";
            Query query = session.createQuery(hql);
            query.setParameter("idCalenderCourse", idCalenderCourse);
            result = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return result;
    }

    public static boolean createTableScore(TableScore tb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (TableScoreDAO.getRowInTableScore(tb.getIdCalenderCourse(), tb.getStudent()) != null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(tb);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

    public static boolean updateTableScore(TableScore tb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (TableScoreDAO.getRowInTableScore(tb.getIdCalenderCourse(), tb.getStudent()) == null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(tb);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }
}
