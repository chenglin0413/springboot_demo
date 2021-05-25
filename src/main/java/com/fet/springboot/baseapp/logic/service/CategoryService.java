package com.fet.springboot.baseapp.logic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fet.springboot.baseapp.repo.domain.Category;

public interface CategoryService {
	Page<Category> findByNameContaining(String name, Pageable pageable);
	List<Category> findByNameContaining(String name, Sort sort);
	Page<Category> findAll(Pageable pageable);
	List<Category> findAll(Sort sort);
	Category save(Category category);
	Optional<Category> findById(Long id);
}
