package com.daniel.springcloud.msvc.items.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.springcloud.msvc.items.models.Item;
import com.daniel.springcloud.msvc.items.services.ItemService;

@RestController
public class ItemController {

    private final ItemService service;

    public ItemController(@Qualifier("itemServiceWebClient") ItemService service){
        this.service = service;
    }

    @GetMapping
    public List<Item> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        Optional<Item> optionalItem = service.findById(id);
        if(optionalItem.isPresent()){
            return ResponseEntity.ok(optionalItem.get());
        }
        return ResponseEntity.status(404).body(Collections.singletonMap("message", "Product not found in mscv-product"));
    }
}
