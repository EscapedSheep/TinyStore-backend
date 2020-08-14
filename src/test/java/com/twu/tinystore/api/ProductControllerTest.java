package com.twu.tinystore.api;

import com.twu.tinystore.dto.ProductDto;
import com.twu.tinystore.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        ProductDto productDto = ProductDto.builder()
                                            .imgURL("test")
                                            .name("testName")
                                            .price(10.0)
                                            .unit("p")
                                            .build();
        productDto = productRepository.save(productDto);
    }

    @Test
    void should_get_product() throws Exception {
        mockMvc.perform(get("/product"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("testName")))
                .andExpect(status().isOk());
    }
}