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
public class Account {

    private String username;
    private String passwd;
    private String className;
    private int role;

    public Account() {
        this.username = "";
        this.passwd = "";
        this.role = -1;
    }

    public Account(String _username, String _passwd, String _className) {
        this.username = _username;
        this.passwd = _passwd;
        this.className = _className;
        this.role = 0;
    }

    public Account(String _username, String _passwd, int role) {
        this.username = _username;
        this.passwd = _passwd;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean checkUsername(String _username) {
        boolean result = false;

        if (this.username.equals(_username)) {
            result = true;
        }

        return result;
    }

}
