package com.appdev.asm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.appdev.asm.entity.*;
import com.appdev.asm.repository.AppUserResult;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	
	@Query("select NEW com.appdev.asm.repository.AppUserResult(a.userID, a.username, a.password) from AppUser a "
			+ "left Join UserRole ur on ur.appUser.userID = a.userID "
			+ "where  ur.roleDetail.roleID = 3")
	List<AppUserResult> findTrainer();

	@Query("select NEW com.appdev.asm.repository.AppUserResult(a.userID, a.username, a.password) from AppUser a "
			+ "left Join UserRole ur on ur.appUser.userID = a.userID "
			+ "where  ur.roleDetail.roleID = 2")
	List<AppUserResult> findTrainingStaff();
	
	@Query(value ="select * from AppUser a where a.username=?1", nativeQuery = true)
	AppUser findByUsername(String username);
}
