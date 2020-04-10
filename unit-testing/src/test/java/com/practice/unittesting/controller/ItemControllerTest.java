package com.practice.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.practice.unittesting.dto.Item;
import com.practice.unittesting.service.ItemBusinessService;


@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void testItem() throws Exception {
		
		//when(businessService.getItem()).thenReturn(new Item(1,"Wheat", 10,100));
		RequestBuilder request = 
				MockMvcRequestBuilders
				.get("/item")
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult mvcResult = mockMvc.perform(request)
										.andExpect(status().isOk())
										.andExpect(content().json("{\"id\": 1,\"name\":\"Wheat\",\"price\":10,\"quantity\":100}"))
										.andReturn();
	}
	
	@Test
	public void testItemFromBusinessService() throws Exception {
		
		when(businessService.getItem()).thenReturn(new Item(1,"Wheat", 10,100));
		RequestBuilder request = 
				MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult mvcResult = mockMvc.perform(request)
										.andExpect(status().isOk())
										.andExpect(content().json("{id: 1,name:Wheat,price:10,quantity:100}"))
										.andReturn();
	}
	
	@Test
	public void testAllItems() throws Exception {
		
		when(businessService.getAllItems()).thenReturn(
				Arrays.asList(new Item(1,"Item1", 10,100))
				);
		RequestBuilder request = 
				MockMvcRequestBuilders
				.get("/items")
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult mvcResult = mockMvc.perform(request)
										.andExpect(status().isOk())
										.andExpect(content().json("[{id: 1,name:Item1,price:10,quantity:100}]"))
										.andReturn();
	}

}
