package com.bki.tlv.ipop;

import java.util.LinkedHashMap;

public class TlvCrtIPOP implements TankIPOP {
	// common objects -------------->
	private String tankType;
	private CustomerDtails custDtls;
	private com.bki.tlv.cyv.elpt.CyVertElptIPOP elpt;
	private com.bki.tlv.cyv.flat.CyVertFLATIPOP cyVerFE;
	private String tankLocation;
	private String tankId;
	// validity duration 
	private String fromDate;
	private String toDate;
	
	
	// out put objects
	private double capacity;
	private LinkedHashMap<Integer,String> volData;
	
	
	
	public String getTankType() {
		return tankType;
	}
	public void setTankType(String tankType) {
		this.tankType = tankType;
	}
	public CustomerDtails getCustDtls() {
		return custDtls;
	}
	public void setCustDtls(CustomerDtails custDtls) {
		this.custDtls = custDtls;
	}
	public String getTankLocation() {
		return tankLocation;
	}
	public void setTankLocation(String tankLocation) {
		this.tankLocation = tankLocation;
	}
	public String getTankId() {
		return tankId;
	}
	public void setTankId(String tankId) {
		this.tankId = tankId;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public LinkedHashMap<Integer, String> getVolData() {
		return volData;
	}
	public void setVolData(LinkedHashMap<Integer, String> volData) {
		this.volData = volData;
	}
	public com.bki.tlv.cyv.elpt.CyVertElptIPOP getElpt() {
		return elpt;
	}
	public void setElpt(com.bki.tlv.cyv.elpt.CyVertElptIPOP elpt) {
		this.elpt = elpt;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public com.bki.tlv.cyv.flat.CyVertFLATIPOP getCyVerFE() {
		return cyVerFE;
	}
	public void setCyVerFE(com.bki.tlv.cyv.flat.CyVertFLATIPOP cyVerFE) {
		this.cyVerFE = cyVerFE;
	}
	
	

}
