package com.vanndeth.phoneshopmgt.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanndeth.phoneshopmgt.entity.Brand;
import com.vanndeth.phoneshopmgt.repository.BrandRepository;
import com.vanndeth.phoneshopmgt.service.BrandService;



@Service
public class BrandServiceImplement implements BrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

}
