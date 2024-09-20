package com.Lookup.ItemMicroservice.Item;

import com.Lookup.ItemMicroservice.Item.DTO.ItemBasicInfoResponse;
import com.Lookup.ItemMicroservice.Item.DTO.ItemCreateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemController {  // TODO do pageable (not passing everything at the same time, do like the infinite scroll)
    ResponseEntity<List<ItemBasicInfoResponse>> getAllItems();

    ResponseEntity<ItemBasicInfoResponse> getItemById(String id);

    ResponseEntity<Void> deleteItemById(String id);

    ResponseEntity<ItemBasicInfoResponse> createItem(ItemCreateRequest itemBasicInfoResponse);

    ResponseEntity<Void> updateItem(String id, ItemCreateRequest itemBasicInfoResponse);

    ResponseEntity<Void> deactivateItem(String id);
}
