package com.vine.blog.domain.service.impl;

import com.vine.blog.domain.entity.account.Account;
import com.vine.blog.domain.entity.account.EmailAddress;
import com.vine.blog.domain.repository.AccountRepository;
import com.vine.blog.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account get(EmailAddress email) {
        return accountRepository.findByEmail(email);
    }
}
