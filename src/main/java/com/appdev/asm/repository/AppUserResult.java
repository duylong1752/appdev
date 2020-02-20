package com.appdev.asm.repository;

public class AppUserResult {
	private Integer userID;
	private String username;
	private String password;
	
	public AppUserResult(Integer id,String username,String password) {
		this.userID=id;
		this.username=username;
		this.password=password;
	}
	
	public Integer getUserID() {
	    return userID;
	  }

	  public void setUserID(Integer id) {
	    this.userID = id;
	  }
	
	  public String getUsername() {
	    return username;
	  }
	
	  public void setUserName(String username) {
	    this.username = username;
	  }
	  public String getPassword() {
	    return password;
	  }
	
	  public void setPassword(String password) {
	    this.password = password;
	  }
	  
	  public String toString() {
		  String str=this.username;
		  return str.toLowerCase();
	  }
}
