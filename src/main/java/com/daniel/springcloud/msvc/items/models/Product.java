package com.daniel.springcloud.msvc.items.models;

import java.time.LocalDate;

public record Product(Long id, String name, Double price, LocalDate createdAt, Integer port) {

}
