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
@Table(name = "topic")
public class Topic {
	@Id
	@Column(name = "topicID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer topicID;
	
	  @Column(name = "topicName")
	  private String topicName;
	  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;
	  
	  @Column(name = "Description")
	  private String Description;
	  
	  public Integer getTopicID() {
		    return topicID;
		  }

	  public void setTopicID(Integer topicID) {
	    this.topicID = topicID;
	  }

	  public String getTopicName() {
	    return topicName;
	  }

	  public void setTopicName(String topicName) {
	    this.topicName = topicName;
	  }
	  
	  public Course getCourse() {
		    return course;
		  }

		  public void setCourse(Course course) {
		    this.course = course;
		  }
		  
	  public String getDescription() {
	    return Description;
	  }

	  public void setDescription(String Description) {
	    this.Description = Description;
	  }
	  public String toString() {
		  String str=this.topicName+this.Description+this.course.getCourseName();
		  return str.toLowerCase();
	  }
}
