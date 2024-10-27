package com.Lookup.ItemMicroservice.Item;

import com.Lookup.ItemMicroservice.Brand.BrandDAO;
import com.Lookup.ItemMicroservice.Extras.*;
import com.Lookup.ItemMicroservice.Extras.Entity.Color;
import com.Lookup.ItemMicroservice.Extras.Entity.Size;
import com.Lookup.ItemMicroservice.Item.DTO.ItemBasicInfoResponse;
import com.Lookup.ItemMicroservice.Item.DTO.ItemCreateRequest;
import com.Lookup.ItemMicroservice.Item.Entity.Item;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImplementation implements ItemService{
    private final ItemDAO itemDAO;
    private final CategoryDAO categoryDAO;
    private final SubCategoryDAO subCategoryDAO;
    private final ColorDAO colorDAO;
    private final GenderDAO genderDAO;
    private final SizeDAO sizeDAO;
    private final BrandDAO brandDAO;

    @Autowired
    public ItemServiceImplementation(ItemDAO itemDAO, CategoryDAO categoryDAO, SubCategoryDAO subCategoryDAO, ColorDAO colorDAO, GenderDAO genderDAO, SizeDAO sizeDAO, BrandDAO brandDAO) {
        this.itemDAO = itemDAO;
        this.categoryDAO = categoryDAO;
        this.subCategoryDAO = subCategoryDAO;
        this.colorDAO = colorDAO;
        this.genderDAO = genderDAO;
        this.sizeDAO = sizeDAO;
        this.brandDAO = brandDAO;
    }

    @Override
    public List<ItemBasicInfoResponse> getAllItems() {
        return itemDAO.findAllByInProductionTrue().stream().map(
                this::getItemBasicInfoResponse
        ).toList();
    }

    @Override
    public ItemBasicInfoResponse getItemById(String id) {
        Item item = itemDAO.findById(new ObjectId(id)).orElseThrow(() -> new RuntimeException("Item not found"));
        return getItemBasicInfoResponse(item);
    }

    @Override
    public void deleteItemById(String id) {
        itemDAO.deleteById(new ObjectId(id));
    }

    @Override
    public ItemBasicInfoResponse createItem(ItemCreateRequest itemCreateRequest) {
        Item item = Item.builder()
                .brand(
                        brandDAO.findByName(itemCreateRequest.getBrand()).orElseThrow(() -> new RuntimeException("Brand not found")).getId().toString()
                )
                .code(itemCreateRequest.getCode())
                .name(itemCreateRequest.getName())
                .gender(
                        genderDAO.findByName(itemCreateRequest.getGender()).orElseThrow(() -> new RuntimeException("Gender not found")).getId().toString()
                )
                .category(
                        categoryDAO.findByName(itemCreateRequest.getCategory()).orElseThrow(() -> new RuntimeException("Category not found")).getId().toString()
                )
                .subCategory(
                        subCategoryDAO.findByName(itemCreateRequest.getSubCategory()).orElseThrow(() -> new RuntimeException("SubCategory not found")).getId().toString()
                )
                .sizes(
                        sizeDAO.findAllByNameIn(itemCreateRequest.getSizes()).stream().map(Size::getName).toList()
                )
                .colors(
                        colorDAO.findAllByNameIn(itemCreateRequest.getColors()).stream().map(Color::getName).toList()
                )
                .price(itemCreateRequest.getPrice())
                .imageUrl(itemCreateRequest.getImageUrl())
                .inProduction(true)
                .build();

        itemDAO.save(item);

        return getItemBasicInfoResponse(item);
    }

    @Override
    public void updateItem(String id, ItemCreateRequest itemCreateRequest) {
        Item itemDb = itemDAO.findById(new ObjectId(id)).orElseThrow(() -> new RuntimeException("Item not found"));

        if (itemCreateRequest.getName() != null) {
            itemDb.setName(itemCreateRequest.getName());
        }
        if (itemCreateRequest.getPrice() != 0) {
            itemDb.setPrice(itemCreateRequest.getPrice());
        }
        if (itemCreateRequest.getBrand() != null) {
            itemDb.setBrand(
                    brandDAO.findByName(itemCreateRequest.getBrand()).orElseThrow(() -> new RuntimeException("Brand not found")).getId().toString()
            );
        }
        if (itemCreateRequest.getGender() != null) {
            itemDb.setGender(
                    genderDAO.findByName(itemCreateRequest.getGender()).orElseThrow(() -> new RuntimeException("Gender not found")).getId().toString()
            );
        }
        if (itemCreateRequest.getCategory() != null) {
            itemDb.setCategory(
                    categoryDAO.findByName(itemCreateRequest.getCategory()).orElseThrow(() -> new RuntimeException("Category not found")).getId().toString()
            );
        }
        if (itemCreateRequest.getSubCategory() != null) {
            itemDb.setSubCategory(
                    subCategoryDAO.findByName(itemCreateRequest.getSubCategory()).orElseThrow(() -> new RuntimeException("SubCategory")).getId().toString()
            );
        }
        if (itemCreateRequest.getSizes() != null) {
            itemDb.setSizes(
                    sizeDAO.findAllByNameIn(itemCreateRequest.getSizes()).stream().map(Size::getName).toList()
            );
        }
        if (itemCreateRequest.getColors() != null) {
            itemDb.setColors(
                    colorDAO.findAllByNameIn(itemCreateRequest.getColors()).stream().map(Color::getName).toList()
            );
        }
        if (itemCreateRequest.getCode() != null) {
            itemDb.setCode(itemCreateRequest.getCode());
        }
        if (itemCreateRequest.getImageUrl() != null) {
            itemDb.setImageUrl(itemCreateRequest.getImageUrl());
        }

        itemDAO.save(itemDb);
    }

    @Override
    public void deactivateItem(String id) {
        Item item = itemDAO.findById(new ObjectId(id)).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setInProduction(false);
        itemDAO.save(item);
    }

    private ItemBasicInfoResponse getItemBasicInfoResponse(Item item) {
        return ItemBasicInfoResponse.builder()
                .id(item.getId().toString())
                .name(item.getName())
                .price(item.getPrice())
                .brand(
                        item.getBrand()
                )
                .gender(
                        genderDAO.findById(new ObjectId(item.getGender()))
                                .orElseThrow(() -> new RuntimeException("Gender not found")).getName()
                )
                .category(
                        categoryDAO.findById(new ObjectId(item.getCategory()))
                                .orElseThrow(() -> new RuntimeException("Category not found")).getName()
                )
                .subCategory(
                        subCategoryDAO.findById(new ObjectId(item.getSubCategory()))
                                .orElseThrow(() -> new RuntimeException("SubCategory not found")).getName()
                )
                .sizes(
                        sizeDAO.findAllByIdIn(
                                item.getSizes().stream().map(ObjectId::new).toList()
                        ).stream().map(Size::getName).toList()
                )
                .colours(
                        colorDAO.findAllById(
                                item.getColors().stream().map(ObjectId::new).toList()
                        ).stream().map(Color::getName).toList()
                )
                .price(
                        item.getPrice()
                )
                .imageUrl(
                        item.getImageUrl()
                )
                .build();
    }
}
