package com.appdev.asm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@Column(name = "categoryID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer categoryID;
	
	  @Column(name = "categoryName")
	  private String categoryName;
	  
	  @Column(name = "Description")
	  private String Description;
	  
	  public Integer getCategoryID() {
		    return categoryID;
		  }

	  public void setCategoryID(Integer categoryID) {
	    this.categoryID = categoryID;
	  }

	  public String getCategoryName() {
	    return categoryName;
	  }

	  public void setCategoryName(String categoryName) {
	    this.categoryName = categoryName;
	  }
	  public String getDescription() {
	    return Description;
	  }

	  public void setDescription(String Description) {
	    this.Description = Description;
	  }
	  public String toString() {
		  String str=this.categoryName+this.Description;
		  return str.toLowerCase();
	  }
}
