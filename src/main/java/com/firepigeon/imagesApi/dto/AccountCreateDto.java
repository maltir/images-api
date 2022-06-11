package com.firepigeon.imagesApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AccountCreateDto {
    @NotNull
    private String username;
    @NotNull
    private String email;
    @JsonIgnore
    private Date createAt = new Date();
    @JsonIgnore
    private Date updateAt = new Date();
}
