package com.appdev.asm.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roledetail")
public class RoleDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer roleID;
	  private String roleName;
	  
	  public Integer getRoleID() {
		    return roleID;
		  }

		  public void setRoleID(Integer roleID) {
		    this.roleID = roleID;
		  }

		  public String getRoleName() {
		    return roleName;
		  }

		  public void setRoleName(String roleName) {
		    this.roleName = roleName;
		  }
}
