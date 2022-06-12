package com.firepigeon.imagesApi.repositories;

import com.firepigeon.imagesApi.documents.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends MongoRepository<Account, String> {
    @Query("{username:'?0'}")
    Optional<Account> findByUsername(String username);
}
