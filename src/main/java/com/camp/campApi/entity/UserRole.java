package com.camp.campApi.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="userrole")
public class UserRole  implements Serializable {

    private static final long serialVersionUID = -121838495708416186L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long userRoleId;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name="userId")
    private AppUser appuser;

    public UserRole() {
    }


    public UserRole(  AppUser appuser,Role role) {

        this.appuser = appuser;
        this.role = role;
    }

    public UserRole(long userRoleId, Role role, AppUser appuser) {
        this.userRoleId = userRoleId;
        this.role = role;
        this.appuser = appuser;
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AppUser getAppuser() {
        return appuser;
    }

    public void setAppuser(AppUser appuser) {
        this.appuser = appuser;
    }
}
