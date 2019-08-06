/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Student;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class StudentDAO {

    public static Student getStudent(String maStudent) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Student sd = null;
        try {
            sd = (Student) session.get(Student.class, maStudent);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return sd;
    }

    public static boolean createStudent(Student st) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        if (StudentDAO.getStudent(st.getMaStudent()) != null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(st);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

    public static boolean updateStudent(Student st) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        if (StudentDAO.getStudent(st.getMaStudent()) == null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(st);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }

        return true;
    }

    public static boolean deleteStudent(String maStudent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Student sd = StudentDAO.getStudent(maStudent);
        if (sd == null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sd);
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
