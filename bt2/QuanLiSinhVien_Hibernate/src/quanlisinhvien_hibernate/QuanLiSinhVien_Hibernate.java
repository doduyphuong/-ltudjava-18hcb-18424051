/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisinhvien_hibernate;

import dao.AccountDAO;
import pojos.Account;



/**
 *
 * @author CPU12407-local
 */
public class QuanLiSinhVien_Hibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Account a = AccountDAO.getAccount("giaovu");
        System.out.println("zzzzzzzzzzz");
    }
    
}
