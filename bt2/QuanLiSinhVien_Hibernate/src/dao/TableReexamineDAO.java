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
import pojos.TableReexamine;
import util.HibernateUtil;

/**
 *
 * @author DoDuyPhuong
 */
public class TableReexamineDAO {

    public static TableReexamine getTableReeaxamineActive() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        TableReexamine result = null;

        try {
            Integer status = 1;
            result = (TableReexamine) session.get(TableReexamine.class, status);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return result;
    }

    public static List<TableReexamine> getListTableReexamine() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<TableReexamine> result = null;

        try {
            String hql = "select tr from TableReexamine tr";
            Query query = session.createQuery(hql);
            result = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return result;
    }

    public static TableReexamine checkTableReeaxamineExist(TableReexamine tReexamine) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<TableReexamine> result = null;

        try {
            String hql = "select tr";
            hql += " from TableReexamine tr";
            hql += " where tr.hocKy=:hocKy and tr.namHoc=:namHoc";
            Query query = session.createQuery(hql);
            query.setParameter("hocKy", tReexamine.getHocKy());
            query.setParameter("namHoc", tReexamine.getNamHoc());
            result = (List<TableReexamine>) query.list();
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

    public static TableReexamine checkTableReeaxamineExist(Integer idTableReeaxamine) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        TableReexamine result = null;

        try {
            result = (TableReexamine) session.get(TableReexamine.class, idTableReeaxamine);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return result;
    }

    public static boolean createTableReeaxamine(TableReexamine tReexamine) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (TableReexamineDAO.checkTableReeaxamineExist(tReexamine) != null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(tReexamine);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

    public static boolean updateTableReeaxamine(TableReexamine tReexamine) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (TableReexamineDAO.checkTableReeaxamineExist(tReexamine.getId()) == null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(tReexamine);
            transaction.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

}
