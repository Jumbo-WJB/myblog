package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.account.Account;
import com.vine.blog.domain.entity.account.EmailAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(EmailAddress email);
    Account findByPhone(String phone);
    Account findByDeviceToken(String deviceToken);
    Page<Account> findByNicknameContaining(String q, Pageable pageable);

    Account findByNickname(String requester);
}