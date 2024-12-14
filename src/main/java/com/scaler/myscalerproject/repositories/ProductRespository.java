package com.scaler.myscalerproject.repositories;

import com.scaler.myscalerproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {
    List<Product> findByTitleContaining(String word);

    long deleteByTitle(String title);

}
