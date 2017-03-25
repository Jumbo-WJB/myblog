package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}