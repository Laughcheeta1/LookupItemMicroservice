package com.Lookup.ItemMicroservice.Item.Entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Field;

@Embeddable
@EqualsAndHashCode
public class Info {
    @Field(name = "main_page")
    private int mainPage;

    @Field(name = "search")
    private int search;

    @Field(name = "brand_page")
    private int brandPage;
}