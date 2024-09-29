package com.Lookup.ItemMicroservice.Item;

import com.Lookup.ItemMicroservice.Item.DTO.ItemBasicInfoResponse;
import com.Lookup.ItemMicroservice.Item.DTO.ItemCreateRequest;

import java.util.List;

public interface ItemService {
    List<ItemBasicInfoResponse> getAllItems();

    ItemBasicInfoResponse getItemById(String id);

    void deleteItemById(String id);

    ItemBasicInfoResponse createItem(ItemCreateRequest itemBasicInfoResponse);

    void updateItem(String id, ItemCreateRequest itemCreateRequest);

    void deactivateItem(String id);
}
