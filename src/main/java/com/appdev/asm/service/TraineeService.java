package com.appdev.asm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.asm.entity.AppUser;
import com.appdev.asm.entity.Trainee;
import com.appdev.asm.repository.AppUserRepository;
import com.appdev.asm.repository.TraineeRepository;
import com.appdev.asm.utils.EncrytedPasswordUtils;

@Service
public class TraineeService {
	private TraineeRepository traineeRepository;
	private AppUserRepository appUserRepository;
	
	@Autowired
	public TraineeService(TraineeRepository traineeRepository, AppUserRepository appUserRepository) {
		this.traineeRepository=traineeRepository;
		this.appUserRepository=appUserRepository;
	}
	
	
	 public Trainee saveTrainee(String username, String password, Trainee trainee){ 
		AppUser appUser=new AppUser(); 
		appUser.setUsername(username);
		appUser.setPassword(EncrytedPasswordUtils.encrytePassword(password));
	  	appUserRepository.save(appUser); 
	  	trainee.setAppUser(appUser); 
	  	return traineeRepository.save(trainee); 
	  }
	 
	
	
}
