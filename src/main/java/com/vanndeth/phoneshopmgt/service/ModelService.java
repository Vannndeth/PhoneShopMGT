package com.vanndeth.phoneshopmgt.service;

import java.util.List;

import com.vanndeth.phoneshopmgt.entity.Model;

public interface ModelService {
	Model create(Model model);
	Model getById(Long id);
	List<Model> getModelByBrandId(Long brandId);
}
