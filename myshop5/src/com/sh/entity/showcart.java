package com.sh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="showcart")
public class showcart {
	private int oid;
	private int id;
	private String productname;
	private int count;
	private int price;
	
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name = "my_gen", strategy = "increment")
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}


	private int state;
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public showcart() {
		// TODO Auto-generated constructor stub
	}

}
