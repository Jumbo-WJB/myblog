package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.attachment.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}