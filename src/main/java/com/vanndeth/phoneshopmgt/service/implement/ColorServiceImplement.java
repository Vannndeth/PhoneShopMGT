package com.vanndeth.phoneshopmgt.service.implement;

import org.springframework.stereotype.Service;

import com.vanndeth.phoneshopmgt.entity.Color;
import com.vanndeth.phoneshopmgt.exception.ResourceNotFoundException;
import com.vanndeth.phoneshopmgt.repository.ColorRepository;
import com.vanndeth.phoneshopmgt.service.ColorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ColorServiceImplement implements ColorService {

	private final ColorRepository colorRepository;

	@Override
	public Color create(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getById(Long id) {
		return colorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Color", id));
	}

}
