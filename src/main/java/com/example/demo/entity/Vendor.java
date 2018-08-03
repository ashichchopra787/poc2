package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Shop_Vendor")
public class Vendor implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vendor_Id;
	@NotEmpty
	private String vendor_Name;
	private String vendor_Address;
	@Size(min = 10, max = 10)
	private String vendor_Phone;
	
	@OneToMany(cascade = CascadeType.ALL)		
	@JoinColumn(name="vendor")
	private Set<Product> productSet;

	public Vendor()
	{
		
	}
	
	
	public long getVendor_Id() {
		return vendor_Id;
	}

	public void setVendor_Id(long vendor_Id) {
		this.vendor_Id = vendor_Id;
	}

	public String getVendor_Name() {
		return vendor_Name;
	}

	public void setVendor_Name(String vendor_Name) {
		this.vendor_Name = vendor_Name;
	}

	public String getVendor_Address() {
		return vendor_Address;
	}

	public void setVendor_Address(String vendor_Address) {
		this.vendor_Address = vendor_Address;
	}

	public String getVendor_Phone() {
		return vendor_Phone;
	}

	public void setVendor_Phone(String vendor_Phone) {
		this.vendor_Phone = vendor_Phone;
	}


	public Set<Product> getProductSet() {
		return productSet;
	}


	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}

	
}
