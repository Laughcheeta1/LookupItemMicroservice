package com.Lookup.ItemMicroservice.Item.Entity;

import com.Lookup.ItemMicroservice.Brand.Entity.Brand;
import com.Lookup.ItemMicroservice.Extras.Entity.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

    @DBRef(lazy = false)
    @Field(name = "brand")
    private Brand brand;

    @Field(name = "code")
    private String code;

    @Field(name = "name")
    private String name;

    @DBRef(lazy = false)
    @Field(name = "gender")
    private Gender gender;

    @DBRef(lazy = false)
    @Field(name = "category")
    private Category category;

    @DBRef(lazy = false)
    @Field(name = "sub_category")
    private SubCategory subCategory;

    @DBRef(lazy = false)
    @Field(name = "size")
    private List<Size> sizes;

    @DBRef(lazy = false)
    @Field(name = "colours")
    private List<Color> colors;

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
