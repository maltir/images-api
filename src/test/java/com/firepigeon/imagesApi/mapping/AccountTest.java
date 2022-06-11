package com.firepigeon.imagesApi.mapping;

import com.firepigeon.imagesApi.documents.Account;
import com.firepigeon.imagesApi.dto.AccountCreateDto;
import com.firepigeon.imagesApi.dto.AccountUpdateDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void checkAccountMapping() {
        AccountCreateDto accountCreateDto = new AccountCreateDto();
        accountCreateDto.setEmail("testEmail");
        accountCreateDto.setUsername("testUsername");

        Account account = modelMapper.map(accountCreateDto, Account.class);
        assertEquals(accountCreateDto.getUsername(), account.getUsername());
        assertEquals(accountCreateDto.getEmail(), account.getEmail());
        assertEquals(accountCreateDto.getCreateAt(), account.getCreateAt());
        assertEquals(accountCreateDto.getUpdateAt(), account.getUpdateAt());

        AccountUpdateDto accountUpdateDto = new AccountUpdateDto();
        accountUpdateDto.setEmail("testEmailUpdate");
        accountUpdateDto.setUsername("testUsernameUpdate");

        modelMapper.map(accountUpdateDto, account);
        assertEquals(accountUpdateDto.getUsername(), account.getUsername());
        assertEquals(accountUpdateDto.getEmail(), account.getEmail());
        assertEquals(accountCreateDto.getCreateAt(), account.getCreateAt());
        assertEquals(accountUpdateDto.getUpdateAt(), account.getUpdateAt());
    }
}
