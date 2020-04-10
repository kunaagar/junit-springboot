package com.practice.unittesting.spike;

import org.hamcrest.Matchers;

import static org.assertj.core.api.Assertions.allOf;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMattcherTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		assertThat(numbers,hasSize(5));
		assertThat(numbers, hasItems(1,2));
		assertThat(numbers,	everyItem(greaterThanOrEqualTo(1)));
		
	}

}
