package com.appdev.asm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "userrole")
public class UserRole {
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private Integer id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
    private AppUser appUser;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleID", nullable = false)
    private RoleDetail roleDetail;
	  
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public AppUser getUser() {
        return appUser;
    }
 
    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }
 
    public RoleDetail getRole() {
        return roleDetail;
    }
 
    public void setRole(RoleDetail roleDetail) {
        this.roleDetail = roleDetail;
    }
}
