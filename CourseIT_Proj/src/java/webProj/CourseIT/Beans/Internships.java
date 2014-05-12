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
@Table(name = "internships")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Internships.findAll", query = "SELECT i FROM Internships i"),
    @NamedQuery(name = "Internships.findByInternshipId", query = "SELECT i FROM Internships i WHERE i.internshipId = :internshipId"),
    @NamedQuery(name = "Internships.findBySubmitter", query = "SELECT i FROM Internships i WHERE i.submitter = :submitter"),
    @NamedQuery(name = "Internships.findByInfo", query = "SELECT i FROM Internships i WHERE i.info = :info"),
    @NamedQuery(name = "Internships.findByEmail", query = "SELECT i FROM Internships i WHERE i.email = :email"),
    @NamedQuery(name = "Internships.findByRelatedField", query = "SELECT i FROM Internships i WHERE i.relatedField = :relatedField"),
    @NamedQuery(name = "Internships.findByDuration", query = "SELECT i FROM Internships i WHERE i.duration = :duration"),
    @NamedQuery(name = "Internships.findByStartingDate", query = "SELECT i FROM Internships i WHERE i.startingDate = :startingDate")})
public class Internships implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "internship_id")
    private Integer internshipId;
    @Basic(optional = false)
    @Column(name = "submitter")
    private String submitter;
    @Basic(optional = false)
    @Column(name = "info")
    private String info;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "RelatedField")
    private String relatedField;
    @Basic(optional = false)
    @Column(name = "Duration")
    @Temporal(TemporalType.DATE)
    private Date duration;
    @Basic(optional = false)
    @Column(name = "StartingDate")
    @Temporal(TemporalType.DATE)
    private Date startingDate;

    public Internships() {
    }

    public Internships(Integer internshipId) {
        this.internshipId = internshipId;
    }

    public Internships(Integer internshipId, String submitter, String info, String email, String relatedField, Date duration, Date startingDate) {
        this.internshipId = internshipId;
        this.submitter = submitter;
        this.info = info;
        this.email = email;
        this.relatedField = relatedField;
        this.duration = duration;
        this.startingDate = startingDate;
    }

    public Integer getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Integer internshipId) {
        this.internshipId = internshipId;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelatedField() {
        return relatedField;
    }

    public void setRelatedField(String relatedField) {
        this.relatedField = relatedField;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (internshipId != null ? internshipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Internships)) {
            return false;
        }
        Internships other = (Internships) object;
        if ((this.internshipId == null && other.internshipId != null) || (this.internshipId != null && !this.internshipId.equals(other.internshipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webProj.CourseIT.Beans.Internships[ internshipId=" + internshipId + " ]";
    }
    
}
