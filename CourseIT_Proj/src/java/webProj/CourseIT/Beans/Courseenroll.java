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
@Table(name = "courseenroll")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courseenroll.findAll", query = "SELECT c FROM Courseenroll c"),
    @NamedQuery(name = "Courseenroll.findByCEid", query = "SELECT c FROM Courseenroll c WHERE c.cEid = :cEid")})
public class Courseenroll implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CEid")
    private Integer cEid;
    @JoinColumn(name = "Course_ID", referencedColumnName = "Course_ID")
    @ManyToOne(optional = false)
    private Courses courseID;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Useraccinfo userId;

    public Courseenroll() {
    }

    public Courseenroll(int ceID) {

    }

    public Integer getCEid() {
        return cEid;
    }

    public void setCEid(Integer cEid) {
        this.cEid = cEid;
    }

    public Courses getCourseID() {
        return courseID;
    }

    public void setCourseID(Courses courseID) {
        this.courseID = courseID;
    }

    public Useraccinfo getUserId() {
        return userId;
    }

    public void setUserId(Useraccinfo userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cEid != null ? cEid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courseenroll)) {
            return false;
        }
        Courseenroll other = (Courseenroll) object;
        if ((this.cEid == null && other.cEid != null) || (this.cEid != null && !this.cEid.equals(other.cEid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webProj.CourseIT.Beans.Courseenroll[ cEid=" + cEid + " ]";
    }
    
}
