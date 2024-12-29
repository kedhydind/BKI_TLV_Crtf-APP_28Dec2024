package com.bki.tlv.cyv.elpt;

import java.util.LinkedHashMap;

import com.bki.tlv.ipop.TankIPOP;
import com.bki.tlv.ipop.TlvCrtIPOP;


public class CyVertElptIPOP  extends TlvCrtIPOP  implements TankIPOP{

	// input parameters
	private double h; // height of liquid in the tank , variable
	private double a; // dish height
	private double D; // internal Diameter
	
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
	

	
}
