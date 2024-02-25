package com.example.productservice.controller;

import com.example.productservice.model.dto.ProductRequest;
import com.example.productservice.model.dto.ProductResponse;
import com.example.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product")
@AllArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("insert")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping("fetchAllProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> fetchAllProducts() {
        return productService.fetchAllProducts();
    }
}
