package com.practice.unittesting.dto;

public class EmployeeDTO {
	private Integer employeeId;
	private String name;

	private String address;

	public EmployeeDTO() {}

	public EmployeeDTO(Integer employeeId, String name) {
		super();
		this.employeeId = employeeId;
		this.name = name;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
