package com.Lookup.ItemMicroservice.Item.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "Item")
@Builder
@ToString
public class Item  {
    @Id
    @Field(name = "_id")
    private ObjectId id;

    @Field(name = "brand")
    private String brand;

    @Field(name = "code")
    private String code;

    @Field(name = "name")
    private String name;

    @Field(name = "gender")
    private String gender;

    @Field(name = "category")
    private String category;

    @Field(name = "sub_category")
    private String subCategory;

    @Field(name = "size")
    private List<String> sizes;

    @Field(name = "colours")  // TODO: save this as an array in the database
    private List<String> colours;

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
