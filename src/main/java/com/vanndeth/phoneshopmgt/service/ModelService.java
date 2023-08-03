package com.vanndeth.phoneshopmgt.service;

import java.util.List;

import com.vanndeth.phoneshopmgt.entity.Model;

public interface ModelService {
	Model createModel(Model model);
	List<Model> getModelByBrandId(Integer brandId);
}
