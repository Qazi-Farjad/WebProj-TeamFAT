/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Beans.AutoGen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  I feel so fucking stupid right now. Entity Classes can be Auto-Fucking-Generated.
 *  Fuck Me. No, Fuck Qaisar Choudhary. Q_Q
 * @author Farjad
 */
@Entity
@Table(name = "courses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courses.findAll", query = "SELECT c FROM Courses c"),
    @NamedQuery(name = "Courses.findByCourseID", query = "SELECT c FROM Courses c WHERE c.courseID = :courseID"),
    @NamedQuery(name = "Courses.findByCourseName", query = "SELECT c FROM Courses c WHERE c.courseName = :courseName"),
    @NamedQuery(name = "Courses.findByInstructor", query = "SELECT c FROM Courses c WHERE c.instructor = :instructor"),
    @NamedQuery(name = "Courses.findByCourseUV", query = "SELECT c FROM Courses c WHERE c.courseUV = :courseUV"),
    @NamedQuery(name = "Courses.findByCoursepic", query = "SELECT c FROM Courses c WHERE c.coursepic = :coursepic")})
public class Courses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Course_ID")
    private Integer courseID;
    @Basic(optional = false)
    @Column(name = "Course_Name")
    private String courseName;
    @Basic(optional = false)
    @Column(name = "Instructor")
    private String instructor;
    @Basic(optional = false)
    @Column(name = "Course_UV")
    private int courseUV;
    @Column(name = "Course_pic")
    private String coursepic;

    public Courses() {
    }

    public Courses(Integer courseID) {
        this.courseID = courseID;
    }

    public Courses(Integer courseID, String courseName, String instructor, int courseUV) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructor = instructor;
        this.courseUV = courseUV;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCourseUV() {
        return courseUV;
    }

    public void setCourseUV(int courseUV) {
        this.courseUV = courseUV;
    }

    public String getCoursepic() {
        return coursepic;
    }

    public void setCoursepic(String coursepic) {
        this.coursepic = coursepic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseID != null ? courseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courses)) {
            return false;
        }
        Courses other = (Courses) object;
        if ((this.courseID == null && other.courseID != null) || (this.courseID != null && !this.courseID.equals(other.courseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webProj.CourseIT.Beans.AutoGen.Courses[ courseID=" + courseID + " ]";
    }
    
}
