package com.Lookup.ItemMicroservice.Extras;

import com.Lookup.ItemMicroservice.Extras.Entity.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryDAO extends MongoRepository<SubCategory, String> {
    Optional<SubCategory> findByName(String subCategory);
}
