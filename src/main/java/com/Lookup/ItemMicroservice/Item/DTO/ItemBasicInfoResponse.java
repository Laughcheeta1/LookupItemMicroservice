package com.Lookup.ItemMicroservice.Item.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

/**
 * This is meant to give only the info a normal user would need to know about an Item
 */
@Builder
public class ItemBasicInfoResponse {
    private String id;
    private String name;
    private double price;
    private String gender;
    private String category;
    private String subCategory;
    private String brand;
    private List<String> sizes;
    private List<String> colours;
    private String code;
    private String imageUrl;
}
