package com.vine.blog.domain.service.impl;


import com.vine.blog.domain.repository.OrganizationRepository;
import com.vine.blog.domain.entity.account.Account;
import com.vine.blog.domain.entity.filter.Filter;
import com.vine.blog.domain.entity.organization.Organization;
import com.vine.blog.domain.repository.AccountRepository;
import com.vine.blog.domain.repository.ConditionRepository;
import com.vine.blog.domain.repository.FilterRepository;
import com.vine.blog.domain.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private FilterRepository filterRepository;

    @Autowired
    private ConditionRepository conditionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public void saveFilter(Filter data) {
        if(data.getId() == null || data.getId() == 0){
            data.setAll(conditionRepository.save(data.getAll()));
            data.setAny(conditionRepository.save(data.getAny()));
            filterRepository.save(data);
        }else{
            Filter filter = filterRepository.findOne(data.getId());
            data.setAll(conditionRepository.save(data.getAll()));
            data.setAny(conditionRepository.save(data.getAny()));
            filter.setActive(data.isActive());
            filter.setAll(data.getAll());
            filter.setAny(data.getAny());
            filter.setOwner(data.getOwner());
            filter.setTitle(data.getTitle());
            filterRepository.save(filter);
        }
    }

    @Override
    public List<Filter> findAll() {
        return filterRepository.findAll();
    }

    @Override
    public Filter findFilter(long id) {
        return filterRepository.findOne(id);
    }

    @Override
    public List<Filter> findFilters(Iterable<Long> idList) {
        return filterRepository.findAll(idList);
    }

    @Override
    public void saveFilters(List<Filter> filters) {
        filterRepository.save(filters);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public List<Organization> findAllOrganization(){
        return organizationRepository.findAll();
    }
}
