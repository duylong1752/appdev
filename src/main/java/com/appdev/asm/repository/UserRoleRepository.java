package com.appdev.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import com.appdev.asm.entity.*;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
	@Query(value ="select * from UserRole where userID=?1", nativeQuery = true)
	UserRole findByUserId(Integer id);
}
