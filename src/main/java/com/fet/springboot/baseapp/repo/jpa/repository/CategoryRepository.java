package com.fet.springboot.baseapp.repo.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fet.springboot.baseapp.repo.domain.Category;

/**
 * JpaRepository Object
 * leverage JpaRepository<Object,Long> , generate Query Method 
 * 
 * @author jamLin
 *
 */
@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {
	/**
	 * Query data from DB , and return Pageable<Category> Object .
	 * @param name
	 * @param pageable
	 * @return Page<Category>
	 */
	Page<Category> findByNameContaining(String name, Pageable pageable);
	
	/**
	 * Query data from DB , and return List<Category> Object .
	 * @param name
	 * @param sort
	 * @return List<Category>
	 */
	List<Category> findByNameContaining(String name, Sort sort);
	List<Category> findAll(Sort sort);
	Page<Category> findAll(Pageable pageable);
	Category save(Category category);
	Optional<Category>  findById(Long id);
}
