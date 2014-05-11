/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Beans;

import java.sql.Date;

/**
 *
 * @author Farjad
 */
public class InternshipsBean {
    	private int internship_id;
	private String submitter;
	private String info;
        private Date startDate;             //TODO: Implement later (Database main is naam ka table bhi ni hai)
        private Date endDate;               //TODO: Implement later (Database main is naam ka table bhi ni hai)
        
        
        public InternshipsBean(){}
        public InternshipsBean(String submitter, String info){
            this.submitter = submitter;
            this.info = info;
            
        }
        
        
        //Setter/Getter Functions.
        
        public int getId() {
            return internship_id;
        }
        
        //ID's are auto generated: This is just filler code. Possibly Can Cause Bugs
        // -Farjad
        public void setId( int id ) {
            this.internship_id = id;
        }
        //---------------------------------------------------
        
        public String getSubmitter() {
            return submitter;
        }
        public void setBkname(String sbmName) {
            this.submitter = sbmName;
        }
        public String getInfo() {
            return info;
        }
        public void setInfo( String info ) {
            this.info = info;
        }

}
