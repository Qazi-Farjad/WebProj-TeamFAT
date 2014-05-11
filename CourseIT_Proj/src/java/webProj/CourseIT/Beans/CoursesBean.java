/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Beans;

/**
 *
 * @author Farjad
 */
public class CoursesBean {
    private int Course_ID;
    private String Course_Name;
    private String Instructor;
    private int UV;      //UV = Up-Votes (Rank)
    private String pic;
    
    //TODO: Getter Setter Functions
    
    public CoursesBean(){
        }
    
    public CoursesBean(String cname, String ins){
        
        this.Course_Name=cname;
        this.Instructor= ins;
        this.UV = 0;
        this.pic = "";              //Put a default pic in Filesystem, and link it here.
    }    
    
    public int getCourseID(){
        return Course_ID;
    }
    //Setter for Course ID not required.
    
    public String getCourseName() {
        return Course_Name;
    }
    public void setCourseName(String coursename) {
        this.Course_Name = coursename;
    } 
    
    public String getInstructor() {
        return Instructor;
    }
    public void setInstructor(String instructor) {
        this.Instructor = instructor;
    } 
    
    public int getUV(){
        return UV;
    }
    
    
    // Upvotes will be incremented per vote, so this funct can be changed to just an incrementer.
    // -Farjad
    public void setUV(int upvotes){
        this.UV = upvotes;
    }    
    
    public String getCoursePic() {
        return pic;
    }
    
    //Store Image into Filesystem, and send its Location to this funct. DONT SEND THE IMAGE HERE
    // -Farjad
    public void setCoursePic(String course_pic) {
        this.pic = course_pic;
    } 
    
}
