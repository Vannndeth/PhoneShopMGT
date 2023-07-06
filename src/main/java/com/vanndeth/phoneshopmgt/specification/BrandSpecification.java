package com.vanndeth.phoneshopmgt.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vanndeth.phoneshopmgt.entity.Brand;
import com.vanndeth.phoneshopmgt.filter.BrandFilter;

import lombok.Data;

@Data
public class BrandSpecification implements Specification<Brand>{
	private final BrandFilter brandFilter;
	List<Predicate> predicates = new ArrayList<>();
	
	@Override
	public Predicate toPredicate(Root<Brand> brand, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(brandFilter.getName() != null) {
//			Predicate name = brand.get("name").in(brandFilter.getName());
//			predicates.add(name);
			
			Predicate name = cb.like(cb.upper(brand.get("name")), "%" + brandFilter.getName().toUpperCase() + "%");
			predicates.add(name);
			
		}
		
		if(brandFilter.getId() != null) {
			Predicate id = brand.get("id").in(brandFilter.getId());
			predicates.add(id);
		}

		Predicate[] array = predicates.toArray(Predicate[]::new);
		return cb.and(array);
	}

	
}
