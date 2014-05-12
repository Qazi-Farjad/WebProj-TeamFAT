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
@Table(name = "review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
    @NamedQuery(name = "Review.findByRid", query = "SELECT r FROM Review r WHERE r.rid = :rid"),
    @NamedQuery(name = "Review.findByReviews", query = "SELECT r FROM Review r WHERE r.reviews = :reviews"),
    @NamedQuery(name = "Review.findByReviewUV", query = "SELECT r FROM Review r WHERE r.reviewUV = :reviewUV")})
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Rid")
    private Integer rid;
    @Basic(optional = false)
    @Column(name = "Reviews")
    private String reviews;
    @Basic(optional = false)
    @Column(name = "Review_UV")
    private int reviewUV;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Useraccinfo userId;
    @JoinColumn(name = "Course_ID", referencedColumnName = "Course_ID")
    @ManyToOne(optional = false)
    private Courses courseID;

    public Review() {
    }

    public Review(Integer rid) {
        this.rid = rid;
    }

    public Review(Integer rid, String reviews, int reviewUV) {
        this.rid = rid;
        this.reviews = reviews;
        this.reviewUV = reviewUV;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public int getReviewUV() {
        return reviewUV;
    }

    public void setReviewUV(int reviewUV) {
        this.reviewUV = reviewUV;
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
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webProj.CourseIT.Beans.Review[ rid=" + rid + " ]";
    }
    
}
