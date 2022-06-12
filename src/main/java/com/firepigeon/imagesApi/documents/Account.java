package com.firepigeon.imagesApi.documents;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
public class Account extends BasicDocument {
    @NotNull
    @Indexed
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private List<String> roles = new ArrayList<>();
}
