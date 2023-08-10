package com.vanndeth.phoneshopmgt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanndeth.phoneshopmgt.dto.ProductDTO;
import com.vanndeth.phoneshopmgt.entity.Product;
import com.vanndeth.phoneshopmgt.mapper.ProductMapper;
import com.vanndeth.phoneshopmgt.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	private final ProductMapper productMapper;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO ) {
		Product product = productMapper.toProduct(productDTO);
		product = productService.create(product);

		return ResponseEntity.ok(product);
	}
}
