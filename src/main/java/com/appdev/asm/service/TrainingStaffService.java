package com.appdev.asm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.asm.entity.AppUser;
import com.appdev.asm.entity.UserRole;
import com.appdev.asm.repository.AppUserRepository;
import com.appdev.asm.repository.RoleDetailRepository;
import com.appdev.asm.repository.UserRoleRepository;
import com.appdev.asm.utils.EncrytedPasswordUtils;

@Service
public class TrainingStaffService {
	private AppUserRepository appUserRepository;
	private UserRoleRepository userRoleRepository;
	private RoleDetailRepository roleDetailRepository;
	
	@Autowired
	public TrainingStaffService(AppUserRepository appUserRepository,UserRoleRepository userRoleRepository,
			RoleDetailRepository roleDetailRepository) {
		this.appUserRepository=appUserRepository;
		this.userRoleRepository=userRoleRepository;
		this.roleDetailRepository=roleDetailRepository;
	}
	
	public AppUser saveTrainingStaff(AppUser appUser) {
		appUser.setPassword(EncrytedPasswordUtils.encrytePassword(appUser.getPassword()));
		return appUserRepository.save(appUser);
	}
	
	public UserRole saveUserRole(AppUser appUser) {
		UserRole userRole=new UserRole();
		userRole.setUser(appUser);
		userRole.setRole(roleDetailRepository.findByRoleName("trainingstaff"));
		return userRoleRepository.save(userRole);
	}
	public void deleteUserRole(Integer id) {
		userRoleRepository.delete(userRoleRepository.findByUserId(id));
	}
}
