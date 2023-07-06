package com.vanndeth.phoneshopmgt.service.implement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vanndeth.phoneshopmgt.dto.PageDTO;
import com.vanndeth.phoneshopmgt.entity.Brand;
import com.vanndeth.phoneshopmgt.exception.ResourceNotFoundException;
import com.vanndeth.phoneshopmgt.filter.BrandFilter;
import com.vanndeth.phoneshopmgt.repository.BrandRepository;
import com.vanndeth.phoneshopmgt.service.BrandService;
import com.vanndeth.phoneshopmgt.specification.BrandSpecification;
import com.vanndeth.phoneshopmgt.utils.PageUtil;

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
		return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Integer id, Brand newBrand) {
		Brand brand = getById(id);
		brand.setName(newBrand.getName());
		return brandRepository.save(brand);
	}

	@Override
	public List<Brand> getBrands() {
		List<Brand> brands = brandRepository.findAll();
		return brands;
	}

	@Override
	public List<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();
		if (params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		if (params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));

		}
		BrandSpecification brandSpec = new BrandSpecification(brandFilter);
		return brandRepository.findAll(brandSpec);
	}
	

	@Override
	public Page<Brand> getBrandsPagination(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();
		if (params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		if (params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));

		}
		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if (params.containsKey(PageUtil.pageNumber)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.pageNumber));
		}
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if (params.containsKey(PageUtil.pageLimit)) {
			 pageLimit = Integer.parseInt(params.get(PageUtil.pageLimit));
		}
		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
		BrandSpecification brandSpec = new BrandSpecification(brandFilter);
		Page<Brand> page = brandRepository.findAll(brandSpec, pageable);
		return page;
	}
	
}
