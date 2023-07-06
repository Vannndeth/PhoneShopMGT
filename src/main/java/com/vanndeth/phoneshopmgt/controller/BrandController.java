package com.vanndeth.phoneshopmgt.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vanndeth.phoneshopmgt.dto.BrandDTO;
import com.vanndeth.phoneshopmgt.dto.PageDTO;
import com.vanndeth.phoneshopmgt.entity.Brand;
import com.vanndeth.phoneshopmgt.mapper.BrandMapper;
import com.vanndeth.phoneshopmgt.service.BrandService;
import com.vanndeth.phoneshopmgt.service.implement.BrandServiceImplement;

@RestController
@RequestMapping("brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	
//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
		
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId) {
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBrand(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO) {
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand newBrand = brandService.update(brandId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(newBrand));
	}
	/*
	Error because com.vanndeth.phoneshopmgt.controller.BrandController#getBrands()
	to {GET [/brands]}: There is already 'brandController' bean method
	com.vanndeth.phoneshopmgt.controller.BrandController#getBrands(Map) mapped.
	*/
	@GetMapping("/")
	public ResponseEntity<?> getBrands() {
		List<BrandDTO> brands = brandService.getBrands()
			.stream()
			.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
			.collect(Collectors.toList());
		
		return ResponseEntity.ok(brands);
	}
	/*
	@GetMapping
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params) {
		List<BrandDTO> brandDTOs = brandService.getBrands(params)
			.stream()
			.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
			.collect(Collectors.toList());
		
		return ResponseEntity.ok(brandDTOs);
		
	}
	*/
	@GetMapping
	public ResponseEntity<?> getBrandsPagination(@RequestParam Map<String, String> params) {
		Page<Brand> page = brandService.getBrandsPagination(params);
		PageDTO pageDTO = new PageDTO(page);
		return ResponseEntity.ok(pageDTO);
		
	}

}
