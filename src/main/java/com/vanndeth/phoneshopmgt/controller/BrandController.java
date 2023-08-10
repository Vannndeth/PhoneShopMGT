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
import com.vanndeth.phoneshopmgt.entity.Model;
import com.vanndeth.phoneshopmgt.mapper.BrandMapper;
import com.vanndeth.phoneshopmgt.service.BrandService;
import com.vanndeth.phoneshopmgt.service.ModelService;
import com.vanndeth.phoneshopmgt.service.implement.BrandServiceImplement;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("brands")
public class BrandController {
	
	private final BrandService brandService;
	private final ModelService modelService;
	
	
//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
		
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Long brandId) {
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBrand(@PathVariable("id") Long brandId, @RequestBody BrandDTO brandDTO) {
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand newBrand = brandService.update(brandId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(newBrand));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getBrands() {
		List<BrandDTO> brands = brandService.getBrands()
			.stream()
			.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
			.collect(Collectors.toList());
		
		return ResponseEntity.ok(brands);
	}
	
	@GetMapping
	public ResponseEntity<?> getBrandsPagination(@RequestParam Map<String, String> params) {
		Page<Brand> page = brandService.getBrandsPagination(params);
		PageDTO pageDTO = new PageDTO(page);
		return ResponseEntity.ok(pageDTO);
		
	}
	
	@GetMapping("/{id}/models")
	public ResponseEntity<?> getModelByBrandId(@PathVariable("id") Long brandId) {
		List<Model> models = modelService.getModelByBrandId(brandId);
		return ResponseEntity.ok(models);
	}

}
