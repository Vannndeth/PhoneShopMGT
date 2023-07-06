package com.vanndeth.phoneshopmgt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.vanndeth.phoneshopmgt.dto.BrandDTO;
import com.vanndeth.phoneshopmgt.entity.Brand;

@Mapper
public interface BrandMapper {
	
	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
	
//	@Mapping(target = "version", source = "vs")
	Brand toBrand(BrandDTO brandDTO);
	
//	@Mapping(target = "vs", source = "version")
	BrandDTO toBrandDTO(Brand brand);
	

}
