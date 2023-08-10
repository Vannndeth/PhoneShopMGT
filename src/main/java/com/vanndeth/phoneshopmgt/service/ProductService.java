package com.vanndeth.phoneshopmgt.service;

import com.vanndeth.phoneshopmgt.entity.Product;

public interface ProductService {
	Product create(Product product);
	Product getById(Long id);
}
