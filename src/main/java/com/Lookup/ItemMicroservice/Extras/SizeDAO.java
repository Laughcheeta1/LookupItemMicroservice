package com.Lookup.ItemMicroservice.Extras;

import com.Lookup.ItemMicroservice.Extras.Entity.Size;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SizeDAO extends MongoRepository<Size, String> {
    List<Size> findAllByNameIn(List<String> name);
    List<Size> findAllByIdIn(List<String> id);
}
