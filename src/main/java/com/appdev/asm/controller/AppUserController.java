package com.appdev.asm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AppUserController {

	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private TrainerAccountService trainerAccountService;
	@Autowired
	private TrainingStaffService trainingStaffService;
	@Autowired
	private TrainerService trainerService;
	@Autowired
	TrainerTopicService trainerTopicService;
	
	@RequestMapping("/traineraccount-list")
	  public String listTrainerAccount(Model model) {
	    model.addAttribute("listTrainerAccount", appUserRepository.findTrainer());
	    return "traineraccount-list";
	  }
	  @RequestMapping("/traineraccount-save")
	  public String insertTrainerAccount(Model model) {
	    model.addAttribute("trainerAccount", new AppUser());
	    return "traineraccount-save";
	  }
	  
	  @RequestMapping("/traineraccount-update/{id}")
	  public String updateCustomer(@PathVariable int id, Model model) {
		Optional<AppUser> appUser = appUserRepository.findById(id);
		if (appUser.isPresent()) {
	        model.addAttribute("trainerAccount", appUser.get());
	     }
	    return "traineraccount-update";
	  }
	  @RequestMapping("/saveTraineraccount")
	  public ModelAndView doSaveAppUser(@ModelAttribute("trainerAccount") AppUser appUser, BindingResult bindingResult) {  
		  ModelAndView modelAndView=new ModelAndView();
		  AppUser userExists = appUserRepository.findByUsername(appUser.getUsername());
	        if (userExists != null) {
	        	bindingResult.rejectValue("username", "error.username","There is already a user registered with the Username provided");
	        }
	        if (bindingResult.hasErrors()) {
	            modelAndView.setViewName("traineraccount-save");
	        }
	        else {
	  		  trainerAccountService.saveTrainerAccount(appUser);
	  		  trainerAccountService.saveUserRole(appUser);
	  		  
	  		trainerService.saveTrainer(appUser);
	  		
	  		  modelAndView.addObject("listTrainerAccount",appUserRepository.findTrainer());
	          modelAndView.setViewName("traineraccount-list");
	        }
	        return modelAndView;
	  }
	  @RequestMapping("/updateTraineraccount")
	  public ModelAndView doUpdateAppUser(@ModelAttribute("trainerAccount") AppUser appUser, BindingResult bindingResult) {  
		  ModelAndView modelAndView=new ModelAndView();
	  		  trainerAccountService.saveTrainerAccount(appUser);
	  		  modelAndView.addObject("listTrainerAccount",appUserRepository.findTrainer());
	          modelAndView.setViewName("traineraccount-list");
	        return modelAndView;
	  }
	  
	  @RequestMapping("/traineraccountDelete/{id}")
	  public String doDeleteAppUser(@PathVariable int id, Model model) {
		  trainerTopicService.deleteByAppUserID(id);
		 trainerService.deleteTrainer(id);
		trainerAccountService.deleteUserRole(id);
		appUserRepository.deleteById(id);
	    model.addAttribute("listTrainerAccount", appUserRepository.findTrainer());
	    return "traineraccount-list";
	  }
	  
	  @RequestMapping("/searchTraineraccount")
	  public String search(@RequestParam(value = "searchKey") String searchKey, Model model) {
		List<AppUserResult> listUser = new ArrayList<AppUserResult>();
		for(AppUserResult user:appUserRepository.findTrainer()) {
			if(user.toString().contains(searchKey)) {
				listUser.add(user);
			}
		}
	    model.addAttribute("listTrainerAccount", listUser);
	    return "traineraccount-list";
	  }
	  
	  //////////////////////////////////////////////Training Staff Account /////////////////////////////
	  
	  @RequestMapping("/trainingstaff-list")
	  public String listTrainingStaff(Model model) {
	    model.addAttribute("listTrainingStaff", appUserRepository.findTrainingStaff());
	    return "trainingstaff-list";
	  }
	  @RequestMapping("/trainingstaff-save")
	  public String insertTrainingStaff(Model model) {
	    model.addAttribute("trainingStaff", new AppUser());
	    return "trainingstaff-save";
	  }
	  
	  @RequestMapping("/trainingstaff-update/{id}")
	  public String updateTrainingStaff(@PathVariable int id, Model model) {
		Optional<AppUser> appUser = appUserRepository.findById(id);
		if (appUser.isPresent()) {
	        model.addAttribute("trainingStaff", appUser.get());
	     }
	    return "trainingstaff-update";
	  }
	  @RequestMapping("/saveTrainingstaff")
	  public ModelAndView doSaveTrainingstaff(@ModelAttribute("trainingStaff") AppUser appUser, BindingResult bindingResult) {  
		  ModelAndView modelAndView=new ModelAndView();
		  AppUser userExists = appUserRepository.findByUsername(appUser.getUsername());
	        if (userExists != null) {
	        	bindingResult.rejectValue("username", "error.username","There is already a user registered with the Username provided");
	        }
	        if (bindingResult.hasErrors()) {
	            modelAndView.setViewName("trainingstaff-save");
	        }
	        else {   	
	  		  trainingStaffService.saveTrainingStaff(appUser);
	  		  trainingStaffService.saveUserRole(appUser);
	  		  modelAndView.addObject("listTrainingStaff",appUserRepository.findTrainingStaff());
	          modelAndView.setViewName("trainingstaff-list");
	        }
	        return modelAndView;
	  }
	  @RequestMapping("/updateTrainingstaff")
	  public ModelAndView doUpdateTrainingStaff(@ModelAttribute("trainingStaff") AppUser appUser, BindingResult bindingResult) {  
		  ModelAndView modelAndView=new ModelAndView();
	  		  trainingStaffService.saveTrainingStaff(appUser);
	  		  modelAndView.addObject("listTrainingStaff",appUserRepository.findTrainingStaff());
	          modelAndView.setViewName("trainingstaff-list");
	        return modelAndView;
	  }
	  
	  @RequestMapping("/trainingstaffDelete/{id}")
	  public String doDeleteTrainingstaff(@PathVariable int id, Model model) {
		trainerAccountService.deleteUserRole(id);
		appUserRepository.deleteById(id);
	    model.addAttribute("listTrainingStaff", appUserRepository.findTrainingStaff());
	    return "trainingstaff-list";
	  }
	  
	  @RequestMapping("/searchTrainingstaff")
	  public String searchTrainingstaff(@RequestParam(value = "searchKey") String searchKey, Model model) {
		List<AppUserResult> listUser = new ArrayList<AppUserResult>();
		for(AppUserResult user:appUserRepository.findTrainingStaff()) {
			if(user.toString().contains(searchKey)) {
				listUser.add(user);
			}
		}
	    model.addAttribute("listTrainingStaff", listUser);
	    return "trainingstaff-list";
	  }

}
