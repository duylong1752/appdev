package com.appdev.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appdev.asm.entity.*;

public interface TraineeRepository extends JpaRepository<Trainee, Integer>{

}
