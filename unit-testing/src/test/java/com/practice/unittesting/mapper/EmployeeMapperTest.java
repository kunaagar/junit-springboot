package com.practice.unittesting.mapper;

import com.practice.unittesting.dto.Address;
import com.practice.unittesting.dto.Employee;
import com.practice.unittesting.dto.EmployeeDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

public class EmployeeMapperTest {

    @Test
    public void testMapToDTO(){
        Employee entity = new Employee(1,"Kunal");

        EmployeeMapper em = Mappers.getMapper(EmployeeMapper.class);

        entity.setAddress(new Address(11,"Pune"));
        EmployeeDTO dto = em.mapToDTO(entity);

        Assertions.assertThat(dto.getEmployeeId()).isEqualTo(entity.getId());
        Assertions.assertThat(dto.getName()).isEqualTo(entity.getName());
    }
}
