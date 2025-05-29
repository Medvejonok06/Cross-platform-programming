package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
    List<Category> findAllByOrderByNameAsc();
    List<Category> findAllByOrderByNameDesc();
    List<Category> findByNameContainingIgnoreCase(String keyword);
}






