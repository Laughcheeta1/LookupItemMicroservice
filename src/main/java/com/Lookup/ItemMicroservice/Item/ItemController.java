package com.Lookup.ItemMicroservice.Item;

import com.Lookup.ItemMicroservice.Item.DTO.ItemBasicInfoResponse;
import com.Lookup.ItemMicroservice.Item.DTO.ItemCreateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemController {  // TODO do pageable (not passing everything at the same time, do like the infinite scroll)
    List<ItemBasicInfoResponse> getAllItems();

    ItemBasicInfoResponse getItemById(String id);

    void deleteItemById(String id);

    ItemBasicInfoResponse createItem(ItemCreateRequest itemBasicInfoResponse);

    void updateItem(String id, ItemCreateRequest itemBasicInfoResponse);

    void deactivateItem(String id);
}
