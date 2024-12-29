package com.util;

import java.util.LinkedHashMap;


import com.bki.tlv.ipop.TlvCrtIPOP;

public interface Tank {
	
	public LinkedHashMap<Integer,String> genVolData(TlvCrtIPOP ip);
	
	public double measureCapacity(TlvCrtIPOP ip);

}
