package com.Lookup.ItemMicroservice.Brand;

import com.Lookup.ItemMicroservice.Brand.Entity.Brand;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BrandDAO extends MongoRepository<Brand, ObjectId> {
    Optional<Brand> findByName(String name);
}
