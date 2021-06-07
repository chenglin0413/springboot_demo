package com.fet.springboot.baseapp.repo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="blc_role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private long roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY,cascade= CascadeType.ALL,mappedBy = "customerRoles")
	private Set<Customer> customers = new HashSet<>();
	
	public Role () {
		
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	
	public Role(String roleName, Set<Customer> customers) {
		this.roleName = roleName;
		this.customers = customers;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", customers=" + customers + "]";
	}

	

	

	
	
}
