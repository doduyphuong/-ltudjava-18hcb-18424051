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

    public static ClassRoom getClassRoom(String maClass) {
        ClassRoom cr = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            cr = (ClassRoom) session.get(ClassRoom.class, maClass);

        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return cr;
    }

}
