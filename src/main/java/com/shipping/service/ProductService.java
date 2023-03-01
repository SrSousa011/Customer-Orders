package com.shipping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shipping.entity.Product;
import com.shipping.repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
}
