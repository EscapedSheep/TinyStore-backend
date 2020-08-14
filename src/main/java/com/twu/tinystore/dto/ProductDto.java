package com.twu.tinystore.dto;

import com.twu.tinystore.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String unit;
    private double price;
    private String imgURL;

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .imgURL(imgURL)
                .price(price)
                .unit(unit)
                .id(id)
                .build();
    }
}
