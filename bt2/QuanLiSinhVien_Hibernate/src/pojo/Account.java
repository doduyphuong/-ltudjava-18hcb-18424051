/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author CPU12407-local
 */
public class Account implements java.io.Serializable{
    private String maStudent;
    private String passwd;
    private String maClass;
    private int role;
    
    public Account() {
        
    }
    
    public Account(String maStudent, String passwd, String maClass, int role) {
        this.maStudent = maStudent;
        this.passwd = passwd;
        this.maClass = maClass;
        this.role = role;
    }

    public String getMaStudent() {
        return maStudent;
    }

    public void setMaStudent(String maStudent) {
        this.maStudent = maStudent;
    }

    
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getMaClass() {
        return maClass;
    }

    public void setMaClass(String maClass) {
        this.maClass = maClass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
