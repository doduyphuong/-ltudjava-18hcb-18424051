/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Student;
import pojos.Classroom;
import util.HibernateUtil;

/**
 *
 * @author CPU12407-local
 */
public class ClassRoomDAO {

    public static Set<Student> getListStudent(String maClass) {
        Set<Student> listStudent = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = "select sd from Student sd, ClassRoom cr";
            hql += "where cr.maClass=:maClass and cr.maStudent = sd.maStudent";
            Query query = session.createQuery(hql);
            query.setString("maClass", maClass);
            listStudent = (Set<Student>) query.list();
            
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return listStudent;
    }
    
    public static boolean insertStudentInClass() {
        
        return true;
    }
}
