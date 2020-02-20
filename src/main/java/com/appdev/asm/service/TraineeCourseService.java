package com.appdev.asm.service;
import com.appdev.asm.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.asm.entity.*;

@Service
public class TraineeCourseService {
	private TraineeRepository traineeRepository;
	private CourseRepository courseRepository;
	private TraineeCourseRepository traineeCourseRepository;
	
	@Autowired
	public TraineeCourseService(TraineeRepository traineeRepository, CourseRepository courseRepository,TraineeCourseRepository traineeCourseRepository ) {
		this.traineeRepository=traineeRepository;
		this.courseRepository=courseRepository;
		this.traineeCourseRepository=traineeCourseRepository;
	}
	
	public TraineeCourse saveTraineeCourse(TraineeCourse traineecourse) {
		traineecourse.setTrainee(traineeRepository.findById(traineecourse.getTrainee().getTraineeID()).get());
		traineecourse.setCourse(courseRepository.findById(traineecourse.getCourse().getCourseID()).get());
		return traineeCourseRepository.save(traineecourse);
	}
	public void deleteByTraineeID(Integer id) {
		traineeCourseRepository.deleteInBatch(traineeCourseRepository.findByTraineeID(id));
	}
	public void deleteByCourseID(Integer id) {
		traineeCourseRepository.deleteInBatch(traineeCourseRepository.findByCourseID(id));
	}
	public void deleteByCategoryID(Integer id) {
		Iterable<Course> listCourse=courseRepository.findByCategoryID(id);
		for(Course course : listCourse) {
			traineeCourseRepository.deleteInBatch(traineeCourseRepository.findByCourseID(course.getCourseID()));
		}
	}
}
