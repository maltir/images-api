package com.firepigeon.imagesApi.documents;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Data
@Document
public class BasicDocument {
    @Id
    protected String id;
    @JsonProperty("create_at")
    @NotNull
    protected Timestamp createAt;
    @JsonProperty("update_at")
    @NotNull
    protected Timestamp updateAt;
    @Version
    protected Integer version;
}
