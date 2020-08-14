package com.twu.tinystore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private String unit;
    private double price;
    private String imgURL;
    private int id;


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            return p.id == id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}