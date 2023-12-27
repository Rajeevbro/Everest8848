package com.everest8848.Everest8848.service;

import com.everest8848.Everest8848.entity.Product;
import com.everest8848.Everest8848.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    Page<Product> getAllProducts(Integer page, Integer limit);

    Product findProductById(Long id) throws ProductNotFoundException;




    Page<Product> findProducts(String searchvalue, Integer limit, Integer page);
}
