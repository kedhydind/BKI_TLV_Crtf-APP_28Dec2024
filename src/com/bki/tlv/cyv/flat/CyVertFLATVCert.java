package com.bki.tlv.cyv.flat;



import java.util.LinkedHashMap;

import com.util.*;
import static com.util.AppCon.PI;

import com.bki.tlv.cyv.elpt.CyVertElptIPOP;
import com.bki.tlv.ipop.TlvCrtIPOP;
import com.ibm.icu.text.DecimalFormat;

public class CyVertFLATVCert implements Tank{
	
	private static final DecimalFormat formater = new DecimalFormat("0.00");  
	private CyVertFLATIPOP ip; // input
	//private CyVert
	
	public double measureCapacity(TlvCrtIPOP ip){
		double capacity = 0d;
		
		CyVertFLATIPOP cvFip = ip.getCyVerFE();
		capacity = measureCapacity(cvFip);
		
		return capacity;
	}
	
	public double measureCapacity(CyVertFLATIPOP ip){
		//CyVertElptIPOP ip = tip;
		// result variables
		double capacity = 0d;
		
		// input variables
		double h = ip.getH(); // height of liquid in the tank , variable
		//double a = ip.getA(); // dish height
		double D = ip.getD(); // internal Diameter
		capacity = PI*(D/2)*(D/2)*h;
		System.out.println("capacity:"+capacity);
		 capacity =  capacity/1000;
		return capacity;
	}
	
		public LinkedHashMap<Integer,String> genVolData(TlvCrtIPOP ip){
			LinkedHashMap<Integer,String> volData = null;
			String tankType = ip.getTankType();
			CyVertFLATIPOP cveip = ip.getCyVerFE();
			
			volData = genVolDataCyVFE(cveip);
			
			return volData; 
			}
		
		public LinkedHashMap<Double,String> genVolData_F(TlvCrtIPOP ip){
			LinkedHashMap<Double,String> volData = null;
			CyVertElptIPOP cveip = ip.getElpt();
			volData = genVolData_F(cveip);
			
			return volData; 
			}

	 
	
	public LinkedHashMap<Integer,String> genVolDataCyVFE(CyVertFLATIPOP ip){
		LinkedHashMap<Integer,String> volData = new LinkedHashMap<Integer,String>();

		// input variables
		double h = ip.getH(); // height of liquid in the tank , variable
		//double a = ip.getA(); // dish height
		double D = ip.getD(); // internal Diameter
		double partialVol = 0d;
		System.out.println("h:"+h+",D:"+D);
		double totH = h;
		String pvol = null;
		for(int i=1; i<=totH; i++) {
			
				
			//	partialVol = PIby4 *( Math.pow(((D*i)/a),2))*(a-(i/3));
				partialVol = PI*(D/2)*(D/2)*i;
				System.out.println("i<=a , i:"+i+",partialVol:"+partialVol/1000);
				volData.put(i,partialVol/1000 +"");
				
						
		}
		
		System.out.println("volData:"+volData);
		
		return volData;
	}
	

	public LinkedHashMap<Double,String> genVolData_F(CyVertFLATIPOP ip){
		LinkedHashMap<Double,String> volData = new LinkedHashMap<Double,String>();

		// input variables
		double h = ip.getH(); // height of liquid in the tank , variable
		//double a = ip.getA(); // dish height
		double D = ip.getD(); // internal Diameter
		double partialVol = 0d;
		System.out.println("h:"+h+",D:"+D);
		double totH = h;
		String pvol = null;
		for(double i=1; i<=totH; i++) {
			//partialVol = PIby4 *( Math.pow(((D*i)/a),2))*(a-(i/3));
			partialVol = PI*(D/2)*(D/2)*i;
			System.out.println("i<=a , i:"+i+",partialVol:"+partialVol/1000);
			volData.put(i,partialVol/1000 +"");
		}
		
		System.out.println("volData:"+volData);
		
		return volData;
	}
	

	
	
	
	private CyVertFLATIPOP getIp() {
		return ip;
	}


	private void setIp(CyVertFLATIPOP ip) {
		this.ip = ip;
	}
	
	public static void main(String[] args) {
		
		CyVertFLATVCert obj = new CyVertFLATVCert();
		CyVertFLATIPOP input = new CyVertFLATIPOP();
		obj.setIp(input);
		input.setH(42d);
		input.setD(95d);
		//input.setA(14d);
		double capcity = obj.measureCapacity(input);
		String capa = formater.format(capcity);
		System.out.println("Calculated capcity:"+capcity);
		System.out.println("formated capa:"+capa);
		
		LinkedHashMap<Integer,String> volData = obj.genVolDataCyVFE(input);
	}
	

}
