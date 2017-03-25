package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.account.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {
    public Authorization findByProviderAndUid(Authorization.Provider provider, String uid);
}