package com.Lookup.ItemMicroservice.Item.DTO;

import com.Lookup.ItemMicroservice.Item.Entity.Info;
import lombok.Builder;

import java.util.List;

@Builder
public class ItemCompleteInfoResponse {
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
    private boolean inProduction;
    private Info showedInfo;
    private Info openedInfo;
}
