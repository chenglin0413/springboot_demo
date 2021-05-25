package com.fet.springboot.baseapp.logic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fet.springboot.baseapp.logic.service.CategoryService;
import com.fet.springboot.baseapp.repo.domain.Category;
import com.fet.springboot.baseapp.repo.jpa.repository.CategoryRepository;

@Service
public  class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByNameContaining(name, pageable);
	}

	@Override
	public List<Category> findByNameContaining(String name, Sort sort) {
		return categoryRepository.findByNameContaining(name, sort);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}
	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}
	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	@Override
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}
	
}
