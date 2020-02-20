package com.appdev.asm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "trainee")
public class Trainee {
	@Id
	@Column(name = "traineeID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer traineeID;
	
	private String traineeName;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
    private AppUser appUser;
    

	private Date traineeDOB;
	private String Education;
	private String ProLanguage;
	private Double TOEICScore;
	private String Exp;
	private String Department;
	private String Location;
	
	  public Integer getTraineeID() {
		    return traineeID;
		  }

	  public void setTraineeID(Integer traineeID) {
	    this.traineeID = traineeID;
	  }

	  public String getTraineeName() {
	    return traineeName;
	  }

	  public void setTraineeName(String traineeName) {
	    this.traineeName = traineeName;
	  }
	  
	  public AppUser getAppUser() {
		    return appUser;
		  }

		  public void setAppUser(AppUser appUser) {
		    this.appUser = appUser;
		  }
		  
	  public Date getTraineeDOB() {
	    return traineeDOB;
	  }

	  public void setTraineeDOB(Date traineeDOB) {
	    this.traineeDOB = traineeDOB;
	  }
	  
	  public String getEducation() {
		    return Education;
		  }

	  public void setEducation(String Education) {
	    this.Education = Education;
	  }
	  
	  public String getProLanguage() {
		    return ProLanguage;
		  }

	  public void setProLanguage(String ProLanguage) {
	    this.ProLanguage = ProLanguage;
	  }
	  
	  public Double getTOEICScore() {
		    return TOEICScore;
		  }

	  public void setTOEICScore(Double TOEICScore) {
	    this.TOEICScore = TOEICScore;
	  }
	  
	  public String getExp() {
		    return Exp;
		  }

	  public void setExp(String Exp) {
	    this.Exp = Exp;
	  }
	  
	  public String getDepartment() {
		    return Department;
		  }

	  public void setDepartment(String Department) {
	    this.Department = Department;
	  }
	  
	  public String getLocation() {
		    return Location;
		  }

	  public void setLocation(String Location) {
	    this.Location = Location;
	  }
	  
	  public String toString() {
		  String str = this.Department+this.Education+this.Exp+this.TOEICScore+this.Location+this.ProLanguage+this.traineeName+this.appUser.getUsername();
		  return str.toLowerCase();
	  }
	  
	  
	
	
}
