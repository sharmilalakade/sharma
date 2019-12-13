package com.scp.sixteen.java.CrudOpe;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductDemo")


public class Product {
	@Id
	
	private int prodId;
	private String prodName;
	/**
	 * 
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param prodId
	 * @param prodName
	 */
	public Product(int prodId, String prodName) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
	}
	
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + "]";
	}
	/**
	 * @return the prodId
	 */
	public int getProdId() {
		return prodId;
	}
	/**
	 * @param prodId the prodId to set
	 */
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}
	/**
	 * @param prodName the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	

}
