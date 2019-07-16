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

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }
    
}
