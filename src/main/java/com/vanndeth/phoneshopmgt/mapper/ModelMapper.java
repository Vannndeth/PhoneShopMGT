package com.vanndeth.phoneshopmgt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.vanndeth.phoneshopmgt.dto.ModelDTO;
import com.vanndeth.phoneshopmgt.entity.Brand;
import com.vanndeth.phoneshopmgt.entity.Model;
import com.vanndeth.phoneshopmgt.service.BrandService;

// use instead default method below
@Mapper(componentModel = "spring", uses = {BrandService.class})
public interface ModelMapper {
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	
	@Mapping(target = "brand", source = "brandId")
	Model toModel(ModelDTO modelDTO);
	 
	/*
	default Brand toBrand(Integer brandId) {
		Brand brand = new Brand();
		brand.setId(brandId);
		return brand;
	}
	*/
	
	@Mapping(target = "brandId", source = "brand.id")
	ModelDTO tomModelDTO(Model model);
}


