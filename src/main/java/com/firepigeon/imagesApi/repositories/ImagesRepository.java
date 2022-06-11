package com.firepigeon.imagesApi.repositories;

import com.firepigeon.imagesApi.documents.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends MongoRepository<Image, String> {
}
