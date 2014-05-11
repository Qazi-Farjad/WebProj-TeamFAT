/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Beans;

/**
 *  This Bean stores all Academic information of the user.
 * 
 * @author Farjad
 */
public class UserAcadBean {
    private String userid;
    private String uni;
    private String school;
    private String degree;
    
    public UserAcadBean(){    }
    public UserAcadBean(String univ, String school, String degree){
        this.uni = univ;
        this.school = school;
        this.degree = degree;
    }
    
    // Setter/Getter Funtions
    
    public String getId() {
        return userid;
    }    

    //Setter for UserID incase jugaru kaam karna paray.
    public void setId( String id ) {
        this.userid = id;
    }    
    
    
    public String getUni() {
        return uni;
    }
    public void setUni(String uni) {
        this.uni = uni;
    } 
    
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.degree = school;
    } 
    
    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }    
}
