package com.Lookup.ItemMicroservice.Extras;

import com.Lookup.ItemMicroservice.Extras.Entity.Color;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColorDAO extends MongoRepository<Color, String> {
    Optional<Color> findAllByNameIn(List<String> name);
}
