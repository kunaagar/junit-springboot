package com.practice.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void learning() {
		String responseFromService = 
				"[{\"id\":1,\"name\":\"Item1\",\"price\":10,\"quantity\":100,\"value\":1000},"
				+ "{\"id\":2,\"name\":\"Item2\",\"price\":11,\"quantity\":101,\"value\":1111},"
				+ "{\"id\":3,\"name\":\"Item3\",\"price\":12,\"quantity\":102,\"value\":1224},"
				+ "{\"id\":4,\"name\":\"Item4\",\"price\":13,\"quantity\":103,\"value\":1339}]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		
		int length = context.read("$.length()");
		System.out.println(context.read("$..id").toString());
		List<Integer>nos = context.read("$..id");
		System.out.println(nos);
		
		//1st ele
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:1]").toString());
		
		System.out.println(context.read("$.[?(@.name=='Item4')]").toString());
		assertThat(length).isEqualTo(4);
	}
}
