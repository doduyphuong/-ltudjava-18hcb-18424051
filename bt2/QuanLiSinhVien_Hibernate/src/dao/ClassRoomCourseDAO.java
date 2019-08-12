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
import pojos.Student;
import util.HibernateUtil;

/**
 *
 * @author DoDuyPhuong
 */
public class ClassRoomCourseDAO {
    public static List<Student> getListStudent(String maClass, String maCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> listStudent = null;
        
        try {
            String hql = "select sd";
            hql += " from ClassRoomCourse crc, Student sd";
            hql += "where crc.maClass=:maClass and crc.maCourse=:maCourse and crc.maStudent=sd.maStudent";
            Query query = session.createQuery(hql);
            query.setParameter("maClass", maClass);
            query.setParameter("maCourse", maCourse);
            listStudent =  query.list();
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return listStudent;
    }
}
