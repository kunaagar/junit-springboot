package com.practice.unittesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.unittesting.dto.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
}
