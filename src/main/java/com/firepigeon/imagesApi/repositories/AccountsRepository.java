package com.firepigeon.imagesApi.repositories;

import com.firepigeon.imagesApi.documents.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends MongoRepository<Account, String> {
}
