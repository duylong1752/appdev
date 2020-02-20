package com.appdev.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appdev.asm.entity.*;

public interface TraineeCourseRepository extends JpaRepository<TraineeCourse, Integer> {
	@Query(value ="select * from TraineeCourse where traineeID=?1", nativeQuery = true)
	Iterable <TraineeCourse> findByTraineeID(Integer traineeID);
	
	@Query(value ="select * from TraineeCourse where courseID=?1", nativeQuery = true)
	Iterable <TraineeCourse> findByCourseID(Integer courseID);
}
