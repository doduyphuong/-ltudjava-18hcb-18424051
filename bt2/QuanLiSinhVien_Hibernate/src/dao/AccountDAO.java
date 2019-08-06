/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Account;
import util.HibernateUtil;

/**
 *
 * @author DoDuyPhuong
 */
public class AccountDAO {
    public static Account getAccount(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account account = null;
        
        try {
            account = (Account) session.get(Account.class, userName);
        } catch(HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return account;
    }
}
