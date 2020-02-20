package com.appdev.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appdev.asm.entity.*;

@Repository
public interface RoleDetailRepository extends JpaRepository<RoleDetail, Integer>{
	@Query(value ="select * from RoleDetail a where a.roleName=?1", nativeQuery = true)
	RoleDetail findByRoleName(String roleName);
}
