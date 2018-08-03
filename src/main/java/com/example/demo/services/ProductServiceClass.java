package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.VendorRepository;

@Service
public class ProductServiceClass {
	
	 @Autowired
	 ProductRepository productRepository;

	 @Autowired
	 VendorRepository vendorRepository;
	 
	public String addProduct(Product productObject)
	{
		String status = null;
		long vendorId = productObject.getVendor().getVendor_Id();
		
		if (productObject.getExpiry_Date().before( productObject.getManufacturing_Date()))
		{
			status = "Expiry date cannot be less than manufacturing date";
			return status;
		}
		
		/*else if(vendorRepository.findById(vendorId) == null)
		{
			
			status="Vendor Id not present";
		}*/
		else
		{	
		  status="product Inserted";
		  
		  productRepository.save(productObject);
		}
		return status;
	}
	
	public List<Product> retrieveAllProducts()
	{
		return (List<Product>) productRepository.findAll();
	}
	
	public void deleteVendor(Long productId)
	{
		productRepository.deleteById(productId);
	}

	public Optional<Product> findById(long productId) {
		
	return productRepository.findById(productId);
	}
}
