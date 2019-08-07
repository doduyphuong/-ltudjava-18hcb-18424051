/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisinhvien_hibernate;

import dao.AccountDAO;
import dao.ClassRoomDAO;
import java.util.Iterator;
import java.util.List;
import pojos.Account;
import pojos.ClassRoom;
import pojos.Student;




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
//        Account a = AccountDAO.getAccount("giaovu");
//        System.out.println(a.getUserName());
//        System.out.println(a.getPasswd());
        // Test lay danh sach sinh vien cua 1 lop
//        List<ClassRoom> listClassRoom = ClassRoomDAO.getListClassRoom();
//        for(ClassRoom cr : listClassRoom) {
//            System.out.println(cr.getMaClass());
//            ClassRoom _cr = ClassRoomDAO.getClassRoom(cr.getMaClass());
//            Iterator<Student> listStudent = _cr.getListStudent().iterator();
//            while(listStudent.hasNext()) {
//                Student sd = listStudent.next();
//                System.out.println("Ma Student: " + sd.getMaStudent());
//                System.out.println("Name Student: " +sd.getNameStudent());
//                System.out.println("Sex: " + sd.getSex());
//                System.out.println("CMND: " + sd.getCmnd());
//            }
//        }
    }
    
}
