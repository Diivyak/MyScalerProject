package com.scaler.myscalerproject.repositories;

import com.scaler.myscalerproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {
    List<Product> findByTitleContaining(String word);

    long deleteByTitle(String title);

    long deleteByTitleIgnoreCase(String title);

    List<Product> findByTitleAndDescription(String title, String description);


    Optional<Product> findById(Long id);

    Product save(Product product);
}
