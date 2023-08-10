package com.vanndeth.phoneshopmgt.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.vanndeth.phoneshopmgt.entity.Brand;
import com.vanndeth.phoneshopmgt.exception.ResourceNotFoundException;
import com.vanndeth.phoneshopmgt.repository.BrandRepository;
import com.vanndeth.phoneshopmgt.service.implement.BrandServiceImplement;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTests {
	
	@Mock
	private BrandRepository brandRepository;
	
	private BrandService brandService;
	
	@BeforeEach
	public void setUp() {
		brandService = new BrandServiceImplement(brandRepository);
	}
	
/*
	@Test
	public void testCreate() {
		
		// Given
		Brand brand = new Brand();
		brand.setId(1);
		brand.setName("Apple");
		
		// When
		when(brandRepository.save(any(Brand.class))).thenReturn(brand);
		Brand brandReturn = brandService.create(brand);
		
		// Then
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());
	}
*/
	
	@Test
	public void testCreate() {
		//Given
		Brand brand = new Brand();
		brand.setName("Apple");
		//When
		brandService.create(brand);
		//Then
		verify(brandRepository, times(1)).save(brand);
//		verify(brandRepository, times(1)).delete(brand); // Error because wrong method *delete
	}

	@Test
	public void testGetByIdSucceeded() {
		//Given
		Brand brand = new Brand();
		brand.setId(1L);
		brand.setName("Apple");
		//When
		when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));
		Brand brandReturn = brandService.getById(1L);
		//Then
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());
	}
	
	@Test
	public void testGetByIdFailed() {
		//Given
		
		//When
		when(brandRepository.findById(2L)).thenReturn(Optional.empty());
		
		//Then
		assertThatThrownBy(() -> brandService.getById(2L))
			.isInstanceOf(ResourceNotFoundException.class)
//			.hasMessageContaining("id");
//			.hasMessage(String.format("%s with id = %d not found", "Brand", 2));
			.hasMessage("Brand with id = 2 not found");
	}
}
