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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Farjad
 */
@Entity
@Table(name = "useracademicinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useracademicinfo.findAll", query = "SELECT u FROM Useracademicinfo u"),
    @NamedQuery(name = "Useracademicinfo.findByUserId", query = "SELECT u FROM Useracademicinfo u WHERE u.userId = :userId"),
    @NamedQuery(name = "Useracademicinfo.findByUni", query = "SELECT u FROM Useracademicinfo u WHERE u.uni = :uni"),
    @NamedQuery(name = "Useracademicinfo.findBySchool", query = "SELECT u FROM Useracademicinfo u WHERE u.school = :school"),
    @NamedQuery(name = "Useracademicinfo.findByDegree", query = "SELECT u FROM Useracademicinfo u WHERE u.degree = :degree")})
public class Useracademicinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "uni")
    private String uni;
    @Column(name = "school")
    private String school;
    @Basic(optional = false)
    @Column(name = "degree")
    private String degree;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Useraccinfo useraccinfo;

    public Useracademicinfo() {
    }

    public Useracademicinfo(Integer userId) {
        this.userId = userId;
    }

    public Useracademicinfo(Integer userId, String uni, String school, String degree) {
        this.userId = userId;
        this.school = school;
        this.uni = uni;
        this.degree = degree;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Useraccinfo getUseraccinfo() {
        return useraccinfo;
    }

    public void setUseraccinfo(Useraccinfo useraccinfo) {
        this.useraccinfo = useraccinfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useracademicinfo)) {
            return false;
        }
        Useracademicinfo other = (Useracademicinfo) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webProj.CourseIT.Beans.Useracademicinfo[ userId=" + userId + " ]";
    }
    
}
