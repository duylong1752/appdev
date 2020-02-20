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
@Table(name = "course")
public class Course {
	@Id
	@Column(name = "courseID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer courseID;
	
	  @Column(name = "courseName")
	  private String courseName;
	  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryID", nullable = false)
    private Category category;
	  
	  @Column(name = "Description")
	  private String Description;
	  
	  public Integer getCourseID() {
		    return courseID;
		  }

	  public void setCourseID(Integer courseID) {
	    this.courseID = courseID;
	  }

	  public String getCourseName() {
	    return courseName;
	  }

	  public void setCourseName(String courseName) {
	    this.courseName = courseName;
	  }
	  
	  public Category getCategory() {
		    return category;
		  }

		  public void setCategory(Category category) {
		    this.category = category;
		  }
		  
	  public String getDescription() {
	    return Description;
	  }

	  public void setDescription(String Description) {
	    this.Description = Description;
	  }
	  public String toString() {
		  String str=this.courseName+this.Description+this.category.getCategoryName();
		  return str.toLowerCase();
	  }
}
