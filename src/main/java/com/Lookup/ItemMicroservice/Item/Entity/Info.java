package com.Lookup.ItemMicroservice.Item.Entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This is the class that holds info like how many times the item was viewed on the main page, search page, and brand page.
 * Or how many times has the item has been opened.
 */
@EqualsAndHashCode
@Builder
public class Info {
    // By default, all fields are set to 0
    public Info() {
        mainPage = 0;
        search = 0;
        brandPage = 0;
    }

    @Field(name = "main_page")
    private int mainPage;

    @Field(name = "search")
    private int search;

    @Field(name = "brand_page")
    private int brandPage;
}