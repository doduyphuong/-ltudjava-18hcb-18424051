/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

/**
 *
 * @author CPU12407-local
 */
public class Student {
    private String MSSV;
    private String Name;
    private int Sex;
    private String CMND;
    
    public Student() {
        this.MSSV = "";
        this.Name = "";
        this.Sex = -1;
        this.CMND = "";
    }
    
    public Student(String _MSSV, String _Name, int _Sex, String _CMND) {
        this.MSSV = _MSSV;
        this.Name = _Name;
        this.Sex = _Sex;
        this.CMND = _CMND;
    }
    
    public Student(String _MSSV, String _Name, String _CMND) {
        this.MSSV = _MSSV;
        this.Name = _Name;
        this.Sex = -1;
        this.CMND = _CMND;
    }
    
    public Student(String _MSSV, String _Name) {
        this.MSSV = _MSSV;
        this.Name = _Name;
        this.Sex = -1;
        this.CMND = "";
    }
    
    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int Sex) {
        this.Sex = Sex;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }
    
}
