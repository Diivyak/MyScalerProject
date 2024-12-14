package com.scaler.myscalerproject;

import com.scaler.myscalerproject.repositories.ProductRespository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
class MyScalerProjectApplicationTests {

	@Autowired
	public ProductRespository productRespository;
	@Test
	void contextLoads() {
	}
	@Test
	@Transactional
	@Commit
	void testQueries() {
		productRespository.findByTitleContaining("divya");

	}

}
