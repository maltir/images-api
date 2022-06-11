package com.firepigeon.imagesApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
public class AccountUpdateDto {
    @Id
    private String id;
    private String username;
    private String email;
    @JsonIgnore
    private Timestamp updateAt = Timestamp.from(Instant.now());
}
