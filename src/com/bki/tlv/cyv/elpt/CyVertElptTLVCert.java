package com.bki.tlv.cyv.elpt;



import java.util.LinkedHashMap;

import com.util.*;
import static com.util.AppCon.PIby4;

import com.bki.tlv.cyv.elpt.CyVertElptIPOP;
import com.bki.tlv.ipop.TlvCrtIPOP;
import com.ibm.icu.text.DecimalFormat;

public class CyVertElptTLVCert implements Tank{
	
	private static final DecimalFormat formater = new DecimalFormat("0.00");  
	private CyVertElptIPOP ip; // input
	
	
	public double measureCapacity(TlvCrtIPOP ip){
		double capacity = 0d;
		
		CyVertElptIPOP cveip = ip.getElpt();
		capacity = measureCapacity(cveip);
		
		return capacity;
	}
	
	public double measureCapacity(CyVertElptIPOP ip){
		//CyVertElptIPOP ip = tip;
		// result variables
		double capacity = 0d;
		double bottomVol = 0d;
		double restOfTank = 0d;
		
		// input variables
		double h = ip.getH(); // height of liquid in the tank , variable
		double a = ip.getA(); // dish height
		double D = ip.getD(); // internal Diameter
		// for capacity a= h
		//bottomVol = PIby4 * Math.pow(((D*h)/a),2)*(a-(h/3));
		bottomVol = PIby4 * Math.pow(((D*a)/a),2)*(a-(a/3));
		System.out.println("bottomVol:"+bottomVol);
		//For capacity  
		//restOfTank = PIby4 * Math.pow(D,2)* (h-(a/3));
		restOfTank = PIby4 * Math.pow(D,2)* h;
		System.out.println("bottomVol:"+bottomVol+",restOfTank:"+restOfTank);
		capacity = bottomVol + restOfTank;
		System.out.println("capacity:"+capacity);
		 capacity =  capacity/1000;
		return capacity;
	}
	
		public LinkedHashMap<Integer,String> genVolData(TlvCrtIPOP ip){
			LinkedHashMap<Integer,String> volData = null;
			String tankType = ip.getTankType();
			CyVertElptIPOP cveip = ip.getElpt();
			
			volData = genVolDataCyVDE(cveip);
			
			return volData; 
			}
		
		public LinkedHashMap<Double,String> genVolData_D(TlvCrtIPOP ip){
			LinkedHashMap<Double,String> volData = null;
			CyVertElptIPOP cveip = ip.getElpt();
			volData = genVolData_d(cveip);
			
			return volData; 
			}

	 
	
	public LinkedHashMap<Integer,String> genVolDataCyVDE(CyVertElptIPOP ip){
		LinkedHashMap<Integer,String> volData = new LinkedHashMap<Integer,String>();

		// input variables
		double h = ip.getH(); // height of liquid in the tank , variable
		double a = ip.getA(); // dish height
		double D = ip.getD(); // internal Diameter
		double partialVol = 0d;
		System.out.println("h:"+h+",a:"+a+",D:"+D);
		double totH = h+a;
		String pvol = null;
		for(int i=1; i<=totH; i++) {
			if(i<=a) {
				
				partialVol = PIby4 *( Math.pow(((D*i)/a),2))*(a-(i/3));
				System.out.println("i<=a , i:"+i+",partialVol:"+partialVol/1000);
				volData.put(i,partialVol/1000 +"");
				
				//pvol = formater.format(partialVol/1000);
				//System.out.println("i<=a , i:"+i+",partialVol:"+pvol);
				//volData.put(i,pvol );	
				
			}else if(i >a) {
				partialVol =  PIby4 * Math.pow(D,2)* (i-(a/3));
				System.out.println("i<=a , i:"+i+",partialVol:"+partialVol/1000);
				volData.put(i,partialVol/1000 +"");

				//System.out.println("i<=a , i:"+i+",partialVol:"+partialVol);
				//pvol = formater.format(partialVol/1000);
				//System.out.println("i<=a , i:"+i+",partialVol:"+pvol);
				//volData.put(i,pvol );	
			}
			
		}
		
		System.out.println("volData:"+volData);
		
		return volData;
	}
	

	public LinkedHashMap<Double,String> genVolData_d(CyVertElptIPOP ip){
		LinkedHashMap<Double,String> volData = new LinkedHashMap<Double,String>();

		// input variables
		double h = ip.getH(); // height of liquid in the tank , variable
		double a = ip.getA(); // dish height
		double D = ip.getD(); // internal Diameter
		double partialVol = 0d;
		System.out.println("h:"+h+",a:"+a+",D:"+D);
		double totH = h+a;
		String pvol = null;
		for(double i=1; i<=totH; i++) {
			if(i<=a) {
				
				partialVol = PIby4 *( Math.pow(((D*i)/a),2))*(a-(i/3));
				System.out.println("i<=a , i:"+i+",partialVol:"+partialVol/1000);
				volData.put(i,partialVol/1000 +"");
				
				//System.out.println("i<=a , i:"+i+",partialVol:"+pvol);
				//volData.put(i,pvol );	
				
			}else if(i >a) {
				partialVol =  PIby4 * Math.pow(D,2)* (i-(a/3));
				System.out.println("i<=a , i:"+i+",partialVol:"+partialVol/1000);
				volData.put(i,partialVol/1000 +"");

				//pvol = formater.format(partialVol/1000);
				//System.out.println("i<=a , i:"+i+",partialVol:"+partialVol);
				//pvol = formater.format(partialVol/1000);
				//System.out.println("i<=a , i:"+i+",partialVol:"+pvol);
				//volData.put(i,pvol );	
			}
			
		}
		
		System.out.println("volData:"+volData);
		
		return volData;
	}
	

	
	
	
	private CyVertElptIPOP getIp() {
		return ip;
	}


	private void setIp(CyVertElptIPOP ip) {
		this.ip = ip;
	}
	
	public static void main(String[] args) {
		
		CyVertElptTLVCert obj = new CyVertElptTLVCert();
		CyVertElptIPOP input = new CyVertElptIPOP();
		obj.setIp(input);
		input.setH(42d);
		input.setD(95d);
		input.setA(14d);
		double capcity = obj.measureCapacity(input);
		String capa = formater.format(capcity);
		System.out.println("Calculated capcity:"+capcity);
		System.out.println("formated capa:"+capa);
		
		LinkedHashMap<Integer,String> volData = obj.genVolDataCyVDE(input);
	}
	

}
