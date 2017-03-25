package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.filter.Filter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilterRepository extends JpaRepository<Filter, Long> {

    public List<Filter> findByActive(Boolean active);
}
