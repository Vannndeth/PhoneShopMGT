package com.vanndeth.phoneshopmgt.service;

import com.vanndeth.phoneshopmgt.entity.Color;

public interface ColorService {
	Color create(Color color);
	Color getById(Long id);
}
