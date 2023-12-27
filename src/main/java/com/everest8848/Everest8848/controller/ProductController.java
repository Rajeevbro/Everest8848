package com.everest8848.Everest8848.controller;

import com.everest8848.Everest8848.entity.Product;
import com.everest8848.Everest8848.exceptions.ProductNotFoundException;
import com.everest8848.Everest8848.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product){
        return productService.addProduct(product);

    }

//    @GetMapping
//    public List<Product> getAllProducts(){
//        return productService.getAllProducts(page, limit);
//
//    }
    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.findProductById(id);

    }

    @GetMapping("/search")
    public Page<Product> findProducts(@RequestParam() String searchvalue,@RequestParam(defaultValue = "0")Integer page,
                                           @RequestParam(defaultValue = "10") Integer limit) {

        return productService.findProducts(searchvalue,limit,page);
    }



}
