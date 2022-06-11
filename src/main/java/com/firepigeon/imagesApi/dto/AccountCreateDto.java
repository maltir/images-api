package com.firepigeon.imagesApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
public class AccountCreateDto {
    @NotNull
    private String username;
    @NotNull
    private String email;
    @JsonIgnore
    private Timestamp createAt = Timestamp.from(Instant.now());
    @JsonIgnore
    private Timestamp updateAt = Timestamp.from(Instant.now());
}
