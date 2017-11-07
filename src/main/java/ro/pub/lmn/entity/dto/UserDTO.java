package ro.pub.lmn.entity.dto;

import ro.pub.lmn.entity.Role;
import ro.pub.lmn.entity.User;
import ro.pub.lmn.entity.UserDetails;
import ro.pub.lmn.enumm.PeopleEnum;

import java.sql.Blob;

/**
 * Created by radug on 11/1/2017.
 */
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Role role;

    private PeopleEnum userType;

    private String webSite;

    private String blog;

    private String researcherId;

    private String facebook;

    private Blob image;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String email, Role role, PeopleEnum userType, String webSite, String blog, String researcherId, String facebook, Blob image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.userType = userType;
        this.webSite = webSite;
        this.blog = blog;
        this.researcherId = researcherId;
        this.facebook = facebook;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public PeopleEnum getUserType() {
        return userType;
    }

    public void setUserType(PeopleEnum userType) {
        this.userType = userType;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(String researcherId) {
        this.researcherId = researcherId;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public UserDTO toUserDTO(User user){
        this.setId(user.getId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setRole(user.getRole());
        UserDetails userDetails = user.getUserDetails();
        this.setUserType(userDetails.getUserType());
        this.setBlog(userDetails.getBlog());
        this.setFacebook(userDetails.getFacebook());
        this.setResearcherId(userDetails.getResearcherId());
        this.setUserType(userDetails.getUserType());
        this.setWebSite(userDetails.getWebSite());
        this.setImage(userDetails.getImage());
        return this;
    }
}
