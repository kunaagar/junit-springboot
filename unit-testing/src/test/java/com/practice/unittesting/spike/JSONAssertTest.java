package com.practice.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {
	
	String actualResponse = "{\"id\": 1,\"name\":\"Wheat\",\"price\":10,\"quantity\":100}";
	@Test
	public void jsonAssertStrictTrue() throws JSONException {
		String expectedResponse ="{\"id\": 1,\"name\":\"Wheat\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse,true);
	}
	
	@Test
	public void jsonAssertStrictFalse() throws JSONException {
		String expectedResponse ="{\"id\": 1,\"name\":\"Wheat\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse,false);
	}
	
	@Test
	public void jsonAssertWithoutEscapeCharacters() throws JSONException {
		String expectedResponse ="{id: 1,name:Wheat,price:10,quantity:100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse,true);
	}
}
