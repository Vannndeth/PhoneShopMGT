package com.vanndeth.phoneshopmgt.service.implement;

import org.springframework.stereotype.Service;

import com.vanndeth.phoneshopmgt.entity.Model;
import com.vanndeth.phoneshopmgt.repository.ModelRepository;
import com.vanndeth.phoneshopmgt.service.ModelService;

import lombok.AllArgsConstructor;

// use constructor parameter instead @Autowired
@AllArgsConstructor
@Service
public class ModelServiceImplement implements ModelService{
	
	private ModelRepository modelRepository;
	
	@Override
	public Model createModel(Model model) {
		return modelRepository.save(model);
	}

}
