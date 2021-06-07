package com.fet.springboot.baseapp.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fet.springboot.baseapp.logic.service.RoleService;
import com.fet.springboot.baseapp.repo.domain.Role;
import com.fet.springboot.baseapp.repo.jpa.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}
	
}
