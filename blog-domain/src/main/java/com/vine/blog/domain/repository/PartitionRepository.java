package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.catalog.Partition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartitionRepository extends JpaRepository<Partition, Long> {
}
