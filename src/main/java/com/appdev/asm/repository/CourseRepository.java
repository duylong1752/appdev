package com.appdev.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appdev.asm.entity.Category;
import com.appdev.asm.entity.Course;
import com.appdev.asm.entity.Topic;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	@Query(value ="select * from Course a where a.courseName=?1", nativeQuery = true)
	Course findByCourseName(String courseName);
	
	@Query(value ="select * from Course where categoryID=?1", nativeQuery = true)
	Iterable <Course> findByCategoryID(Integer categoryID);
}
