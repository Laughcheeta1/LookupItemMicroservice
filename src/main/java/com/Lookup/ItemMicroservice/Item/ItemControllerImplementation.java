package com.Lookup.ItemMicroservice.Item;

import com.Lookup.ItemMicroservice.Item.DTO.ItemBasicInfoResponse;
import com.Lookup.ItemMicroservice.Item.DTO.ItemCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemControllerImplementation implements ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemControllerImplementation(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ItemBasicInfoResponse>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @Override
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ItemBasicInfoResponse> getItemById(@PathVariable("id") String id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable("id") String id) {
        itemService.deleteItemById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @PostMapping(produces = "application/json")
    public ResponseEntity<ItemBasicInfoResponse> createItem(@RequestBody ItemCreateRequest itemBasicInfoResponse) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(itemBasicInfoResponse));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateItem(@PathVariable("id") String id, @RequestBody ItemCreateRequest itemBasicInfoResponse) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @Override
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateItem(@PathVariable("id") String id) {
        return null;
    }
}
