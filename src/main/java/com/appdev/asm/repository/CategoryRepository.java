package com.appdev.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appdev.asm.entity.AppUser;
import com.appdev.asm.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query(value ="select * from Category a where a.categoryName=?1", nativeQuery = true)
	Category findByCategoryName(String categoryName);
}
