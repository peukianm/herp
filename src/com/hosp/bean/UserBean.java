/**
 *
 */
package com.hosp.bean;

import com.hosp.entities.ExTameio;
import com.hosp.entities.Role;
import com.hosp.entities.Userroles;
import java.util.List;

/**
 * @author peukianm
 *
 */
public class UserBean {

    private java.lang.String username;
    private java.lang.String password;
    private ExTameio tameio;   
    private List<Userroles> Userroles;
    private Role selectedRole; 

       

    public UserBean() {
    }

    public void reset() {
        username = null;
        password = null;
        Userroles = null;
        selectedRole = null;
    }

    
    public Role getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(Role selectedRole) {
        this.selectedRole = selectedRole;
    }
    
    
    
    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public ExTameio getTameio() {
        return tameio;
    }

    public void setTameio(ExTameio tameio) {
        this.tameio = tameio;
    }
     public List<Userroles> getUserroles() {
        return Userroles;
    }

    public void setUserroles(List<Userroles> Userroles) {
        this.Userroles = Userroles;
    }
}
