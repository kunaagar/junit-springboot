package com.practice.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		assertThat(numbers).hasSize(5).allMatch(x -> x>=1).allMatch(x->x < 6).noneMatch(x -> x < 0);
	}
}
