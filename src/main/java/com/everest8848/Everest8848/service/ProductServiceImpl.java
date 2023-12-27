package com.everest8848.Everest8848.service;

import com.everest8848.Everest8848.entity.Product;
import com.everest8848.Everest8848.exceptions.ProductNotFoundException;
import com.everest8848.Everest8848.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {

           return productRepository.save(product);



    }

    @Override
    public Page<Product> getAllProducts(Integer page, Integer limit){
        PageRequest pageRequest= PageRequest.of(page,limit);
        return productRepository.findAll(pageRequest);


    }

    @Override
    public Product findProductById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product Not found in database");
        }
        return product.get();


    }



    @Override
    public Page<Product> findProducts(String searchvalue, Integer limit, Integer page)  {
        System.out.println(searchvalue);
        Pageable pageable= PageRequest.of(page,limit, Sort.by("id").ascending());


        return productRepository.getProductsBysearchvalue(searchvalue, pageable);
    }


}
