package com.vine.blog.domain.service;


import com.vine.blog.domain.common.Catalog;
import com.vine.blog.domain.entity.catalog.Category;
import com.vine.blog.domain.entity.post.Content;
import com.vine.blog.domain.entity.post.Post;
import com.vine.blog.domain.entity.catalog.Partition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ResourceService {

    Post savePost(Post post);

    Page<Post> findPostByStatus(Post.PostStatus status, Pageable pageable);

    Content findContent(long l);

    List<Category> findAllCategories();

    List<Partition> findAllPartitions();

    Partition savePartition(Partition partition);

    Category saveCategory(Category category) throws Exception;

    List<Catalog> getCatalogs();

    Boolean deletePartition(long id);

    Partition findPartition(long id);

    boolean deleteCategory(long id);

    Category findCategory(long id);

    void removePost(long id);

    Post findPost(long id);
}
