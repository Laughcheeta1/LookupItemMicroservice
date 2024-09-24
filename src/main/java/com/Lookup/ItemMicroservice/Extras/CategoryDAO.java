package com.Lookup.ItemMicroservice.Extras;

import com.Lookup.ItemMicroservice.Extras.Entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryDAO extends MongoRepository<Category, String> {
    Optional<Category> findByName(String name);
}
