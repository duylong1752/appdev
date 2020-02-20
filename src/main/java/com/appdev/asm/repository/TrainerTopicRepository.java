package com.appdev.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appdev.asm.entity.*;

public interface TrainerTopicRepository extends JpaRepository<TrainerTopic, Integer>{
	@Query(value ="select * from TrainerTopic where trainerID=?1", nativeQuery = true)
	Iterable <TrainerTopic> findByTrainerID(Integer trainerID);
	
	@Query(value ="select * from TrainerTopic where topicID=?1", nativeQuery = true)
	Iterable <TrainerTopic> findByTopicID(Integer topicID);
}
