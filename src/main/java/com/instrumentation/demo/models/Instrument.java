package com.instrumentation.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Instrument {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String buyerName ;
	private String email ;
	private String instrumentModel ;
	private Long serialNumber ;
	private String purchaseDate ;
	
	public Instrument() {
		super();
	}
	public Instrument(Long id, String buyerName, String email,
			String instrumentModel, Long serialNumber, String purchaseDate) {
		super();
		this.id = id;
		this.buyerName = buyerName;
		this.email = email;
		this.instrumentModel = instrumentModel;
		this.serialNumber = serialNumber;
		this.purchaseDate = purchaseDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstrumentModel() {
		return instrumentModel;
	}
	public void setInstrumentModel(String instrumentModel) {
		this.instrumentModel = instrumentModel;
	}
	public Long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
}
