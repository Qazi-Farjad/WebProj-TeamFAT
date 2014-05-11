/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Beans.AutoGen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "useraccinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useraccinfo.findAll", query = "SELECT u FROM Useraccinfo u"),
    @NamedQuery(name = "Useraccinfo.findByUserId", query = "SELECT u FROM Useraccinfo u WHERE u.userId = :userId"),
    @NamedQuery(name = "Useraccinfo.findByName", query = "SELECT u FROM Useraccinfo u WHERE u.name = :name"),
    @NamedQuery(name = "Useraccinfo.findByEmail", query = "SELECT u FROM Useraccinfo u WHERE u.email = :email"),
    @NamedQuery(name = "Useraccinfo.findByPassword", query = "SELECT u FROM Useraccinfo u WHERE u.password = :password"),
    @NamedQuery(name = "Useraccinfo.findByUserPic", query = "SELECT u FROM Useraccinfo u WHERE u.userPic = :userPic"),
    @NamedQuery(name = "Useraccinfo.findByInternship", query = "SELECT u FROM Useraccinfo u WHERE u.internship = :internship")})
public class Useraccinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "user_pic")
    private String userPic;
    @Column(name = "Internship")
    private Integer internship;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "useraccinfo")
    private Useracademicinfo useracademicinfo;

    public Useraccinfo() {
    }

    public Useraccinfo(String userId) {
        this.userId = userId;
    }

    public Useraccinfo(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public Integer getInternship() {
        return internship;
    }

    public void setInternship(Integer internship) {
        this.internship = internship;
    }

    public Useracademicinfo getUseracademicinfo() {
        return useracademicinfo;
    }

    public void setUseracademicinfo(Useracademicinfo useracademicinfo) {
        this.useracademicinfo = useracademicinfo;
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
        if (!(object instanceof Useraccinfo)) {
            return false;
        }
        Useraccinfo other = (Useraccinfo) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webProj.CourseIT.Beans.AutoGen.Useraccinfo[ userId=" + userId + " ]";
    }
    
}
