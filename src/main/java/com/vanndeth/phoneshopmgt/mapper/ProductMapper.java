package com.vanndeth.phoneshopmgt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vanndeth.phoneshopmgt.dto.ProductDTO;
import com.vanndeth.phoneshopmgt.entity.Product;
import com.vanndeth.phoneshopmgt.service.ColorService;
import com.vanndeth.phoneshopmgt.service.ModelService;

@Mapper(componentModel = "spring", uses = {ModelService.class, ColorService.class})
public interface ProductMapper {
	
	@Mapping(target = "model", source = "modelId")
	@Mapping(target = "color", source = "colorId")
	Product toProduct(ProductDTO productDTO);
}
