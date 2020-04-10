package com.practice.unittesting.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.unittesting.dto.Item;
import com.practice.unittesting.repo.ItemRepository;

@RunWith(SpringRunner.class)
public class ItemBusinessServiceTest {

	@Mock
	private ItemRepository repository;
	
	@InjectMocks
	private ItemBusinessService businessService;
	
	@Test
	public void testGetAllItems() {
		when(repository.findAll()).thenReturn(
				Arrays.asList(new Item(1,"Item1", 10,100),
				new Item(2,"Item2", 11,101),
				new Item(2,"Item2", 11,101)
				));
		
		List<Item> items = businessService.getAllItems();
		
		assertEquals(1000, items.get(0).getValue());
		
		assertEquals(1111, items.get(1).getValue());
	}

}
