package com.practice.unittesting.mapper;

import com.practice.unittesting.dto.Address;
import com.practice.unittesting.dto.AddressDTO;
import org.mapstruct.Mapper;

import com.practice.unittesting.dto.Employee;
import com.practice.unittesting.dto.EmployeeDTO;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface EmployeeMapper {

	//Covert Employee entity to DTO
	@Mappings({
			@Mapping(source = "id",target = "employeeId"),
			@Mapping(target = "address",expression = "java(entity.getAddress().getPinCode().toString())")
	})
	EmployeeDTO mapToDTO(Employee entity);

}
