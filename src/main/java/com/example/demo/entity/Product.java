package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Shop_Product")
public class Product implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  product_Id;
	@NotEmpty
	private String product_Name;
	private float product_Price;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date manufacturing_Date;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date expiry_Date;
	@ManyToOne(cascade = CascadeType.ALL)		
	@JoinColumn(name="vendor_Id")
	private Vendor vendor;
	
	public Product()
	{
		
	}
	
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	
	
	public long getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(long product_Id) {
		this.product_Id = product_Id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public float getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(float product_Price) {
		this.product_Price = product_Price;
	}

	public Date getManufacturing_Date() {
		return manufacturing_Date;
	}

	public void setManufacturing_Date(Date manufacturing_Date) {
		this.manufacturing_Date = manufacturing_Date;
	}

	public Date getExpiry_Date() {
		return expiry_Date;
	}

	public void setExpiry_Date(Date expiry_Date) {
		this.expiry_Date = expiry_Date;
	}
	
	
	
	
}
