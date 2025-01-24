package com.daniel.springcloud.msvc.items.models;

public record Item(Product product, Integer quantity) {
    public Double getTotal(){
        return product.price() * quantity;
    }
}
