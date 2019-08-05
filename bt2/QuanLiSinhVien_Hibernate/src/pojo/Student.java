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
public class Student implements java.io.Serializable{
    private String maStudent;
    private String nameStudent;
    private String cmnd;
    private int sex;
    private String maClass;
    
    public Student () {}
    
    public Student(String maStudent, String nameStudent, String cmnd, int sex, String maClass) {
        this.maStudent = maStudent;
        this.nameStudent = nameStudent;
        this.cmnd = cmnd;
        this.sex = sex;
        this.maClass = maClass;
    }

    public String getMaStudent() {
        return maStudent;
    }

    public void setMaStudent(String maStudent) {
        this.maStudent = maStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMaClass() {
        return maClass;
    }

    public void setMaClass(String maClass) {
        this.maClass = maClass;
    }
    
    
}
