/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Account;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class AccountDAO {

    public static Account getAccount(String maStudent) {
        Account account = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            account = (Account) session.get(Account.class, maStudent);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return null;
    }

    public static boolean changePasswd(Account account) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (AccountDAO.getAccount(account.getMaStudent()) == null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(account);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

    public static boolean createAccount(Account account) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (AccountDAO.getAccount(account.getMaStudent()) != null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();;
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

    public static boolean deleteAccount(String maStudent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account account = AccountDAO.getAccount(maStudent);
        if (account == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

}
