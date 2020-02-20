package com.appdev.asm.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.appdev.asm.entity.*;
import com.appdev.asm.repository.*;
import com.appdev.asm.service.*;

@Controller
public class TrainerController {
	@Autowired
	TrainerRepository trainerRepository;
	@Autowired
	TrainerTopicRepository trainerTopicRepository;
	@Autowired
	TraineeCourseRepository traineeCourseRepositry;
	@Autowired
	AppUserRepository appUserRepository;

	
	///////////////////////////VIEW PROFILE////////////////////////////////
	@RequestMapping("/viewprofile-trainer")
	  public String trainerInfor(Model model, Principal principal) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
	    model.addAttribute("trainer", trainerRepository.findByUsername(loginedUser.getUsername()));
	    return "viewprofile-trainer";
	  }
	@RequestMapping("/trainerinfor-update/{username}")
	  public String update(@PathVariable String username, Model model) {
	    model.addAttribute("trainer", trainerRepository.findByUsername(username));
	    return "trainerinfor-update";
	  }
	  @RequestMapping("/updateTrainerInfor")
	  public ModelAndView doUpdateTrainer(@ModelAttribute("trainer") Trainer trainer,@RequestParam(value = "username") String username, BindingResult bindingResult) {  
		  ModelAndView modelAndView=new ModelAndView();
		  trainer.setAppUser(appUserRepository.findByUsername(username));;
		  trainerRepository.save(trainer);
	  		  modelAndView.addObject("trainer",trainerRepository.findByUsername(username));
	          modelAndView.setViewName("viewprofile-trainer");
	        return modelAndView;
	  }
	  
	  //////////////////////////////VIEW COURSE////////////////////////////////////
	  
		@RequestMapping("/viewcourse-trainer")
		  public String viewCourse(Model model, Principal principal) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			//List<Course> listCourse=new ArrayList<Course>();
			List<Topic> listTopic=new ArrayList<Topic>();
			Iterable<TrainerTopic> listTrainerTopic=trainerTopicRepository.findByTrainerID(trainerRepository.findByUsername(loginedUser.getUsername()).getTrainerID());
			for(TrainerTopic trainertopic:listTrainerTopic) {
				//listCourse.add(trainertopic.getTopic().getCourse());
				listTopic.add(trainertopic.getTopic());
			}	
		    model.addAttribute("listTopic", listTopic);
		    return "viewcourse-trainer";
		  }
		
}
