/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Useraccinfo.findByUserPic", query = "SELECT u FROM Useraccinfo u WHERE u.userPic = :userPic")})
public class Useraccinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Courseenroll> courseenrollCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "useraccinfo")
    private Useracademicinfo useracademicinfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Review> reviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Coursehistory> coursehistoryCollection;

    public Useraccinfo() {
    }

    public Useraccinfo(Integer userId) {
        this.userId = userId;
    }

    public Useraccinfo(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    @XmlTransient
    public Collection<Courseenroll> getCourseenrollCollection() {
        return courseenrollCollection;
    }

    public void setCourseenrollCollection(Collection<Courseenroll> courseenrollCollection) {
        this.courseenrollCollection = courseenrollCollection;
    }

    public Useracademicinfo getUseracademicinfo() {
        return useracademicinfo;
    }

    public void setUseracademicinfo(Useracademicinfo useracademicinfo) {
        this.useracademicinfo = useracademicinfo;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    @XmlTransient
    public Collection<Coursehistory> getCoursehistoryCollection() {
        return coursehistoryCollection;
    }

    public void setCoursehistoryCollection(Collection<Coursehistory> coursehistoryCollection) {
        this.coursehistoryCollection = coursehistoryCollection;
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
        return "webProj.CourseIT.Beans.Useraccinfo[ userId=" + userId + " ]";
    }
    
}
