package com.bki.tlv.tbl.gen;

import java.io.IOException;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;
import javax.print.attribute.*;
import javax.print.*;
import javax.swing.*;

import java.awt.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.*;

public class TableCreater {
	
	
	
	public static void main(String[] args) {
	    Object[] column = {"One", "Two"};
	    Object[][] data = {{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},{1, 2}, {3, 4}, {5, 6},
	    		
	    		};

	    JTable toDoTable = new JTable(data, column);
	    JScrollPane jpane = new JScrollPane(toDoTable);
	    JPanel panel = new JPanel();
	    JFrame frame = new JFrame();
	    panel.add(jpane);
	    frame.add(new JScrollPane(panel));
	    frame.setVisible(true);
	    JButton btnPrint = new JButton("PRINT");
	    panel.add(btnPrint);
	  //btnPrint.setBounds(650, 650, 70, 30);

	  //btnPrint.setSize(90, 30);
	  btnPrint.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.blue));
	  //btnPrint.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	  //btnPrint.setBackground(Color.blue);

	  btnPrint.setMaximumSize(new Dimension(70,30));
	  btnPrint.setAlignmentX(Component.CENTER_ALIGNMENT);

	  btnPrint.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {

	  final PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
	  attributes.add(DialogTypeSelection.NATIVE);
	  PrinterJob printJob = PrinterJob.getPrinterJob();
	  printJob.printDialog(attributes);


	  


	  //String defaultPrinter = PrintServiceLookup.lookupDefaultPrintService().getName();
	  //System.out.println("Default printer: " + defaultPrinter);

	  PrintService service = PrintServiceLookup.lookupDefaultPrintService();

	  FileInputStream in = null;
	  try {
	  in = new FileInputStream(new File("C:\\Users\\kedhy\\eclipse-workspace\\JAAvaJTAbleInPdf.pdf"));
	  //System.out.println(in);
	  } catch (FileNotFoundException e2) {
	  // TODO Auto-generated catch block
	  e2.printStackTrace();
	  }

	  PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
	  pras.add(new Copies(1));

	  DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
	  Doc doc = new SimpleDoc(in, flavor, null);

	  DocPrintJob job = service.createPrintJob();
	  //System.out.println(job);
	  PrintJobWatcher pjw = new PrintJobWatcher(job);

	  try {
	  job.print(doc, pras);
	  } catch (PrintException e1) {
	  // TODO Auto-generated catch block
	  e1.printStackTrace();
	  }
	  pjw.waitForDone();

	  try {
	  in.close();
	  } catch (IOException e1) {
	  // TODO Auto-generated catch block
	  e1.printStackTrace();
	  }

	  // send FF to eject the page
	  InputStream ff = new ByteArrayInputStream("\f".getBytes());
	  Doc docff = new SimpleDoc(ff, flavor, null);
	  DocPrintJob jobff = service.createPrintJob();
	  pjw = new PrintJobWatcher(jobff);
	  try {
	  jobff.print(docff, null);
	  System.out.println("did I print "+jobff);
	  } catch (PrintException e1) {
	  // TODO Auto-generated catch block
	  e1.printStackTrace();
	  }
	  pjw.waitForDone();
	  }
	  class PrintJobWatcher {
	  boolean done = false;


	  PrintJobWatcher(DocPrintJob job) {
	  job.addPrintJobListener(new PrintJobListener() {
		  @Override
			public void printDataTransferCompleted(PrintJobEvent pje) {
				// TODO Auto-generated method stub
				
			}
	  public void printJobCanceled(PrintJobEvent pje) {
	  allDone();
	  }
	  public void printJobCompleted(PrintJobEvent pje) {
	  allDone();
	  }
	  public void printJobFailed(PrintJobEvent pje) {
	  allDone();
	  }
	  public void printJobNoMoreEvents(PrintJobEvent pje) {
	  allDone();
	  }
	  void allDone() {
	  synchronized (PrintJobWatcher.this) {
	  done = true;
	  System.out.println("Printing done ...");
	  PrintJobWatcher.this.notify();
	  }
	  }
	@Override
	public void printJobRequiresAttention(PrintJobEvent pje) {
		// TODO Auto-generated method stub
		
	}
	  });
	  }
	  public synchronized void waitForDone() {
	  try {
	  while (!done) {
	  wait();
	  }
	  } catch (InterruptedException e) {
	  }
	  }
	  }
	  });
	  }
}




// print on printer
//https://www.codeproject.com/Questions/881060/In-Java-Print-to-a-Printer