package com.vanndeth.phoneshopmgt.service;

import java.util.List;

import com.vanndeth.phoneshopmgt.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand newBrand);
	List<Brand> getBrands();
	List<Brand> getBrands(String name);
	List<Brand> getByName(String name);
	
}
