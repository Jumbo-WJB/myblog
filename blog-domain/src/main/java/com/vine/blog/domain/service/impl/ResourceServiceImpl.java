package com.vine.blog.domain.service.impl;


import com.vine.blog.domain.common.Catalog;
import com.vine.blog.domain.entity.catalog.Category;
import com.vine.blog.domain.entity.post.Content;
import com.vine.blog.domain.entity.post.Post;
import com.vine.blog.domain.repository.PartitionRepository;
import com.vine.blog.domain.service.ResourceService;
import com.vine.blog.domain.util.JsonUtils;
import com.vine.blog.domain.entity.catalog.Partition;
import com.vine.blog.domain.repository.CategoryRepository;
import com.vine.blog.domain.repository.ContentRepository;
import com.vine.blog.domain.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service
public class ResourceServiceImpl implements ResourceService {

    private static final Logger log = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PartitionRepository partitionRepository;

    @Override
    public Post savePost(Post data) {
        if (data.getId() != null) {
            //content will be re-created ,and the post is re-related content
            contentRepository.save(data.getContent());

            //copy data to post include version:updatedAt
            data.setCategory(categoryRepository.findOne(data.getCategory().getId()));
            Post post = postRepository.findOne(data.getId());
            data.setCreatedAt(post.getCreatedAt());
            data.setUpdatedAt(post.getUpdatedAt());
            BeanUtils.copyProperties(data, post);

            //set bean
            post.setContent(data.getContent());
            post.setCategory(data.getCategory());
            post.setTags(data.getTags());
            return postRepository.save(post);
        }
        contentRepository.save(data.getContent());
        data.setCategory(categoryRepository.findOne(data.getCategory().getId()));
        return postRepository.save(data);
    }


    @Override
    public Page<Post> findPostByStatus(Post.PostStatus status, Pageable pageable) {
        Page<Post> posts = postRepository.findByStatus(status, pageable);
        return posts;
    }


    @Override
    public Content findContent(long l) {
        return contentRepository.findOne(l);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Partition> findAllPartitions() {
        return partitionRepository.findAll();
    }

    @Override
    public Partition savePartition(Partition data) {
        if (data.getId() != null) {
            Partition partition = partitionRepository.findOne(data.getId());
            BeanUtils.copyProperties(data, partition);
            return partitionRepository.save(partition);
        }
        return partitionRepository.save(data);
    }

    @Override
    public Category saveCategory(Category data) throws Exception {
        try {
            if (data != null && data.getId() != null) {
                Category category = categoryRepository.findOne(data.getId());
                BeanUtils.copyProperties(data, category);
                category.setPartition(partitionRepository.findOne(data.getPartition().getId()));
                return categoryRepository.save(category);
            }
            data.setPartition(partitionRepository.findOne(data.getPartition().getId()));
            return categoryRepository.save(data);
        } catch (Exception e) {
            log.error("save category failed : {},exception : {}", JsonUtils.toString(data), e);
            throw e;
        }
    }

    @Override
    public List<Catalog> getCatalogs() {
        List<Category> categories = findAllCategories();
        List<Partition> partitions = findAllPartitions();
        return getCatalogs(categories, partitions);

    }

    @Override
    public Boolean deletePartition(long id) {
        try {
            partitionRepository.delete(id);
        } catch (Exception e) {
            log.error("delete partition failed ,params :{} ,exception :{}", id, e);
            return false;
        }
        return true;
    }

    @Override
    public Partition findPartition(long id) {
        return partitionRepository.findOne(id);
    }

    @Override
    public boolean deleteCategory(long id) {
        try {
            categoryRepository.delete(id);
        } catch (Exception e) {
            log.error("delete category failed ,params :{} ,exception :{}", id, e);
            return false;
        }
        return true;
    }

    @Override
    public Category findCategory(long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Post findPost(long id) {
        return postRepository.findOne(id);
    }

    @Override
    public void removePost(long id) {
        Post post = postRepository.findOne(id);
        postRepository.delete(id);
        contentRepository.delete(contentRepository.findOne(post.getContent().getId()));
    }

    private List<Catalog> getCatalogs(List<Category> categories, List<Partition> partitions) {
        Map<Long, Catalog> catalogs = new LinkedHashMap<>();
        Catalog catalog = null;
        for (Partition partition : partitions) {
            if (!catalogs.containsKey(partition.getId())) {
                catalog = new Catalog();
                catalog.setPartition(partition);
                catalogs.put(partition.getId(), catalog);
            }
        }

        for (Category category : categories) {
            Long key = category.getPartition().getId();
            catalog = catalogs.get(key);
            if (catalog == null) {
                catalog = new Catalog();
                catalog.setPartition(category.getPartition());
                catalogs.put(key, catalog);
            }
            catalogs.get(key).getCategories().add(category);
        }
        return new ArrayList<Catalog>(catalogs.values());
    }


}
