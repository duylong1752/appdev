package com.appdev.asm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appdev.asm.repository.*;
import com.appdev.asm.entity.*;

@Service
public class TrainerTopicService {
	private TrainerRepository trainerRepository;
	private TopicRepository topicRepository;
	private TrainerTopicRepository trainerTopicRepository;
	private CourseRepository courseRepository;
	
	@Autowired
	public TrainerTopicService(TrainerRepository trainerRepository, TopicRepository topicRepository,TrainerTopicRepository trainerTopicRepository, CourseRepository courseRepository ) {
		this.trainerRepository=trainerRepository;
		this.topicRepository=topicRepository;
		this.trainerTopicRepository=trainerTopicRepository;
		this.courseRepository=courseRepository;
	}
	
	public TrainerTopic saveTrainerTopic(TrainerTopic trainertopic) {
		trainertopic.setTrainer(trainerRepository.findById(trainertopic.getTrainer().getTrainerID()).get());
		trainertopic.setTopic(topicRepository.findById(trainertopic.getTopic().getTopicID()).get());
		return trainerTopicRepository.save(trainertopic);
	}
	public void deleteByAppUserID(Integer userID) {
		trainerTopicRepository.deleteInBatch(trainerTopicRepository.findByTrainerID(trainerRepository.findByUserID(userID).getTrainerID()));
	}
	public void deleteByTopicID(Integer topicID) {
		trainerTopicRepository.deleteInBatch(trainerTopicRepository.findByTopicID(topicID));
	}
	public void deleteByCourseID(Integer courseID) {
		Iterable<Topic> listTopic=topicRepository.findByCourseID(courseID);
		for(Topic topic : listTopic) {
			trainerTopicRepository.deleteInBatch(trainerTopicRepository.findByTopicID(topic.getTopicID()));
		}
	}
	public void deleteByCategoryID(Integer categoryID) {
		Iterable<Course> listCourse=courseRepository.findByCategoryID(categoryID);
		for(Course course : listCourse) {
			Iterable<Topic> listTopic = topicRepository.findByCourseID(course.getCourseID());
			for(Topic topic : listTopic) {
				trainerTopicRepository.deleteInBatch(trainerTopicRepository.findByTopicID(topic.getTopicID()));
			}
		}
	}
}
