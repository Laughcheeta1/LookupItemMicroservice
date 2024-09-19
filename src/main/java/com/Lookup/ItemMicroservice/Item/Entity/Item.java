package com.Lookup.ItemMicroservice.Item.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Entity
@Data
@Document(collection = "Item")
public class Item  {
    @Id
    @Field(name = "id")
    private ObjectId id;

    @Field(name = "brand")
    private ObjectId brand;

    @Field(name = "code")
    private String code;

    @Field(name = "name")
    private String name;

    @Field(name = "gender")
    private ObjectId gender;

    @Field(name = "category")
    private ObjectId category;

    @Field(name = "sub_category")
    private ObjectId subCategory;

    @Field(name = "size")
    private ObjectId size;

    @ElementCollection
    @Field(name = "colours")  // TODO: save this as an array in the database
    private List<ObjectId> colours;

    @Field(name = "price")
    private double price;

    @Field(name = "image_url")
    private String imageUrl;

    @Field(name = "in_production")
    private boolean inProduction;

    @Field(name = "showed_info")
    private Info showedInfo;

    @Field(name = "opened_info")
    private Info openedInfo;
}
