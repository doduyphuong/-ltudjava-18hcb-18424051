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
    private ArrayList<ClassRoomCourse> listRoomCourse = new ArrayList<ClassRoomCourse>();

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

    public void addStudentToClass(String className, Student _sd) {
        for (ClassRoom cr : this.listRoom) {
            if (cr.checkNameClass(className)) {
                cr.addStudent(_sd);
            }
        }
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

    public ClassRoom getClassRoom(String nameClass) {
        ClassRoom result = new ClassRoom();
        if (!nameClass.equals("")) {
            for (ClassRoom cr : this.listRoom) {
                boolean checkName = cr.checkNameClass(nameClass);
//                System.out.print(checkName);
                if (checkName) {
                    result = cr;
                }
            }
        }

        return result;
    }

    public void setClassRoom(ClassRoom _cr, String className) {
        for (ClassRoom cr : this.listRoom) {
            if (cr.checkNameClass(className)) {
                int _index = this.listRoom.indexOf(cr);
                this.listRoom.set(_index, _cr);
            }
        }
    }

    public ArrayList<ClassRoomCourse> getListRoomCourse() {
        return listRoomCourse;
    }

    public void setListRoomCourse(ArrayList<ClassRoomCourse> listRoomCourse) {
        this.listRoomCourse = listRoomCourse;
    }

    public ClassRoomCourse getClassRoomCourse(String className, String idCourse) {
        ClassRoomCourse result = new ClassRoomCourse();
        if (this.listRoomCourse.size() > 0) {
            for (ClassRoomCourse crc : this.listRoomCourse) {
                if (crc.checkClassName(className,idCourse)) {
                    result = crc;
                }
            }
        }

        return result;
    }
    
    public void setClassRoomCourse(String className, String idCourse, ClassRoomCourse _crc) {
        for (ClassRoomCourse crc : this.listRoomCourse) {
            if(crc.checkClassName(className, idCourse)) {
                int _index = this.listRoomCourse.indexOf(crc);
                this.listRoomCourse.set(_index, _crc);
            }
        }
    }
}
