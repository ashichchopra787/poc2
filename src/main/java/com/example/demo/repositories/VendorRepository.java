package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Vendor;

public interface VendorRepository extends CrudRepository<Vendor,Long>{


	List<Vendor> findAll();

	
}
