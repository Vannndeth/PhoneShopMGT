package com.vanndeth.phoneshopmgt.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import com.vanndeth.phoneshopmgt.entity.Brand;
import com.vanndeth.phoneshopmgt.exception.ApiException;
import com.vanndeth.phoneshopmgt.exception.ResourceNotFoundException;
import com.vanndeth.phoneshopmgt.repository.BrandRepository;
import com.vanndeth.phoneshopmgt.service.BrandService;

import net.bytebuddy.asm.Advice.Return;



@Service
public class BrandServiceImplement implements BrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Integer id) {
		
//		Optional<Brand> brandOptional = brandRepository.findById(id);
//		if(brandOptional.isPresent()) {
//			return brandOptional.get();
//		}
		
//		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id = "+id+" not found");
//		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id = %d not found".formatted(id));
		
//		return brandRepository.findById(id)
//				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Brand with id = %d not found", id)));
	
//		return brandRepository.findById(id)
//				.orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("Brand with id = %d not found", id)));
		
		return brandRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	
	@Override
	public Brand update(Integer id, Brand newBrand) {
		Brand brand = getById(id);
		brand.setName(newBrand.getName());
		return brandRepository.save(brand);
	}


}
