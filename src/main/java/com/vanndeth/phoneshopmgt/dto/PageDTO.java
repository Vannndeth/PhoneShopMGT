package com.vanndeth.phoneshopmgt.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PageDTO {
	private List<?> list;
	private PaginationDTO paginationDTO;
	public PageDTO(Page<?> page) {
		super();
		this.list = page.getContent();
		this.paginationDTO = PaginationDTO.builder()
									.first(page.isFirst())
									.last(page.isLast())
									.empty(page.isEmpty())
									.pageSize(page.getPageable().getPageSize())
									.pageNumber(page.getPageable().getPageNumber() + 1)
									.totalPages(page.getTotalPages())
									.totalElements(page.getTotalElements())
									.numberOfElements(page.getNumberOfElements())
									.build();
	}
	
	
}
