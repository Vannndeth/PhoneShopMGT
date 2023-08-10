package com.vanndeth.phoneshopmgt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vanndeth.phoneshopmgt.dto.ModelDTO;
import com.vanndeth.phoneshopmgt.entity.Model;
import com.vanndeth.phoneshopmgt.mapper.ModelsMapper;
import com.vanndeth.phoneshopmgt.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	private final ModelService modelService;
	private final ModelsMapper modelMapper;
	
//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> createModel(@RequestBody ModelDTO modelDTO) {
		Model model = modelMapper.toModel(modelDTO);
		model = modelService.create(model);
		return ResponseEntity.ok(modelMapper.tomModelDTO(model));
	}
}
