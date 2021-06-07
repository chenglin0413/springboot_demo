package com.fet.springboot.baseapp.repo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fet.springboot.baseapp.repo.domain.Role;

/**
 * JpaRepository Object
 * leverage JpaRepository<Object,Long> , generate Query Method 
 * 
 * @author jamLin
 *
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {
	

}
