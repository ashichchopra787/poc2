package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.entity.Vendor;
import com.example.demo.repositories.VendorRepository;

@Service
public class VendorServiceClass {

	@Autowired
	VendorRepository vendorRepository;
	
	public String  addVendor(Vendor vendorobject)
	{
		String status=null;
	
		for(Product products:vendorobject.getProductSet())
		{
			if(products.getExpiry_Date().before( products.getManufacturing_Date()))
		     {
				status = "Expiry date cannot be less than manufacturing date";
				return status;
			 }
		}
		
		if(vendorobject.getVendor_Phone().length()<10 ||vendorobject.getVendor_Phone().length()>10)
		{
			status="Please enter a 10 digit mobile number";
		}

		else 
		{	
		    status = "Vendor inserted";
			vendorRepository.save(vendorobject);
		}
		return status;
	}
	
	

	public List<Vendor> retrieveAllVendors() {
		// TODO Auto-generated method stub
		return (List<Vendor>) vendorRepository.findAll();
	}
	
	public void deleteVendor(Long vendorId)
	{
		vendorRepository.deleteById(vendorId);
	}
	
	public Optional<Vendor> findById(Long vendor_Id)
	{
		return vendorRepository.findById(vendor_Id);
	}
}
