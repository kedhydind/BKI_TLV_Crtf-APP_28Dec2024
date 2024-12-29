package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.io.FileWriter;
import java.io.IOException; 


public class BKIFileUtil {

	public static String gethtmlStrfromFile(String fileFldPathNm) {
		String htmlStr = null;
		File htmlFile = null;
		StringBuilder contentBuilder = new StringBuilder(); 

		try {

			htmlFile = new File(fileFldPathNm);
			if(htmlFile.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(fileFldPathNm));
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) 
				{
					contentBuilder.append(sCurrentLine).append("\n");
				}

				System.out.println("contentBuilder:"+contentBuilder.toString());


			}else {
				System.out.println("File not found ,fileFldPathNm:"+fileFldPathNm);
			}
		} catch (Exception e) {
			System.out.println("Exception in gethtmlStrfromFile(), Error Message:"+e.getMessage()+"\n ");
			e.printStackTrace();
		}
		htmlStr = contentBuilder.toString();
		return htmlStr;

	}
	
	public static String getHTML_Tmplt_contentCLBFlContent() {
		String fileStr = null;
		
		try {
			InputStream is = BKIFileUtil.class.getResourceAsStream("/resource/TLVCert.html");
			
			fileStr = readFromInputStream(is);
			System.out.println("fileStr length"+fileStr.length());
		} catch (Exception e) {
			System.out.println("Exception in cLBgetFlContent(), Error Message:"+e.getMessage()+"\n ");
			e.printStackTrace();
		}
		
		return fileStr;
	}

	public static void main(String[] args) {
		//InputStream is = ClassLoader.getSystemResourceAsStream("/resource/TLVCert.html");
		
		//System.out.println("getCLBFlContent():"+getHTML_Tmplt_contentCLBFlContent());
		//FileUtil.gethtmlStrfromFile("C:/Users/kedhy/eclipse-workspace/templet_Creation/public/TLVCert.html");
		//System.out.println("Abcdef##$2##".replace("##$2##", "1234")); 
		String s = "191.1135530933791";
		s = s.substring(0, s.indexOf(".")+4);
		System.out.println("s:"+s);
	}

	
	private static String readFromInputStream(InputStream inputStream)
			  throws Exception {
			    StringBuilder resultStringBuilder = new StringBuilder();
			    try (BufferedReader br
			      = new BufferedReader(new InputStreamReader(inputStream))) {
			        String line;
			        while ((line = br.readLine()) != null) {
			            resultStringBuilder.append(line).append("\n");
			        }
			    }
			  return resultStringBuilder.toString();
			}

	
	public static void save2File(String path, String fileNm, String content) {
		String flsep = File.separator;
		Writer fw = null;
		
		 try {
			 System.out.println("path+flsep+fileNm:"+path+flsep+fileNm);
			 System.out.println("fileNm:"+fileNm);
				System.out.println("save2File() content:"+content);
			fw = new FileWriter(path+flsep+fileNm);
			fw.write(content);
			fw.close();
			System.out.println("end of  save2File ???????????");
		} catch (Exception e) {
			System.out.println("error :"+e.getMessage());
			e.printStackTrace();
		} 
		 System.out.println("end of  save2File >>>>>>>>");
	}

}


