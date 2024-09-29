package com.Lookup.ItemMicroservice.Item.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

/**
 * This is meant to give only the info a normal user would need to know about an Item
 */
@Builder
public class ItemBasicInfoResponse {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private double price;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("category")
    private String category;
    @JsonProperty("subCategory")
    private String subCategory;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("sizes")
    private List<String> sizes;
    @JsonProperty("colours")
    private List<String> colours;
    @JsonProperty("imageUrl")
    private String imageUrl;
}
