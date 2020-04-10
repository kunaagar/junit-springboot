package com.practice.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.unittesting.dto.Item;
import com.practice.unittesting.service.ItemBusinessService;

@RestController
public class ItemController {

	
	@Autowired
	private ItemBusinessService businessService;
	
	@GetMapping("/item")
	public Item item() {
		return new Item(1,"Wheat", 10,100);
	}
	
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		/* return new Item(1,"Wheat", 10,100); */
		
		return businessService.getItem();
	}
	
	@GetMapping("/items")
	public List<Item> allItems() {
		return businessService.getAllItems();
	}
}
