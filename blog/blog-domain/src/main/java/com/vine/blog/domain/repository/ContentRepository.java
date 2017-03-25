package com.vine.blog.domain.repository;
import com.vine.blog.domain.entity.post.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long>{

}
