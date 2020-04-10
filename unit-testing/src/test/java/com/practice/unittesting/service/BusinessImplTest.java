package com.practice.unittesting.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.practice.unittesting.repo.DataService;



@RunWith(MockitoJUnitRunner.class)
public class BusinessImplTest {

	@Mock
	DataService dataService;
	
	@InjectMocks
	BusinessImpl service;

	@Before
	public void setUp() {
				
	}
	
	@Test
	public void testCalculateSum() {
		when(dataService.getAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, service.calculateSumUsingDataService());
	}
	
	@Test
	public void testCalculateSumEmptyArray() {
		when(dataService.getAllData()).thenReturn(new int[] {});
		assertEquals(0, service.calculateSumUsingDataService());
	}
	
	@Test
	public void testCalculateSumOneValue() {
		when(dataService.getAllData()).thenReturn(new int[] {1});
		assertEquals(1, service.calculateSumUsingDataService());
	}

}
