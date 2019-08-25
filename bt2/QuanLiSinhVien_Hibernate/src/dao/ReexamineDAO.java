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
import pojos.Reexamine;
import util.HibernateUtil;

/**
 *
 * @author DoDuyPhuong
 */
public class ReexamineDAO {
    public static List<Reexamine> getListReexamine(int idTableReexamine) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Reexamine> result = null;
        
        try {
            String hql = "select re";
            hql += " from Reexamine re";
            hql += " where re.idTableReexamine=:idTableReexamine";
            Query query = session.createQuery(hql);
            query.setParameter("idTableReexamine", idTableReexamine);
            result = (List<Reexamine>) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return result;
    }
    
    public static List<Reexamine> getListReexamine(String mssv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Reexamine> result = null;
        
        try {
            String hql = "select re";
            hql += " from Reexamine re";
            hql += " where re.mssv=:mssv";
            Query query = session.createQuery(hql);
            query.setParameter("mssv", mssv);
            result = (List<Reexamine>) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return result;
    }
    
    public static Reexamine getReexamine(int idReexamine) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Reexamine> result = null;
        
        try {
            String hql = "select re";
            hql += " from Reexamine re";
            hql += " where re.id=:idReexamine";
            Query query = session.createQuery(hql);
            query.setParameter("idReexamine", idReexamine);
            result = (List<Reexamine>) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        if(result.size() > 0) {
            return result.get(0);
        }
        
        return null;
    }
    
    public static Reexamine checkReexamine(Reexamine re) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Reexamine> result = null;
        
        try {
            String hql = "select re";
            hql += " from Reexamine re";
            hql += " where re.mssv=:mssv and re.course=:course and re.rowScore=:rowScore and re.idTableReexamine=:idTableReexamine";
            Query query = session.createQuery(hql);
            query.setParameter("mssv", re.getMssv());
            query.setParameter("course", re.getCourse());
            query.setParameter("rowScore", re.getRowScore());
            query.setParameter("idTableReexamine", re.getIdTableReexamine());
            result = (List<Reexamine>) query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        if(result.size() > 0) {
            return result.get(0);
        }
        
        return null;
    }
    
    public static boolean updateReexamine(Reexamine re) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(ReexamineDAO.getReexamine(re.getId()) == null) {
            return false;
        }
        
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(re);
            transaction.commit();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return true;
    }
    
    public static boolean createReexamine(Reexamine re) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(ReexamineDAO.checkReexamine(re) != null) {
            return false;
        }
        
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(re);
            transaction.commit();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return true;
    }
}
