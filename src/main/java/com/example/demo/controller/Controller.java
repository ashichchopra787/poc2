package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.Vendor;
import com.example.demo.services.ProductServiceClass;
import com.example.demo.services.VendorServiceClass;

@RestController
public class Controller {

	@Autowired
	private VendorServiceClass vendorServiceClass;
	@Autowired
	private ProductServiceClass productServiceClass;

    //Add Vendor
	@PostMapping("/addVendor")
	public ResponseEntity<?> createVendor(@RequestBody Vendor vendor)
	 {
		 String status = vendorServiceClass.addVendor(vendor);
		 return new ResponseEntity<String>(status,HttpStatus.OK);
	 }
	
	 //Update Vendor
	@PutMapping("/updateVendor/{id}")
	public ResponseEntity<?> updateVendor(@RequestBody Vendor vendor, @PathVariable long id) {

	    Vendor newVendor = null;
		Optional<Vendor> vendorData = vendorServiceClass.findById(id);;
	    if (!vendorData.isPresent())
		  return ResponseEntity.notFound().build();
		
		else 
			
		 newVendor = vendorData.get(); 
	   
	     newVendor.setVendor_Name(vendor.getVendor_Name());
	     newVendor.setVendor_Address(vendor.getVendor_Address());
	     newVendor.setVendor_Phone(vendor.getVendor_Phone());
	     if(vendor.getProductSet()==null)
	        {  
	    	  newVendor.setProductSet(newVendor.getProductSet());
	        }
	        else
	        {
	          newVendor.setProductSet(vendor.getProductSet());
	        }
		 vendorServiceClass.addVendor(newVendor);
		
		 return new ResponseEntity<String>("Vendor Updated",HttpStatus.OK);
	}
	
	//Read Vendor
	@GetMapping("/getVendor")
	public List<Vendor> retrieveAllVendors() {
		List<Vendor> vendorsList= vendorServiceClass.retrieveAllVendors();
		return vendorsList;
	}
	
	//Delete Vendor
	@DeleteMapping("/deleteVendor/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable long id) {
		vendorServiceClass.deleteVendor(id);
		return new ResponseEntity<String>("Vendor Deleted",HttpStatus.OK);
	}
	
	 //Add Vendor
		@PostMapping("/addProduct")
		public ResponseEntity<?> createProduct(@RequestBody Product product)
		 {
			 String status = productServiceClass.addProduct(product);
			 return new ResponseEntity<String>(status,HttpStatus.OK);
		 }
		
	//Read Product
	@GetMapping("/getProduct")
	public List<Product> retrieveAllProducts() {
		List<Product> productList= productServiceClass.retrieveAllProducts();
		return productList;
	}
	
	//Delete Product
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable long id) {
		productServiceClass.deleteVendor(id);
		return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
	}
	
	//Update Product
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable long id) {

		Optional<Product> productOptional = productServiceClass.findById(id);        
		Product newProduct = null;
        if (!productOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		else 
		{   newProduct =  productOptional.get();
	        newProduct.setProduct_Name(product.getProduct_Name());
	        newProduct.setProduct_Price(product.getProduct_Price());
	        newProduct.setExpiry_Date(product.getExpiry_Date());
	        newProduct.setManufacturing_Date(product.getManufacturing_Date());
	        if(product.getVendor()==null)
	        {  
	        	newProduct.setVendor(newProduct.getVendor());
	        }
	        else
	        {
	        	newProduct.setVendor(product.getVendor());
	        }
	        	
			productServiceClass.addProduct(newProduct);
		}
		return new ResponseEntity<String>("Product Updated",HttpStatus.OK);
	}
	
}
