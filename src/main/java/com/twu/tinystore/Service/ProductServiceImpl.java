package com.twu.tinystore.Service;

import com.twu.tinystore.domain.Product;
import com.twu.tinystore.dto.ProductDto;
import com.twu.tinystore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        productRepository.save(ProductDto.builder()
                .unit("瓶")
                .price(10)
                .name("可乐")
                .imgURL("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSILLjWyetALPAozWyikeZPwznKec2t4_3MMQ&usqp=CAU")
                .build());
        productRepository.save(ProductDto.builder()
                .unit("瓶")
                .price(5)
                .name("另一瓶可乐")
                .imgURL("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSILLjWyetALPAozWyikeZPwznKec2t4_3MMQ&usqp=CAU")
                .build());
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll().stream().map(productDto -> productDto.toProduct()).collect(Collectors.toList());
    }
}
