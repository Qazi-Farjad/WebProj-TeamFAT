/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Farjad
 */
@Entity
@Table(name = "coursehistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coursehistory.findAll", query = "SELECT c FROM Coursehistory c"),
    @NamedQuery(name = "Coursehistory.findByCHid", query = "SELECT c FROM Coursehistory c WHERE c.cHid = :cHid"),
    @NamedQuery(name = "Coursehistory.findByGradePercentage", query = "SELECT c FROM Coursehistory c WHERE c.gradePercentage = :gradePercentage")})
public class Coursehistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CHid")
    private Integer cHid;
    @Basic(optional = false)
    @Column(name = "GradePercentage")
    private int gradePercentage;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Useraccinfo userId;
    @JoinColumn(name = "Course_ID", referencedColumnName = "Course_ID")
    @ManyToOne(optional = false)
    private Courses courseID;

    public Coursehistory() {
    }

    public Coursehistory(Integer cHid) {
        this.cHid = cHid;
    }

    public Coursehistory(Integer cHid, int gradePercentage) {
        this.cHid = cHid;
        this.gradePercentage = gradePercentage;
    }

    public Integer getCHid() {
        return cHid;
    }

    public void setCHid(Integer cHid) {
        this.cHid = cHid;
    }

    public int getGradePercentage() {
        return gradePercentage;
    }

    public void setGradePercentage(int gradePercentage) {
        this.gradePercentage = gradePercentage;
    }

    public Useraccinfo getUserId() {
        return userId;
    }

    public void setUserId(Useraccinfo userId) {
        this.userId = userId;
    }

    public Courses getCourseID() {
        return courseID;
    }

    public void setCourseID(Courses courseID) {
        this.courseID = courseID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cHid != null ? cHid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coursehistory)) {
            return false;
        }
        Coursehistory other = (Coursehistory) object;
        if ((this.cHid == null && other.cHid != null) || (this.cHid != null && !this.cHid.equals(other.cHid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webProj.CourseIT.Beans.Coursehistory[ cHid=" + cHid + " ]";
    }
    
}
