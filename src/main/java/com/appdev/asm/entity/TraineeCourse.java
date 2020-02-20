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
@Table(name = "traineecourse")
public class TraineeCourse {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer ID;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "traineeID", nullable = false)
    private Trainee trainee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;
    
    
    public Integer getID() {
		    return ID;
		  }
	
	  public void setID(Integer ID) {
	    this.ID = ID;
	  }
	  
	  public Trainee getTrainee() {
		    return trainee;
		  }

	  public void setTrainee(Trainee trainee) {
	    this.trainee = trainee;
	  }
  public Course getCourse() {
	    return course;
	  }

	  public void setCourse(Course course) {
	    this.course = course;
	  }

	  public String toString() {
		  String str=this.trainee.getAppUser().getUsername()+this.course.getCourseName();
		  return str.toLowerCase();
	  }
}
