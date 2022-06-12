package com.firepigeon.imagesApi.controllers;

import com.firepigeon.imagesApi.documents.Account;
import com.firepigeon.imagesApi.dto.AccountCreateDto;
import com.firepigeon.imagesApi.dto.AccountUpdateDto;
import com.firepigeon.imagesApi.services.AccountsService;
import com.firepigeon.imagesApi.util.annotation.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
    private final AccountsService accountsService;

    @Autowired
    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @GetMapping
    public List<Account> findAll() {
        return accountsService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@DTO(AccountCreateDto.class) Account account) {
        return accountsService.create(account);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Account update(@DTO(AccountUpdateDto.class) Account account) {
        return accountsService.update(account);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        accountsService.delete(id);
    }
}
