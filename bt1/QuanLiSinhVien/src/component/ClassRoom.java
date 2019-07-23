/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.util.ArrayList;

/**
 *
 * @author CPU12407-local
 */
public class ClassRoom {

    private String Name;
    private ArrayList<Student> listStudent = new ArrayList<Student>();
    ArrayList<CalenderCourse> listCourse = new ArrayList<CalenderCourse>();

    public ClassRoom() {
        this.Name = "";
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void addStudent(Student sd) {
        this.listStudent.add(sd);
    }
    
    public void addCalenderCourse(CalenderCourse calenderCourse) {
        this.listCourse.add(calenderCourse);
    }
    
    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = (ArrayList<Student>) listStudent.clone();
    }

    public boolean checkNameClass(String _name) {
        if (this.Name.equalsIgnoreCase(_name)) {
            return true;
        }
        return false;
    }

    public ArrayList<CalenderCourse> getListCourse() {
        return listCourse;
    }

    public void setListCourse(ArrayList<CalenderCourse> listCourse) {
        this.listCourse = (ArrayList<CalenderCourse>) listCourse.clone();
    }
    
    public Student getStudentInClass(String _mssv) {
        Student sd = null;
        
        for(Student _sd : this.listStudent) {
            if(_sd.checkMSSV(_mssv)) {
                sd = _sd;
            }
        }
        
        return sd;
    }

}
