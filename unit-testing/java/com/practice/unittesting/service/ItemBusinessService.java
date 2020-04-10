package com.practice.unittesting.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.unittesting.dto.Item;
import com.practice.unittesting.repo.ItemRepository;

@Component
public class ItemBusinessService {

	@Autowired
	private ItemRepository repository;
	
	public Item getItem() {
		// TODO Auto-generated method stub
		 return new Item(1,"Wheat", 10,100);
	}

	public List<Item> getAllItems() {
		
		List<Item> items = repository.findAll();
		items = items.stream().map(i ->{
			 i.setValue(i.getPrice()*i.getQuantity());
			 return i;
		}).collect(Collectors.toList());
		return items;
	}
}
