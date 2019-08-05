/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author CPU12407-local
 */
public class ClassRoom implements java.io.Serializable{
    private String maClass;
    private Set<Student> listStudent = new HashSet<Student>(0);
    
    public ClassRoom() {}
    
    public ClassRoom(String maClass, Set<Student> listStudent) {
        this.maClass = maClass;
        this.listStudent = listStudent;
    }

    public String getMaClass() {
        return maClass;
    }

    public void setMaClass(String maClass) {
        this.maClass = maClass;
    }

    public Set<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(Set<Student> listStudent) {
        this.listStudent = listStudent;
    }
    
    
}
