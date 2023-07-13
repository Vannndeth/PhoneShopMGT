package com.vanndeth.phoneshopmgt.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.vanndeth.phoneshopmgt.entity.Brand;

@DataJpaTest
public class BrandRepositoryTests {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Test
	public void testFindByNameLike() {
		// Given
		Brand brand = new Brand();
		brand.setName("Apple");
		
		Brand brand2 = new Brand();
		brand2.setName("Samsung");
		
		brandRepository.save(brand);
		brandRepository.save(brand2);
		// When
		List<Brand> brands = brandRepository.findByNameLike("%A%");
			
		// Then
		assertEquals(1, brands.size());
		assertEquals(1, brands.get(0).getId());
		assertEquals("Apple", brands.get(0).getName());
		
	}
	
}
