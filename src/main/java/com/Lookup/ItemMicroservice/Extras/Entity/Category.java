package com.Lookup.ItemMicroservice.Extras.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Category")
public class Category {
    @Id
    @Field("_id")
    private String id;

    @Field("name")
    private String name;
}
