package com.Lookup.ItemMicroservice.Item;

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
public class ItemControllerImplementation implements ItemController{
    private final ItemDAO itemDAO;
    private final CategoryDAO categoryDAO;
    private final SubCategoryDAO subCategoryDAO;
    private final ColorDAO colorDAO;
    private final GenderDAO genderDAO;
    private final SizeDAO sizeDAO;

    @Autowired
    public ItemControllerImplementation(ItemDAO itemDAO, CategoryDAO categoryDAO, SubCategoryDAO subCategoryDAO, ColorDAO colorDAO, GenderDAO genderDAO, SizeDAO sizeDAO) {
        this.itemDAO = itemDAO;
        this.categoryDAO = categoryDAO;
        this.subCategoryDAO = subCategoryDAO;
        this.colorDAO = colorDAO;
        this.genderDAO = genderDAO;
        this.sizeDAO = sizeDAO;
    }

    @Override
    public List<ItemBasicInfoResponse> getAllItems() {
        // TODO: Make this in a mongoQuery instead of the controller
        return itemDAO.findAllByInProductionTrue().stream().map(
                this::getItemBasicInfoResponse
        ).toList();
    }

    @Override
    public ItemBasicInfoResponse getItemById(String id) {
        Item item = itemDAO.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        return getItemBasicInfoResponse(item);
    }

    @Override
    public void deleteItemById(String id) {
        itemDAO.deleteById(id);
    }

    @Override
    public ItemBasicInfoResponse createItem(ItemCreateRequest itemBasicInfoResponse) {
        Item item = Item.builder()
                .brand(itemBasicInfoResponse.getBrand())
                .code(itemBasicInfoResponse.getCode())
                .name(itemBasicInfoResponse.getName())
                .gender(
                        genderDAO.findByName(itemBasicInfoResponse.getGender()).orElseThrow(() -> new RuntimeException("Gender not found")).getId()
                )
                .category(
                        categoryDAO.findByName(itemBasicInfoResponse.getCategory()).orElseThrow(() -> new RuntimeException("Category not found")).getId()
                )
                .subCategory(
                        subCategoryDAO.findByName(itemBasicInfoResponse.getSubCategory()).orElseThrow(() -> new RuntimeException("SubCategory not found")).getId()
                )
                .sizes(
                        sizeDAO.findAllByNameIn(itemBasicInfoResponse.getSizes()).stream().map(Size::getId).toList()
                )
                .colours(
                        colorDAO.findAllByNameIn(itemBasicInfoResponse.getColours()).stream().map(Color::getId).toList()
                )
                .price(itemBasicInfoResponse.getPrice())
                .imageUrl(itemBasicInfoResponse.getImageUrl())
                .inProduction(true)
                .build();

        itemDAO.save(item);

        return getItemBasicInfoResponse(item);
    }

    @Override
    public void updateItem(String id, ItemCreateRequest itemBasicInfoResponse) {
        // TODO: create this
    }

    @Override
    public void deactivateItem(String id) {
        Item item = itemDAO.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setInProduction(false);
        itemDAO.save(item);
    }

    private ItemBasicInfoResponse getItemBasicInfoResponse(Item item) {
        return ItemBasicInfoResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .gender(
                        genderDAO.findById(item.getGender()).orElseThrow(() -> new RuntimeException("Gender not found")).getName()
                )
                .category(
                        categoryDAO.findById(item.getCategory()).orElseThrow(() -> new RuntimeException("Category not found")).getName()
                )
                .subCategory(
                        subCategoryDAO.findById(item.getSubCategory()).orElseThrow(() -> new RuntimeException("SubCategory not found")).getName()
                )
                .sizes(
                        sizeDAO.findAllByIdIn(item.getSizes()).stream().map(Size::getName).toList()
                )
                .colours(
                        colorDAO.findAllById(item.getColours()).stream().map(Color::getName).toList()
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
