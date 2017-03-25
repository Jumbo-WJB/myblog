package com.vine.blog.domain.service;


import com.vine.blog.domain.entity.organization.Organization;
import com.vine.blog.domain.entity.account.Account;
import com.vine.blog.domain.entity.filter.Filter;

import java.util.List;

public interface SettingService {

    void saveFilter(Filter filter);

    List<Filter> findAll();

    Filter findFilter(long id);

    List<Filter> findFilters(Iterable<Long> idList);

    void saveFilters(List<Filter> filters);

    List<Account> findAllAccount();

    List<Organization> findAllOrganization();
}
