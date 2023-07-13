package com.vanndeth.phoneshopmgt.utils;

import java.util.List;
import java.util.stream.Collectors;

public class GeneralUtils {
	
	// convert list of String to list of Integer
	//	["Apple", "Banana", "Coconut"] => ["5", "6", "7"]
	public static List<Integer> toListIntegers(List<String> listStrings) {
		
		List<Integer> listIntegers = listStrings.stream()
			.map(str -> str.length())
			.toList();
		
			return listIntegers;
	}
	
	public static List<Integer> getEvenNumbers(List<Integer> numbers) {
		List<Integer> evenNumber = numbers.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());
		return evenNumber;
	}
}
