package com.everest8848.Everest8848.repository;

import com.everest8848.Everest8848.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Page<Product>findAll(Pageable pageable);

   @Query("SELECT e FROM Product e WHERE e.name like ?1% ")
   Page<Product> getProductsBysearchvalue( String searchValue, Pageable pageable);


}
