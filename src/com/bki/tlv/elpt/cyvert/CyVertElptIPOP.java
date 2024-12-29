package com.bki.tlv.elpt.cyvert;

import java.util.LinkedHashMap;

public class CyVertElptIPOP {

	// input parameters
	private double h; // height of liquid in the tank , variable
	private double a; // dish height
	private double D; // internal Diameter
	
	// intermediate objects
	private double capacity;
	
	private LinkedHashMap<Integer,String> volData;
	
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getD() {
		return D;
	}
	public void setD(double d) {
		D = d;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public LinkedHashMap<Integer,String> getVolData() {
		return volData;
	}
	public void setVolData(LinkedHashMap<Integer,String> volData) {
		this.volData = volData;
	}
	
	
}
