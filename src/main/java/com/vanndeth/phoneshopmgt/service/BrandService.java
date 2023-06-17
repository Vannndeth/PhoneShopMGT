package com.vanndeth.phoneshopmgt.service;

import com.vanndeth.phoneshopmgt.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand newBrand);
}
