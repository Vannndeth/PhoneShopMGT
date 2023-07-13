package com.vanndeth.phoneshopmgt.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.vanndeth.phoneshopmgt.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand newBrand);
//	List<Brand> findByNameLike(String name);
	List<Brand> getBrands();
	List<Brand> getBrands(Map<String, String> params);
	Page<Brand> getBrandsPagination(Map<String, String> params);
	
}
