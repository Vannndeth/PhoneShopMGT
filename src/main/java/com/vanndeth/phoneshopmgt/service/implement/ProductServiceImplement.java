package com.vanndeth.phoneshopmgt.service.implement;

import org.springframework.stereotype.Service;

import com.vanndeth.phoneshopmgt.entity.Product;
import com.vanndeth.phoneshopmgt.exception.ResourceNotFoundException;
import com.vanndeth.phoneshopmgt.repository.ProductRepository;
import com.vanndeth.phoneshopmgt.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImplement implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public Product create(Product product) {
		String name = "%s %s".formatted(product.getModel().getName(), product.getColor().getName());
		product.setName(name);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", id));
	}

}
