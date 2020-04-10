package com.practice.unittesting.service;

import com.practice.unittesting.repo.DataService;

public class BusinessImpl {
	
	private DataService dataService;
	
	/*
	 * public void setDataService(DataService dataService) { this.dataService =
	 * dataService; }
	 */

	public int calculateSum(int[] data) {
		int sum = 0;
		for(int no : data) {
			sum += no;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = dataService.getAllData();
		for(int no : data) {
			sum += no;
		}
		return sum;
	}
}
