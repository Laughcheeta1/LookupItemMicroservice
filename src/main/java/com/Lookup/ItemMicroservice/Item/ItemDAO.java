package com.Lookup.ItemMicroservice.Item;

import com.Lookup.ItemMicroservice.Item.Entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDAO extends MongoRepository<Item, String> {
    List<Item> findAllByInProductionTrue();
}
