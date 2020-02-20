package com.appdev.asm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trainertopic")
public class TrainerTopic {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer ID;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainerID", nullable = false)
    private Trainer trainer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topicID", nullable = false)
    private Topic topic;
    
    
    public Integer getID() {
		    return ID;
		  }
	
	  public void setID(Integer ID) {
	    this.ID = ID;
	  }
	  
	  public Trainer getTrainer() {
		    return trainer;
		  }

		  public void setTrainer(Trainer trainer) {
		    this.trainer = trainer;
		  }
	  public Topic getTopic() {
		    return topic;
		  }

		  public void setTopic(Topic topic) {
		    this.topic = topic;
		  }
	
		  public String toString() {
			  String str=this.trainer.getAppUser().getUsername()+this.topic.getTopicName();
			  return str.toLowerCase();
		  }
}
