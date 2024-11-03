package com.sathya.mvc.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	private Long proId;
	private String proName;
	private double proPrice;
	private String proDescription;
	private String proBrand;
	private String proCategory;
	
	public Long getProId() {
		return proId;
	}
	public void setProId(Long proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProDescription() {
        return proDescription;
    }
	 public void setProDescription(String proDescription) {
	        this.proDescription = proDescription;
	    }
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getProCategory() {
		return proCategory;
	}
	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
	
	
}
