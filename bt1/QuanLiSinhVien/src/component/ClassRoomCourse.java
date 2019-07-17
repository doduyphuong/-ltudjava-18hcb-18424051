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
public class ClassRoomCourse {
    private String className;
    private double scoreMiddleTest;
    private double scoreFinalTest;
    private double scoreDifferen;
    private double finalSrore;
        private ArrayList<Student> listStudent = new ArrayList<Student>();

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }
    
    
}
