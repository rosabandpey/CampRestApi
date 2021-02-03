package com.camp.campApi.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="appuser")
public class AppUser implements Serializable {

    private static final long serialVersionUID = -6955836358739196276L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id;

    private String firstName;
    private String lastName;


    @Column(nullable = false,updatable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String sex;
    private Date birthdate;

    @OneToMany(mappedBy = "appuser",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<UserRole> userRoles=new HashSet<>();



    public AppUser() {
    }

    public AppUser(long id, String firstName, String lastName, String email, String password, String sex, Date birthdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.birthdate = birthdate;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRole userRole) {
        userRoles.add(userRole);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }



}
