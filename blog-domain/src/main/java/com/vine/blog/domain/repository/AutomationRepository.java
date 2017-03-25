package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.automation.Automation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomationRepository extends JpaRepository<Automation, Long> {
}