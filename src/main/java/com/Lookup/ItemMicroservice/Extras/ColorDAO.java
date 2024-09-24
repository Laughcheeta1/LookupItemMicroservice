package com.Lookup.ItemMicroservice.Extras;

import com.Lookup.ItemMicroservice.Extras.Entity.Color;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ColorDAO extends MongoRepository<Color, String> {
    Optional<Color> findAllByNameIn(List<String> name);
}
