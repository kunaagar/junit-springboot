package com.practice.unittesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(value = SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws Exception {
		String response = this.restTemplate.getForObject("/items",String.class);
		JSONAssert.assertEquals("[{id:1},{id:2},{id:3},{id:4}]", response, false);
	}

}
