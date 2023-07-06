package com.vanndeth.phoneshopmgt.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface PageUtil {

	int DEFAULT_PAGE_NUMBER = 1;
	int DEFAULT_PAGE_LIMIT = 2;
	String pageNumber = "_page";
	String pageLimit = "_limit";

	public static Pageable getPageable(int pageNumber, int pageSize) {
		if (pageNumber < DEFAULT_PAGE_NUMBER) {
			pageNumber = DEFAULT_PAGE_NUMBER;
		}
		if (pageSize < 1) {
			pageSize = DEFAULT_PAGE_LIMIT;
		}
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return pageable;
	}
}
