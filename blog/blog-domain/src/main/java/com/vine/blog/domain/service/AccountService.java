package com.vine.blog.domain.service;

import com.vine.blog.domain.entity.account.Account;
import com.vine.blog.domain.entity.account.EmailAddress;

/**
 * Created by wangqi on 17/2/22.
 */
public interface AccountService {
    public Account get(EmailAddress email);

}
