package com.vanndeth.phoneshopmgt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanndeth.phoneshopmgt.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long>{
	
	List<Model> findModelByBrandId(Long brandId);

}
