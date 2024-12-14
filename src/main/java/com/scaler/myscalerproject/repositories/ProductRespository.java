package com.scaler.myscalerproject.repositories;

import com.scaler.myscalerproject.models.Category;
import com.scaler.myscalerproject.models.Product;
import com.scaler.myscalerproject.repositories.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {
    List<Product> findByTitleContaining(String word);

    void deleteById(Long id);

    long deleteByTitleIgnoreCase(String title);

    List<Product> findByTitleAndDescription(String title, String description);


    Optional<Product> findById(Long id);

    Product save(Product product);

    List<Product> findAll();

    List<Product> findProductsByCategory(Category category);

    @Query("select p.id as id, p.title as title from Product p where p.id = :id")
    List<ProductWithIdAndTitle> somethingSomething(@Param("id") Long id);



    @Query(value = "select * from product p where p.id = 52", nativeQuery = true)
    List<Product> someSome2();
}
