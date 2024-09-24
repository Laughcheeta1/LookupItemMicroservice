package com.Lookup.ItemMicroservice.Item.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
public class ItemCreateRequest {
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
