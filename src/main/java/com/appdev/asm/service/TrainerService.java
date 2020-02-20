package com.appdev.asm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.asm.repository.*;
import com.appdev.asm.entity.*;

@Service
public class TrainerService {
	private TrainerRepository trainerRepository;
	
	@Autowired
	public TrainerService(TrainerRepository trainerRepository) {
		this.trainerRepository=trainerRepository;
	}
	
	public Trainer saveTrainer(AppUser appUser) {
		Trainer trainer =new Trainer();
		trainer.setAppUser(appUser);
		return trainerRepository.save(trainer);
	}
	public void deleteTrainer(Integer id) {
		trainerRepository.delete(trainerRepository.findByUserID(id));
	}
}
