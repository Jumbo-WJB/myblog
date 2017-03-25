package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long>{

    Page<Post> findByStatus(Post.PostStatus status, Pageable pageable);

    Post findByContentId(long contentId);
}
