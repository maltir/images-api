package com.firepigeon.imagesApi.documents;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Account extends BasicDocument {
    @NotNull
    @Indexed
    private String username;
    @NotNull
    private String email;
}
