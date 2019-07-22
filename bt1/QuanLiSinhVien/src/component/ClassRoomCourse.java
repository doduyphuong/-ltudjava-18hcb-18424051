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
    private String idCourse;
    private ArrayList<Student> listStudent = new ArrayList<Student>();
    private ArrayList<TableScore> listTableScore = new ArrayList<TableScore>();

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = (ArrayList<Student>) listStudent.clone();
    }

    public ArrayList<TableScore> getListTableScore() {
        return listTableScore;
    }

    public void setListTableScore(ArrayList<TableScore> listTableScore) {
        this.listTableScore = (ArrayList<TableScore>) listTableScore.clone();
    }

    public int getTotalPass() {
        int result = 0;
        if (this.listTableScore.size() > 0) {
            for (TableScore ts : this.listTableScore) {
                if (ts.getFinalScore() >= 5) {
                    result += 1;
                }
            }
        }
        return result;
    }

    public int getTotalFail() {
        int result = 0;
        if (this.listTableScore.size() > 0) {
            for (TableScore ts : this.listTableScore) {
                if (ts.getFinalScore() < 5) {
                    result += 1;
                }
            }
        }
        return result;
    }

    public double getPercentPass() {
        double result = 0;
        double totalPass = this.getTotalPass();
        result = (totalPass * 100) / this.listTableScore.size();

        return result;
    }

    public double getPercentFail() {
        double result = 0;
        double totalFail = this.getTotalFail();
        result = (totalFail * 100) / this.listTableScore.size();

        return result;
    }

    public boolean checkClassName(String name, String id) {
        if (this.className.equalsIgnoreCase(name) && this.idCourse.equalsIgnoreCase(id)) {
            return true;
        }
        return false;
    }

    public void addStudent(Student sd) {
        this.listStudent.add(sd);
    }

    public TableScore getTableScore(String _mssv) {
        TableScore result = null;

        for (TableScore ts : this.listTableScore) {
            if (ts.getSd().checkMSSV(_mssv)) {
                result = ts;
            }
        }

        return result;
    }

    public void setTableScore(TableScore tbScore, String _mssv) {
        for (TableScore ts : this.listTableScore) {
            if (ts.getSd().checkMSSV(_mssv)) {
                this.listTableScore.set(this.listTableScore.indexOf(ts), tbScore);
            }
        }
    }
}
