/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import pojos.Reexamine;
import util.HibernateUtil;

/**
 *
 * @author DoDuyPhuong
 */
public class ReexamineDAO {
    public static Reexamine getRowInReexamine() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Reexamine result = null;
        
        
        
        return result;
    }
}
