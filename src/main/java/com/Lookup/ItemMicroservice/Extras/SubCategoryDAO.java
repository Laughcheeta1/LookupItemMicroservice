package com.Lookup.ItemMicroservice.Extras;

import com.Lookup.ItemMicroservice.Extras.Entity.SubCategory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubCategoryDAO extends MongoRepository<SubCategory, String> {
    Optional<SubCategory> findByName(String subCategory);
}
