package ro.pub.lmn.entity;

import javassist.bytecode.ByteArray;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.pub.lmn.annotations.IgnoreEntityToDTO;
import ro.pub.lmn.annotations.Language;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by radug on 6/19/2017.
 */

@Entity
public class User {
    @IgnoreEntityToDTO
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 4)
    @IgnoreEntityToDTO
    private String password;

    @NotNull
    @Language(DTOField = "firstName")
    private String firstName;

    @NotNull
    @Language(DTOField = "lastName")
    private String lastName;

    @NotNull
    @Email
    private String email;

    @ManyToOne
    @IgnoreEntityToDTO
    private Role role;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private UserDetails userDetails;

    public User() {
        id = null;
    }

    public User(String email, String password, String firstName, String lastName, Role role) {
        this();
        this.setPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.userDetails = new UserDetails(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
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

    public UserDetails getUserDetails() {
        return userDetails;
    }
}
