package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.action.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
}