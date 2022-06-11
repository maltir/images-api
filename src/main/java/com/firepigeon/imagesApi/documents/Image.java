package com.firepigeon.imagesApi.documents;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Image extends BasicDocument {
    private String name;
    private ObjectId owner;
}
