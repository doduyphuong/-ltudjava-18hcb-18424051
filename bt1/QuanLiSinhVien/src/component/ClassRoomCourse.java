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
    private ArrayList<Student> listStudent = new ArrayList<Student>();
    private ArrayList<TableScore> listTableScore = new ArrayList<TableScore>();
    
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

    public ArrayList<TableScore> getListTableScore() {
        return listTableScore;
    }

    public void setListTableScore(ArrayList<TableScore> listTableScore) {
        this.listTableScore = listTableScore;
    }

    public int getTotalPass() {
        int result = 0;
        if(this.listTableScore.size() > 0) {
            for(TableScore ts : this.listTableScore) {
                if(ts.getFinalSrore() >= 5) {
                    result += 1;
                }
            }
        }
        return result;
    }
    
    public int getTotalFail() {
        int result = 0;
        if(this.listTableScore.size() > 0) {
            for(TableScore ts : this.listTableScore) {
                if(ts.getFinalSrore() < 5) {
                    result += 1;
                }
            }
        }
        return result;
    }
    
    public double getPercentPass() {
        double result = 0;
        
        result = this.getTotalPass() / this.listTableScore.size();
        
        return result;
    }
    
    public double getPercentFail() {
        double result = 0;
        
        result = this.getTotalFail() / this.listTableScore.size();
        
        return result;
    }
    
    public boolean checkClassName(String name) {
        if(this.className.equalsIgnoreCase(name)) {
            return true;
        }
        return false;
    }
}
