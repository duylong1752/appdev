package com.appdev.asm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trainer")
public class Trainer {
	@Id
	@Column(name = "trainerID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer trainerID;
	
	private String trainerName;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
    private AppUser appUser;
    
	private String ExterorInter;
	private String Education;
	private String WorkingPlace;
	private String Telephone;
	private String Email;
	
	public Integer getTrainerID() {
	    return trainerID;
	  }

  public void setTrainerID(Integer trainerID) {
    this.trainerID = trainerID;
  }

  public String getTrainerName() {
    return trainerName;
  }

  public void setTrainerName(String trainerName) {
    this.trainerName = trainerName;
  }
  
  public AppUser getAppUser() {
	    return appUser;
	  }

	  public void setAppUser(AppUser appUser) {
	    this.appUser = appUser;
	  }
	  public String getExterorInter() {
		    return ExterorInter;
		  }

	  public void setExterorInter(String ExterorInter) {
	    this.ExterorInter = ExterorInter;
	  }
	  
	  public String getEducation() {
		    return Education;
		  }

	  public void setEducation(String Education) {
	    this.Education = Education;
	  }
	  
	  public String getWorkingPlace() {
		    return WorkingPlace;
		  }

	  public void setWorkingPlace(String WorkingPlace) {
	    this.WorkingPlace = WorkingPlace;
	  }
	  
	  public String getTelephone() {
		    return Telephone;
		  }

	  public void setTelephone(String Telephone) {
	    this.Telephone = Telephone;
	  }
	  public String getEmail() {
		    return Email;
		  }

	  public void setEmail(String Email) {
	    this.Email = Email;
	  }
	  
	  public String toString() {
		  String str=this.trainerName+this.ExterorInter+this.WorkingPlace+this.Education+this.Telephone+this.Email+this.appUser.getUsername();
		  return str.toLowerCase();
	  }
}
