package com.firepigeon.imagesApi.documents;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class BasicDocument {
    @Id
    protected String id;
    @JsonProperty("create_at")
    @NotNull
    protected Date createAt;
    @JsonProperty("update_at")
    @NotNull
    protected Date updateAt;
    @Version
    protected Integer version;
}
