package com.scaler.myscalerproject;

import com.scaler.myscalerproject.models.Product;
import com.scaler.myscalerproject.repositories.ProductRespository;
import com.scaler.myscalerproject.repositories.projections.ProductWithIdAndTitle;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

@SpringBootTest
class MyScalerProjectApplicationTests {

	@Autowired
	public ProductRespository productRespository;
//	@Test
//	void contextLoads() {
//	}
//	@Test
//	@Transactional
//	@Commit
//	void testQueries() {
//		productRespository.findByTitleContaining("divya");
//		List<ProductWithIdAndTitle> productList = productRespository.somethingSomething(52L);
//		for(ProductWithIdAndTitle product: productList){
//			System.out.println(product.getId());
//			System.out.println(product.getTitle());
//
//		}
//		List<Product> productList1 = productRespository.someSome2();
//
//	}

}
