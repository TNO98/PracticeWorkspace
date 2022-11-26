package com.malay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "e_products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int productID;
	
	@Column(name = "product_name")
	private String pName;
	
	@Column(name = "product_price")
	private double pPrice;
	
	@Column(name = "product_brand")
	private String BrandName;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", pName=" + pName + ", pPrice=" + pPrice + ", BrandName="
				+ BrandName + "]";
	}

}
