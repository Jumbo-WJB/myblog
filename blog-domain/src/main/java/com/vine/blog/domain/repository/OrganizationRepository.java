package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}