package com.example.productservice.service;

import com.example.productservice.model.Product;
import com.example.productservice.model.dao.ProductRepository;
import com.example.productservice.model.dto.ProductRequest;
import com.example.productservice.model.dto.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription()).build();
        productRepository.save(product);

        log.info("Product {} is saved", product.getName());
    }

    public List<ProductResponse> fetchAllProducts(){
        List<Product> allProducts = productRepository.findAll();

        return allProducts.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }


}
