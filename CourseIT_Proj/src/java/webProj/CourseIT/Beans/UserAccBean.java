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
public class UserAccBean { 
    private String user_id;
    private String name;
    private String email;
    private String password;
    private String user_pic;
    private int internshipID;
    
    //TODO: Setter/Getter Functions.
    public UserAccBean(){}
        public UserAccBean(String uid, String name, String email, String pwd){
           this.user_id = uid;
           this.name = name;
           this.email = email;
           this.password = pwd;
           //this.internshipID = 0;
        }
        
        
        //Setter/Getter Functions.
        
        public String getId() {
            return user_id;
        }

        public void setId( String id ) {
            this.user_id = id;
        }
        
        public String getName() {
            return name;
        }
        public void setName( String name ) {
            this.name = name;
        }
        
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        
        public String getPwd() {
            return password;
        }
        public void setPwd(String pwd) {
            this.password = pwd;
        }
        
        public String getUserPic() {
            return user_pic;
        }

        //Store Image into Filesystem, and send its Location to this funct. Dont send image here
        // -Farjad
        public void setCoursePic(String pic) {
            this.user_pic = pic;
        }
        
        public int getInternshipID(){
            return internshipID;
        }
        
        //This probably wont be needed.
        public void setInternshipID(int iid){
            this.internshipID = iid;
        }        
}
