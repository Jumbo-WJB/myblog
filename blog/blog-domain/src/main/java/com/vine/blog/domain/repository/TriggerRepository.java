package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.trigger.Trigger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriggerRepository extends JpaRepository<Trigger, Long> {
}