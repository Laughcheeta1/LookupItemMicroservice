package com.Lookup.ItemMicroservice.Brand.Entity;

import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document(collection = "Brand")
public class Brand {
    @Id
    @Field("_id")
    private ObjectId id;

    @Field("name")
    private String name;
}
