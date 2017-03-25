package com.vine.blog.domain.repository;
import com.vine.blog.domain.entity.catalog.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
