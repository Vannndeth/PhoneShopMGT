package com.vanndeth.phoneshopmgt.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vanndeth.phoneshopmgt.entity.Model;
import com.vanndeth.phoneshopmgt.exception.ResourceNotFoundException;
import com.vanndeth.phoneshopmgt.repository.ModelRepository;
import com.vanndeth.phoneshopmgt.service.ModelService;

import lombok.AllArgsConstructor;

// use constructor parameter instead @Autowired
@AllArgsConstructor
@Service
public class ModelServiceImplement implements ModelService{
	
	private ModelRepository modelRepository;
	
	@Override
	public Model create(Model model) {
		return modelRepository.save(model);
	}

	@Override
	public List<Model> getModelByBrandId(Long brandId) {
		List<Model> models = modelRepository.findModelByBrandId(brandId);
		return models;
	}

	@Override
	public Model getById(Long id) {
		return modelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Model", id));
	}

}
