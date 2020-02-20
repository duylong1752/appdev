package com.appdev.asm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.appdev.asm.entity.*;
import com.appdev.asm.utils.EncrytedPasswordUtils;
import com.appdev.asm.repository.*;

@Service
public class TrainerAccountService {
	private AppUserRepository appUserRepository;
	private UserRoleRepository userRoleRepository;
	private RoleDetailRepository roleDetailRepository;
	
	@Autowired
	public TrainerAccountService(AppUserRepository appUserRepository,UserRoleRepository userRoleRepository,
			RoleDetailRepository roleDetailRepository) {
		this.appUserRepository=appUserRepository;
		this.userRoleRepository=userRoleRepository;
		this.roleDetailRepository=roleDetailRepository;
	}
	
	public AppUser saveTrainerAccount(AppUser appUser) {
		appUser.setPassword(EncrytedPasswordUtils.encrytePassword(appUser.getPassword()));
		return appUserRepository.save(appUser);
	}
	
	public UserRole saveUserRole(AppUser appUser) {
		UserRole userRole=new UserRole();
		userRole.setUser(appUser);
		userRole.setRole(roleDetailRepository.findByRoleName("trainer"));
		return userRoleRepository.save(userRole);
	}
	public void deleteUserRole(Integer id) {
		userRoleRepository.delete(userRoleRepository.findByUserId(id));
	}
}
