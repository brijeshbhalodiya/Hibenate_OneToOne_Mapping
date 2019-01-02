package com.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Person")
public class Person {
	
	private int pId;
	
	private PersonDetail pDetail;
	
	
	@OneToOne(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinColumn(name = "pDetail_Id")
	public PersonDetail getpDetail() {
		return pDetail;
	}
	public void setpDetail(PersonDetail pDetail) {
		this.pDetail = pDetail;
	}
	
	@Id
	@GenericGenerator(name="inc",strategy="increment")
	@GeneratedValue(generator = "inc")
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	
	
	

}
