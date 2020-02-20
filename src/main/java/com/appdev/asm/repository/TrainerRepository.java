package com.appdev.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appdev.asm.entity.*;

public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
	@Query(value ="select * from Trainer where userID=?1", nativeQuery = true)
	Trainer findByUserID(Integer id);
	
	@Query(value ="select * from Trainer t left Join AppUser a on a.userID=t.userID where a.username=?1", nativeQuery = true)
	Trainer findByUsername(String username);
}
