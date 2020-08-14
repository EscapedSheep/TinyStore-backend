package com.twu.tinystore.api;

import com.twu.tinystore.Service.OrderService;
import com.twu.tinystore.domain.Product;
import com.twu.tinystore.dto.ProductDto;
import com.twu.tinystore.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRepository productRepository;

    private ProductDto productDto;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        productDto = ProductDto.builder()
                .imgURL("test")
                .name("testName")
                .price(10.0)
                .unit("p")
                .build();
        productDto = productRepository.save(productDto);
        orderService.addToOrder(productDto.toProduct());
    }

    @Test
    void should_delete_Order() throws Exception {
        assertEquals(1, orderService.getOrder().size());
        mockMvc.perform(delete("/order/" + productDto.getId())).andExpect(status().isOk());
        assertEquals(0, orderService.getOrder().size());
    }
}