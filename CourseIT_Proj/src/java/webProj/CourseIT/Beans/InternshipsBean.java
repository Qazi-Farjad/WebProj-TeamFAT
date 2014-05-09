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
public class InternshipsBean {
    	private int internship_id;
	private String submitter;
	private String info;
        
        public InternshipsBean(){}
        public InternshipsBean(String submitter, String info){
            //TODO: Implement constructor.
        }
        
        
        //Setter/Getter Functions.
        
        public int getId() {
            return internship_id;
        }
        public void setId( int id ) {
            this.internship_id = id;
        }
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
