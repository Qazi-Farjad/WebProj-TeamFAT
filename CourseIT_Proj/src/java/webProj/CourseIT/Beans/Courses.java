/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Talal Saleem
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
    @NamedQuery(name = "Courses.findByCoursepic", query = "SELECT c FROM Courses c WHERE c.coursepic = :coursepic"),
    @NamedQuery(name = "Courses.findBySourceCompany", query = "SELECT c FROM Courses c WHERE c.sourceCompany = :sourceCompany"),
    @NamedQuery(name = "Courses.findBySourceLink", query = "SELECT c FROM Courses c WHERE c.sourceLink = :sourceLink"),
    @NamedQuery(name = "Courses.findByExpiryDate", query = "SELECT c FROM Courses c WHERE c.expiryDate = :expiryDate"),
    @NamedQuery(name = "Courses.findByStartingDate", query = "SELECT c FROM Courses c WHERE c.startingDate = :startingDate"),
    @NamedQuery(name = "Courses.findByCourseDesc", query = "SELECT c FROM Courses c WHERE c.courseDesc = :courseDesc"),
    @NamedQuery(name = "Courses.findByCourseCtg", query = "SELECT c FROM Courses c WHERE c.courseCtg = :courseCtg")})
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
    @Column(name = "SourceCompany")
    private String sourceCompany;
    @Column(name = "SourceLink")
    private String sourceLink;
    @Column(name = "ExpiryDate")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Column(name = "StartingDate")
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @Column(name = "course_desc")
    private String courseDesc;
    @Column(name = "course_ctg")
    private String courseCtg;

    public Courses() {
    }

    public Courses(Integer courseID) {
        this.courseID = courseID;
    }

      public Courses(String courseName, String instructor, int courseUV) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.courseUV = 0;
    }
    
    
    public Courses(String cname, String instructor, String sourceComp,
                         String sourceLink, Date expiryDate, Date startingDate){
    this.courseName = cname;
    this.instructor = instructor;
    this.sourceCompany =sourceComp;
    this.sourceLink = sourceLink;
    this.expiryDate = expiryDate;
    this.startingDate = startingDate;
    
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

    public String getSourceCompany() {
        return sourceCompany;
    }

    public void setSourceCompany(String sourceCompany) {
        this.sourceCompany = sourceCompany;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getCourseCtg() {
        return courseCtg;
    }

    public void setCourseCtg(String courseCtg) {
        this.courseCtg = courseCtg;
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
        return "webProj.CourseIT.Beans.Courses[ courseID=" + courseID + " ]";
    }
    
}
