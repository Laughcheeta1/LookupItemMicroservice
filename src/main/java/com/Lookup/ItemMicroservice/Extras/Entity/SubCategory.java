package com.Lookup.ItemMicroservice.Extras.Entity;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "SubCategory")
@ToString
public class SubCategory {
    @Id
    @Field("_id")
    private ObjectId id;

    @Field("name")
    private String name;
}
