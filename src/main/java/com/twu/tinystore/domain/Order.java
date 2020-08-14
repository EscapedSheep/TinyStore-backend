package com.twu.tinystore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private List<Product> orderList;

    public Order() {
        this.orderList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        orderList.add(product);
    }
}
