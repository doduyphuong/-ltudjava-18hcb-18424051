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
public class School {

    private int numClass;
    private ArrayList<ClassRoom> listRoom = new ArrayList<ClassRoom>();

    public School() {
        this.numClass = 0;
    }

    public int getNumClass() {
        return numClass;
    }

    public void setNumClass(int numClass) {
        this.numClass = numClass;
    }

    public void addClass(ClassRoom cr) {
        this.listRoom.add(cr);
    }

    public ArrayList<ClassRoom> getListRoom() {
        return listRoom;
    }

    public ClassRoom getClassRoom(int index) {
        if ((index >= 0) && (index < listRoom.size() - 1)) {
            return listRoom.get(index);
        }
        return null;
    }

    public ClassRoom getClassRoom(String Name) {
        if (Name.equalsIgnoreCase("")) {
            
        }

        return null;
    }

}
