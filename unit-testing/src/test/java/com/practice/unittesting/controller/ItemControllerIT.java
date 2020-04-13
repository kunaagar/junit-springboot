package com.practice.unittesting.controller;

import com.practice.unittesting.dto.Item;
import com.practice.unittesting.repo.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;


@RunWith(value = SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private ItemRepository repository;
	
	@Test
	public void contextLoads() throws Exception {

		/**
		 * Incase you dont have a sql file then u can mock repository
		 */
		when(repository.findAll()).thenReturn(
				Arrays.asList(new Item(1,"Item1", 10,100),
						new Item(2,"Item2", 11,101),
						new Item(3,"Item3", 11,101)
				));
		String response = this.restTemplate.getForObject("/items",String.class);
		JSONAssert.assertEquals("[{id:1},{id:2},{id:3}]", response, false);
	}

}
