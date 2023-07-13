package com.vanndeth.phoneshopmgt.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GeneralUtilsTests {
	
	@Test
	public void testToListIntegers() {
		// Given 
		List<String> listStrings = List.of("Apple", "Banana", "Coconut");
		
		// When
		List<Integer> listIntegers = GeneralUtils.toListIntegers(listStrings);
	
		// Then
		assertEquals(3, listIntegers.size());
		assertEquals(5, listIntegers.get(0));
		assertEquals(6, listIntegers.get(1));
		assertEquals(7, listIntegers.get(2));
	}
	
	@Test
	public void testGetEvenNumbers() {
		
		// Given
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		
		// When
		List<Integer> evenNumbers = GeneralUtils.getEvenNumbers(numbers);
		
		// Then
		assertEquals(4, evenNumbers.size());
		assertEquals(8, evenNumbers.get(3));
		
		
	}
	
	
	
}
