package com.Lookup.ItemMicroservice.Extras;

import com.Lookup.ItemMicroservice.Extras.Entity.Gender;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderDAO extends MongoRepository<Gender, String> {
    Optional<Gender> findByName(String name);
}
