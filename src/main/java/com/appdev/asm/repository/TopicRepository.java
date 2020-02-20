package com.appdev.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appdev.asm.entity.*;

public interface TopicRepository extends JpaRepository<Topic, Integer>{
	@Query(value ="select * from Topic a where a.topicName=?1", nativeQuery = true)
	Topic findByTopicName(String topicName);
	
	@Query(value ="select * from Topic where courseID=?1", nativeQuery = true)
	Iterable <Topic> findByCourseID(Integer courseID);
}
