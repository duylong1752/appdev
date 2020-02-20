package com.appdev.asm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.appdev.asm.repository.*;
import com.appdev.asm.service.*;
import com.appdev.asm.entity.*;

@Controller
public class TrainingStaffController {
	@Autowired
	TraineeRepository traineeRepository;
	@Autowired
	AppUserRepository appUserRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	TopicRepository topicRepository;
	@Autowired
	TrainerRepository trainerRepository;
	@Autowired
	TrainerTopicRepository trainerTopicRepository;
	@Autowired
	TraineeCourseRepository traineeCourseRepository;
	@Autowired
	TraineeService traineeService;
	@Autowired
	TrainerTopicService trainerTopicService;
	@Autowired
	TraineeCourseService traineeCourseService;
	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    ///////////TRAINEE/////////////////////////////////////////////////////
	@RequestMapping("/trainee-list")
	  public String listTrainee(Model model) {
	    model.addAttribute("listTrainee", traineeRepository.findAll());
	    return "trainee-list";
	  }
	  @RequestMapping("/trainee-save")
	  public String insertTrainee(Model model) {
	    model.addAttribute("trainee", new Trainee());
	    return "trainee-save";
	  }
	  
	  @RequestMapping("/trainee-update/{id}")
	  public String updateTrainee(@PathVariable int id, Model model) {
		Optional<Trainee> trainee = traineeRepository.findById(id);
		if (trainee.isPresent()) {
	        model.addAttribute("trainee", trainee.get());
	     }
	    return "trainee-update";
	  }

	
	  @RequestMapping("/saveTrainee") 
	  public ModelAndView doSaveAppUser(@ModelAttribute("trainee") Trainee trainee, BindingResult bindingResult, 
			  			@RequestParam(value = "username") String username, @RequestParam(value ="password") String password) { 
		  ModelAndView modelAndView=new ModelAndView();
		  AppUser userExists = appUserRepository.findByUsername(username);
	        if (userExists != null) {
	        	bindingResult.rejectValue("Exp", "error.Exp","There is already a user registered with the Username provided");
	        }
	        if (bindingResult.hasErrors()) {
	            modelAndView.setViewName("trainee-save");
	        }
	        else {  
		  traineeService.saveTrainee(username, password, trainee);
		  modelAndView.addObject("listTrainee",traineeRepository.findAll());
		  modelAndView.setViewName("trainee-list"); 
	        }
	  	
	  	return modelAndView; 
	  }
	 
	  @RequestMapping("/updateTrainee")
	  public ModelAndView doUpdateTrainee(@ModelAttribute("trainee") Trainee trainee,@RequestParam(value = "username") String username, BindingResult bindingResult) {  
		  ModelAndView modelAndView=new ModelAndView();
		  trainee.setAppUser(appUserRepository.findByUsername(username));;
		  traineeRepository.save(trainee);
	  		  modelAndView.addObject("listTrainee",traineeRepository.findAll());
	          modelAndView.setViewName("trainee-list");
	        return modelAndView;
	  }
	  
	  @RequestMapping("/traineeDelete/{id}")
	  public String doDeleteTrainee(@PathVariable int id, Model model) {
		  traineeCourseService.deleteByTraineeID(id);
		  Optional<Trainee> trainee = traineeRepository.findById(id);
		  traineeRepository.deleteById(id);
		  appUserRepository.deleteById(trainee.get().getAppUser().getUserID());  
		  
	    model.addAttribute("listTrainee", traineeRepository.findAll());
	    return "trainee-list";
	  }
	  
	  @RequestMapping("/searchTrainee")
	  public String search(@RequestParam(value = "searchKey") String searchKey, Model model) {
		List<Trainee> listTrainee = new ArrayList<Trainee>();
		for(Trainee trainee:traineeRepository.findAll()) {
			if(trainee.toString().contains(searchKey)) {
				listTrainee.add(trainee);
			}
		}
	    model.addAttribute("listTrainee", listTrainee);
	    return "trainee-list";
	  }
	  
	  ///////////CATEGORY/////////////////////////////////////////////////////
	@RequestMapping("/category-list")
	  public String listCategory(Model model) {
	    model.addAttribute("listCategory", categoryRepository.findAll());
	    return "category-list";
	  }
	  @RequestMapping("/category-save")
	  public String insertCategory(Model model) {
	    model.addAttribute("category", new Category());
	    return "category-save";
	  }
	  
	  @RequestMapping("/category-update/{id}")
	  public String updateCategory(@PathVariable int id, Model model) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
	        model.addAttribute("category", category.get());
	     }
	    return "category-update";
	  }

	
	  @RequestMapping("/saveCategory") 
	  public ModelAndView doSaveCategory(@ModelAttribute("category") Category category, BindingResult bindingResult) { 
		  ModelAndView modelAndView=new ModelAndView();
		  Category categoryExists = categoryRepository.findByCategoryName(category.getCategoryName());
	        if (categoryExists != null) {
	        	bindingResult.rejectValue("categoryName", "error.categoryName","There is already Category registered with the Category Name provided");
	        }
	        if (bindingResult.hasErrors()) {
	            modelAndView.setViewName("category-save");
	        }
	        else {  
		  categoryRepository.save(category);
		  modelAndView.addObject("listCategory",categoryRepository.findAll());
		  modelAndView.setViewName("category-list"); 
	        }
	  	
	  	return modelAndView; 
	  }
	 
	  @RequestMapping("/updateCategory")
	  public ModelAndView doUpdateCategory(@ModelAttribute("category") Category category, BindingResult bindingResult) {  
		  ModelAndView modelAndView=new ModelAndView();
		  categoryRepository.save(category);
	  		  modelAndView.addObject("listCategory",categoryRepository.findAll());
	          modelAndView.setViewName("category-list");
	        return modelAndView;
	  }
	  
	  @RequestMapping("/categoryDelete/{id}")
	  public String doDeleteCategory(@PathVariable int id, Model model) {
		  trainerTopicService.deleteByCategoryID(id);
		  traineeCourseService.deleteByCategoryID(id);
		  Iterable<Course> listCourse=courseRepository.findByCategoryID(id);
		  for(Course course:listCourse) {
			  topicRepository.deleteInBatch(topicRepository.findByCourseID(course.getCourseID()));
		  }
		  courseRepository.deleteInBatch(listCourse);
		  categoryRepository.deleteById(id); 
	    model.addAttribute("listCategory", categoryRepository.findAll());
	    return "category-list";
	  }
	  
	  @RequestMapping("/searchCategory")
	  public String searchCate(@RequestParam(value = "searchKey") String searchKey, Model model) {
		List<Category> listCategory = new ArrayList<Category>();
		for(Category category:categoryRepository.findAll()) {
			if(category.toString().contains(searchKey)) {
				listCategory.add(category);
			}
		}
	    model.addAttribute("listCategory", listCategory);
	    return "category-list";
	  }
	  
	  //////////////////////COURSE//////////////////////////////////////////
	  
	@RequestMapping("/course-list")
	  public String listCourse(Model model) {
	    model.addAttribute("listCourse", courseRepository.findAll());
	    return "course-list";
	  }
	  @RequestMapping("/course-save")
	  public String insertCourse(Model model) {
	    model.addAttribute("course", new Course());
	    List<Category> listCategory=categoryRepository.findAll();
	    model.addAttribute("listCategory", listCategory);
	    return "course-save";
	  }
	  
	  @RequestMapping("/course-update/{id}")
	  public String updateCourse(@PathVariable int id, Model model) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
	        model.addAttribute("course", course.get());
	        List<Category> listCategory=categoryRepository.findAll();
		    model.addAttribute("listCategory", listCategory);
	     }
	    return "course-update";
	  }

	
	  @RequestMapping("/saveCourse") 
	  public ModelAndView doSaveCourse(@ModelAttribute("course") Course course, BindingResult bindingResult) { 
		  ModelAndView modelAndView=new ModelAndView();
		  Course courseExists = courseRepository.findByCourseName(course.getCourseName());
	        if (courseExists != null) {
	        	bindingResult.rejectValue("courseName", "error.courseName","There is already Course registered with the Course Name provided");
	        }
	        if (bindingResult.hasErrors()) {
	    	    List<Category> listCategory=categoryRepository.findAll();
	    	    modelAndView.addObject("listCategory", listCategory);
	            modelAndView.setViewName("course-save");
	        }
	        else {
		  courseRepository.save(course);
		  modelAndView.addObject("listCourse",courseRepository.findAll());
		  modelAndView.setViewName("course-list"); 
	        }
	  	
	  	return modelAndView; 
	  }
	 
	  @RequestMapping("/updateCourse")
	  public ModelAndView doUpdateCourse(@ModelAttribute("course") Course course, BindingResult bindingResult) {  
		  ModelAndView modelAndView=new ModelAndView();
		  courseRepository.save(course);
	  		  modelAndView.addObject("listCourse",courseRepository.findAll());
	          modelAndView.setViewName("course-list");
	        return modelAndView;
	  }
	  
	  @RequestMapping("/courseDelete/{id}")
	  public String doDeleteCourse(@PathVariable int id, Model model) {
		  trainerTopicService.deleteByCourseID(id);
		  traineeCourseService.deleteByCourseID(id);
		  topicRepository.deleteInBatch(topicRepository.findByCourseID(id));
		  courseRepository.deleteById(id); 
	    model.addAttribute("listCourse", courseRepository.findAll());
	    return "course-list";
	  }
	  
	  @RequestMapping("/searchCourse")
	  public String searchCourse(@RequestParam(value = "searchKey") String searchKey, Model model) {
		List<Course> listCourse = new ArrayList<Course>();
		for(Course course:courseRepository.findAll()) {
			if(course.toString().contains(searchKey)) {
				listCourse.add(course);
			}
		}
	    model.addAttribute("listCourse", listCourse);
	    return "course-list";
	  }
	  
	  /////////////////////TOPIC/////////////////////////////////////////////
		@RequestMapping("/topic-list")
	  public String listTopic(Model model) {
	    model.addAttribute("listTopic", topicRepository.findAll());
	    return "topic-list";
	  }
	  @RequestMapping("/topic-save")
	  public String insertTopic(Model model) {
	    model.addAttribute("topic", new Topic());
	    List<Course> listCourse=courseRepository.findAll();
	    model.addAttribute("listCourse", listCourse);
	    return "topic-save";
	  }
	  
	  @RequestMapping("/topic-update/{id}")
	  public String updateTopic(@PathVariable int id, Model model) {
		Optional<Topic> topic = topicRepository.findById(id);
		if (topic.isPresent()) {
	        model.addAttribute("topic", topic.get());
	        List<Course> listCourse=courseRepository.findAll();
		    model.addAttribute("listCourse", listCourse);
	     }
	    return "topic-update";
	  }

	
	  @RequestMapping("/saveTopic") 
	  public ModelAndView doSaveTopic(@ModelAttribute("topic") Topic topic, BindingResult bindingResult) { 
		  ModelAndView modelAndView=new ModelAndView();
		  Topic topicExists = topicRepository.findByTopicName(topic.getTopicName());
	        if (topicExists != null) {
	        	bindingResult.rejectValue("topicName", "error.topicName","There is already Topic registered with the Topic Name provided");
	        }
	        if (bindingResult.hasErrors()) {
	    	    List<Course> listCourse=courseRepository.findAll();
	    	    modelAndView.addObject("listCourse", listCourse);
	            modelAndView.setViewName("topic-save");
	        }
	        else {
		  topicRepository.save(topic);
		  modelAndView.addObject("listTopic",topicRepository.findAll());
		  modelAndView.setViewName("topic-list"); 
	        }
	  	
	  	return modelAndView; 
	  }
	 
	  @RequestMapping("/updateTopic")
	  public ModelAndView doUpdateTopic(@ModelAttribute("topic") Topic topic, BindingResult bindingResult) {  
		  ModelAndView modelAndView=new ModelAndView();
		  topicRepository.save(topic);
	  		  modelAndView.addObject("listTopic",topicRepository.findAll());
	          modelAndView.setViewName("topic-list");
	        return modelAndView;
	  }
	  
	  @RequestMapping("/topicDelete/{id}")
	  public String doDeleteTopic(@PathVariable int id, Model model) {
		  trainerTopicService.deleteByTopicID(id);
		  topicRepository.deleteById(id); 
	    model.addAttribute("listTopic", topicRepository.findAll());
	    return "topic-list";
	  }
	  
	  @RequestMapping("/searchTopic")
	  public String searchTopic(@RequestParam(value = "searchKey") String searchKey, Model model) {
		List<Topic> listTopic = new ArrayList<Topic>();
		for(Topic topic:topicRepository.findAll()) {
			if(topic.toString().contains(searchKey)) {
				listTopic.add(topic);
			}
		}
	    model.addAttribute("listTopic", listTopic);
	    return "topic-list";
	  }
	  
	  /////////////////////TRAINER INFORMATION////////////////////////////////
		@RequestMapping("/trainer-list")
	  public String listTrainer(Model model) {
	    model.addAttribute("listTrainer", trainerRepository.findAll());
	    return "trainer-list";
	  }
	  
	  @RequestMapping("/trainer-update/{id}")
	  public String updateTrainer(@PathVariable int id, Model model) {
		Optional<Trainer> trainer = trainerRepository.findById(id);
		if (trainer.isPresent()) {
	        model.addAttribute("trainer", trainer.get());
	     }
	    return "trainer-update";
	  }
	 
	  @RequestMapping("/updateTrainer")
	  public ModelAndView doUpdateTrainer(@ModelAttribute("trainer") Trainer trainer,@RequestParam(value = "username") String username, BindingResult bindingResult) {  
		  ModelAndView modelAndView=new ModelAndView();
		  trainer.setAppUser(appUserRepository.findByUsername(username));;
		  trainerRepository.save(trainer);
	  		  modelAndView.addObject("listTrainer",trainerRepository.findAll());
	          modelAndView.setViewName("trainer-list");
	        return modelAndView;
	  }
	  
	  @RequestMapping("/searchTrainer")
	  public String searchTraner(@RequestParam(value = "searchKey") String searchKey, Model model) {
		List<Trainer> listTrainer = new ArrayList<Trainer>();
		for(Trainer trainer:trainerRepository.findAll()) {
			if(trainer.toString().contains(searchKey)) {
				listTrainer.add(trainer);
			}
		}
	    model.addAttribute("listTrainer", listTrainer);
	    return "trainer-list";
	  }
	  
	  /////////////////////////TRAINER TO TOPIC///////////////////////////////
	  
		@RequestMapping("/trainertopic-list")
	  public String listTrainerTopic(Model model) {
	    model.addAttribute("listTrainerTopic", trainerTopicRepository.findAll());
	    return "trainertopic-list";
	  }
	  @RequestMapping("/trainertopic-save")
	  public String insertTrainerTopic(Model model) {
	    model.addAttribute("trainertopic", new TrainerTopic());
	    List<Trainer> listTrainer=trainerRepository.findAll();
	    model.addAttribute("listTrainer", listTrainer);
	    List<Topic> listTopic=topicRepository.findAll();
	    model.addAttribute("listTopic", listTopic);
	    return "trainertopic-save";
	  }
	  
	
	  @RequestMapping("/saveTrainerTopic") 
	  public ModelAndView doSaveTrainerTopic(@ModelAttribute("trainertopic") TrainerTopic trainertopic, BindingResult bindingResult) { 
		  ModelAndView modelAndView=new ModelAndView();
		  Iterable <TrainerTopic> trainertopicExists = trainerTopicRepository.findByTrainerID(trainertopic.getTrainer().getTrainerID());
		  Boolean f=false;
		  for(TrainerTopic topicExist:trainertopicExists) {
			  if(topicExist.getTopic().getTopicID()==trainertopic.getTopic().getTopicID()) {
				  f=true;
			  }
		  }
	        if (f==true) {
	        	bindingResult.rejectValue("ID", "error.ID","The Trainer was assigned to that Topic !!");
	        }
	        if (bindingResult.hasErrors()) {
	    	    List<Trainer> listTrainer=trainerRepository.findAll();
	    	    modelAndView.addObject("listTrainer", listTrainer);
	    	    List<Topic> listTopic=topicRepository.findAll();
	    	    modelAndView.addObject("listTopic", listTopic);
	            modelAndView.setViewName("trainertopic-save");
	        }
	        else {
	        	
		  trainerTopicService.saveTrainerTopic(trainertopic);
		  modelAndView.addObject("listTrainerTopic",trainerTopicRepository.findAll());
		  modelAndView.setViewName("trainertopic-list"); 
	        }
	  	
	  	return modelAndView; 
	  }
	  
	  @RequestMapping("/trainertopicDelete/{id}")
	  public String doDeleteTrainerTopic(@PathVariable int id, Model model) {
		  trainerTopicRepository.deleteById(id); 
	    model.addAttribute("listTrainerTopic", trainerTopicRepository.findAll());
	    return "trainertopic-list";
	  }
	  
	  @RequestMapping("/searchTrainerTopic")
	  public String searchTrainerTopic(@RequestParam(value = "searchKey") String searchKey, Model model) {
		List<TrainerTopic> listTrainerTopic = new ArrayList<TrainerTopic>();
		for(TrainerTopic trainertopic:trainerTopicRepository.findAll()) {
			if(trainertopic.toString().contains(searchKey)) {
				listTrainerTopic.add(trainertopic);
			}
		}
	    model.addAttribute("listTrainerTopic", listTrainerTopic);
	    return "trainertopic-list";
	  }
	  
	  /////////////////////// TRAINEE TO COURSE ////////////////////////////////
		@RequestMapping("/traineecourse-list")
	  public String listTraineeCourse(Model model) {
	    model.addAttribute("listTraineeCourse", traineeCourseRepository.findAll());
	    return "traineecourse-list";
	  }
	  @RequestMapping("/traineecourse-save")
	  public String insertTraineeCourse(Model model) {
	    model.addAttribute("traineecourse", new TraineeCourse());
	    List<Trainee> listTrainee=traineeRepository.findAll();
	    model.addAttribute("listTrainee", listTrainee);
	    List<Course> listCourse=courseRepository.findAll();
	    model.addAttribute("listCourse", listCourse);
	    return "traineecourse-save";
	  }
	  
	
	  @RequestMapping("/saveTraineeCourse") 
	  public ModelAndView doSaveTraineeCourse(@ModelAttribute("traineecourse") TraineeCourse traineecourse, BindingResult bindingResult) { 
		  ModelAndView modelAndView=new ModelAndView();
		  Iterable <TraineeCourse> traineecourseExists = traineeCourseRepository.findByTraineeID(traineecourse.getTrainee().getTraineeID());
		  Boolean f=false;
		  for(TraineeCourse courseExist:traineecourseExists) {
			  if(courseExist.getCourse().getCourseID()==traineecourse.getCourse().getCourseID()) {
				  f=true;
			  }
		  }
	        if (f==true) {
	        	bindingResult.rejectValue("ID", "error.ID","The Trainee was assigned to that Course !!");
	        }
	        if (bindingResult.hasErrors()) {
	    	    List<Trainee> listTrainee=traineeRepository.findAll();
	    	    modelAndView.addObject("listTrainee", listTrainee);
	    	    List<Course> listCourse=courseRepository.findAll();
	    	    modelAndView.addObject("listCourse", listCourse);
	            modelAndView.setViewName("traineecourse-save");
	        }
	        else {
	        	
		  traineeCourseService.saveTraineeCourse(traineecourse);
		  modelAndView.addObject("listTraineeCourse",traineeCourseRepository.findAll());
		  modelAndView.setViewName("traineecourse-list"); 
	        }
	  	
	  	return modelAndView; 
	  }
	  
	  @RequestMapping("/traineecourseDelete/{id}")
	  public String doDeleteTraineeCourse(@PathVariable int id, Model model) {
		  traineeCourseRepository.deleteById(id); 
	    model.addAttribute("listTraineeCourse", traineeCourseRepository.findAll());
	    return "traineecourse-list";
	  }
	  
	  @RequestMapping("/searchTraineeCourse")
	  public String searchTraineeCourse(@RequestParam(value = "searchKey") String searchKey, Model model) {
		List<TraineeCourse> listTraineeCourse = new ArrayList<TraineeCourse>();
		for(TraineeCourse traineecourse:traineeCourseRepository.findAll()) {
			if(traineecourse.toString().contains(searchKey)) {
				listTraineeCourse.add(traineecourse);
			}
		}
	    model.addAttribute("listTraineeCourse", listTraineeCourse);
	    return "traineecourse-list";
	  }
}
