package ro.pub.lmn.entity;

import ro.pub.lmn.enumm.PeopleEnum;

import javax.persistence.*;

/**
 * Created by radug on 11/1/2017.
 */

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private PeopleEnum userType;

    private String webSite;

    private String blog;

    private String researcherId;

    private String facebook;

    public UserDetails() {
    }

    public UserDetails(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public PeopleEnum getUserType() {
        return userType;
    }

    public void setUserType(PeopleEnum userType) {
        this.userType = userType;
    }

    public java.lang.String getWebSite() {
        return webSite;
    }

    public void setWebSite(java.lang.String webSite) {
        this.webSite = webSite;
    }

    public java.lang.String getBlog() {
        return blog;
    }

    public void setBlog(java.lang.String blog) {
        this.blog = blog;
    }

    public java.lang.String getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(java.lang.String researcherId) {
        this.researcherId = researcherId;
    }

    public java.lang.String getFacebook() {
        return facebook;
    }

    public void setFacebook(java.lang.String facebook) {
        this.facebook = facebook;
    }
}
