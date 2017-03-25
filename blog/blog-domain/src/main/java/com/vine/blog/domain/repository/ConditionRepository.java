package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.condition.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionRepository extends JpaRepository<Condition, Long> {
}