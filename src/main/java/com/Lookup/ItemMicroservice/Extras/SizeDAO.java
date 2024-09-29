package com.Lookup.ItemMicroservice.Extras;

import com.Lookup.ItemMicroservice.Extras.Entity.Size;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeDAO extends MongoRepository<Size, ObjectId> {
    List<Size> findAllByNameIn(List<String> name);
    List<Size> findAllByIdIn(List<String> id);
}
