package com.Lookup.ItemMicroservice.Item;

import com.Lookup.ItemMicroservice.Item.Entity.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemDAO extends MongoRepository<Item, String> {
    List<Item> findAllByInProductionTrue();
}
