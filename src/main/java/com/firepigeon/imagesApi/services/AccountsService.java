package com.firepigeon.imagesApi.services;

import com.firepigeon.imagesApi.documents.Account;
import com.firepigeon.imagesApi.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountsService {

    private final AccountsRepository accountsRepository;

    @Autowired
    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public List<Account> findAll() {
        return accountsRepository.findAll();
    }

    @Transactional
    public Account create(Account account) {
        return accountsRepository.insert(account);
    }

    public Account update(Account account) {
        return accountsRepository.save(account);
    }

    @Transactional
    public void delete(String id) {
        accountsRepository.deleteById(id);
    }
}
