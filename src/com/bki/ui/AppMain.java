package com.bki.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import com.bki.tlv.ipop.CustomerDtails;
import com.bki.tlv.ipop.TlvCrtIPOP;
import com.util.BKIFileUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import com.bki.tlv.cyv.elpt.CyVertElptIPOP;
import com.bki.tlv.cyv.elpt.CyVertElptTLVCert;

import javafx.scene.control.DatePicker;
import javax.swing.JComboBox;
import java.util.Formatter;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

/*
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
*/

//public class AppMain implements ActionListener {
public class AppMain {

	//private static final Logger log= LogManager.getLogger(AppMain.class);

	private JFrame frame;
	private JPanel p1_1;
	private JTextField custName;
	private JTextField custMobNo;
	private JTextField cusrEmailId;
	private JTextField textField; //  tank Dia
	private JTextField tankHeigt;
	private JTextField dishHt;
	//private JDatePanelImpl dcFrom;
	//private JDatePanelImpl dcTo;
	JTextArea custAddress;
	private DatePicker fromDate;
	private DatePicker toDate;
	// --- cust and tank dtls fields
	String custNm = null;
	String custAdd =null;
	String mobileNo= null;
	String emailId = null;
	String tankLoc;
	String tankId;
	String frDt;
	String toDt;

	String tankDia = null;
	String tankHeightStr = null;
	String dishHeight = null;
	String typeOftank = null;
	private JTextField tankLocation;
	private JTextField textField_1;
	private JTextField fromDt;
	private JTextField txfToDate;
	private com.bki.tlv.cyv.elpt.CyVertElptTLVCert cert ;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain window = new AppMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 687);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BKI Tank Volume certificate App");

		p1_1=new JPanel();  
		JPanel p2=new JPanel();  
		JPanel p3=new JPanel();

		JTabbedPane tbPane = new JTabbedPane();
		tbPane.setBounds(105, 105, 750, 550);
		tbPane.add("main",p1_1);  
		tbPane.add("CyVerDish",p2);
		//p2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		p2.setLayout(null);
		// Title label :---
		JLabel lblHeadingLabel = new JLabel("Cylindrical - Vertical - Dish End");
		lblHeadingLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblHeadingLabel.setSize(422, 30);
		lblHeadingLabel.setLocation(200, 25);
		p2.add(lblHeadingLabel);

		///----------------------



		// form Start 
		JLabel lblNewLabel = new JLabel("Customer Name* :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setSize(140, 20);
		lblNewLabel.setLocation(100, 114);
		p2.add(lblNewLabel);

		custName = new JTextField();
		custName.setFont(new Font("Arial", Font.PLAIN, 15));
		custName.setSize(230, 20);
		custName.setLocation(322, 114);
		p2.add(custName);
		//-----------------name end

		JLabel lbCustAdd = new JLabel("Customer Address* :");
		lbCustAdd.setFont(new Font("Arial", Font.PLAIN, 15));
		lbCustAdd.setSize(165, 20);
		lbCustAdd.setLocation(100, 149);
		p2.add(lbCustAdd);


		custAddress = new JTextArea();
		custAddress.setFont(new Font("Arial", Font.PLAIN, 15));
		custAddress.setSize(250, 100);
		custAddress.setLocation(322, 148);
		custAddress.setLineWrap(true);
		p2.add(custAddress);

		//-----------------address end


		JLabel lbCustMob = new JLabel("Mobile Number* :");
		lbCustMob.setFont(new Font("Arial", Font.PLAIN, 15));
		lbCustMob.setSize(134, 20);
		lbCustMob.setLocation(100, 270);
		p2.add(lbCustMob);

		custMobNo = new JTextField();
		custMobNo.setFont(new Font("Arial", Font.PLAIN, 15));
		custMobNo.setSize(230, 20);
		custMobNo.setLocation(322, 270);
		p2.add(custMobNo);

		//-----------------mobile end

		JLabel lbEmailId = new JLabel("Customer EmailId");
		p2.add(lbEmailId);

		cusrEmailId = new JTextField();
		p2.add(cusrEmailId);
		cusrEmailId.setColumns(10);

		JLabel lbTankDtls = new JLabel("Tank Details");
		lbTankDtls.setFont(new Font("Arial", Font.BOLD, 17));
		lbTankDtls.setBounds(101, 306, 126, 20);
		p2.add(lbTankDtls);

		JLabel lbTankDai = new JLabel("Tank Diameter* :");
		lbTankDai.setFont(new Font("Arial", Font.PLAIN, 15));
		lbTankDai.setBounds(100, 440, 126, 20);
		p2.add(lbTankDai);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(321, 440, 230, 20);
		p2.add(textField);

		JLabel lblCustDtls = new JLabel("Customer Details");
		lblCustDtls.setFont(new Font("Arial", Font.BOLD, 17));
		lblCustDtls.setBounds(100, 80, 140, 20);
		p2.add(lblCustDtls);

		JLabel lbTankHeight = new JLabel("Tank Height* :");
		lbTankHeight.setFont(new Font("Arial", Font.PLAIN, 15));
		lbTankHeight.setBounds(100, 473, 126, 20);
		p2.add(lbTankHeight);

		tankHeigt = new JTextField();
		tankHeigt.setFont(new Font("Arial", Font.PLAIN, 15));
		tankHeigt.setBounds(321, 473, 230, 20);
		p2.add(tankHeigt);

		JLabel lbDishHei = new JLabel("Dish Height* :");
		lbDishHei.setFont(new Font("Arial", Font.PLAIN, 15));
		lbDishHei.setBounds(100, 503, 126, 20);
		p2.add(lbDishHei);

		dishHt = new JTextField();
		dishHt.setFont(new Font("Arial", Font.PLAIN, 15));
		dishHt.setBounds(321, 503, 230, 20);
		p2.add(dishHt);

		JButton btnGC = new JButton("Gen Cert");
		btnGC.setFont(new Font("Arial", Font.BOLD, 12));
		btnGC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ----------certificate creation--------------------
				//log.debug("gen cert clicked");
				System.out.println("gen cert clicked");
				processCertGen(p2, typeOftank);
				System.out.println("DONE$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

			}
		});
		btnGC.setBounds(100, 555, 97, 21);
		p2.add(btnGC);

		JButton btnGS = new JButton("Gen Scale");
		btnGS.setFont(new Font("Arial", Font.BOLD, 12));
		btnGS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ----------scale creation--------------------

			}
		});
		btnGS.setBounds(275, 555, 97, 21);
		p2.add(btnGS);
		///---------------------------------------------------p2 end-----------
		tbPane.add("CyVerFlat",p3);
		//Add more here 
		frame.getContentPane().add(tbPane);
		frame.setVisible(true); 

		setMainTab_p1(p1_1, p2, p3);
		
		lblHeadingLabel.setSize(422, 30);
		lblHeadingLabel.setLocation(200, 25);
		p3.setLayout(null);
		
		JLabel lblCylindricalVertical = new JLabel("Cylindrical - Vertical - Flat End");
		lblCylindricalVertical.setFont(new Font("Arial", Font.PLAIN, 30));
		lblCylindricalVertical.setBounds(208, 34, 422, 30);
		p3.add(lblCylindricalVertical);
		
		JLabel lblCustDtls_1 = new JLabel("Customer Details");
		lblCustDtls_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblCustDtls_1.setBounds(108, 89, 140, 20);
		p3.add(lblCustDtls_1);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name* :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(108, 123, 140, 20);
		p3.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_2.setBounds(330, 123, 230, 20);
		p3.add(textField_2);
		
		JLabel lbCustAdd_1 = new JLabel("Customer Address* :");
		lbCustAdd_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lbCustAdd_1.setBounds(108, 158, 165, 20);
		p3.add(lbCustAdd_1);
		
		JTextArea custAddress_1 = new JTextArea();
		custAddress_1.setLineWrap(true);
		custAddress_1.setFont(new Font("Arial", Font.PLAIN, 15));
		custAddress_1.setBounds(330, 157, 250, 100);
		p3.add(custAddress_1);
		
		JLabel lbCustMob_1 = new JLabel("Mobile Number* :");
		lbCustMob_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lbCustMob_1.setBounds(108, 279, 134, 20);
		p3.add(lbCustMob_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_3.setBounds(330, 279, 230, 20);
		p3.add(textField_3);
		
		JLabel lbTankDtls_1 = new JLabel("Tank Details");
		lbTankDtls_1.setFont(new Font("Arial", Font.BOLD, 17));
		lbTankDtls_1.setBounds(109, 315, 126, 20);
		p3.add(lbTankDtls_1);
		
		JLabel lblTankLocation_1 = new JLabel("Tank Location :");
		lblTankLocation_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTankLocation_1.setBounds(108, 345, 134, 20);
		p3.add(lblTankLocation_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_4.setBounds(330, 346, 230, 20);
		p3.add(textField_4);
		
		JLabel lblTankId_1 = new JLabel("Tank Id* :");
		lblTankId_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTankId_1.setBounds(108, 375, 134, 20);
		p3.add(lblTankId_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_5.setBounds(330, 376, 230, 20);
		p3.add(textField_5);
		
		JLabel lblValidityDate_1 = new JLabel("Validity Date* :");
		lblValidityDate_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblValidityDate_1.setBounds(108, 419, 134, 20);
		p3.add(lblValidityDate_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_6.setBounds(330, 406, 106, 20);
		p3.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_7.setBounds(454, 406, 106, 20);
		p3.add(textField_7);
		
		JLabel lbTankDai_1 = new JLabel("Tank Diameter* :");
		lbTankDai_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lbTankDai_1.setBounds(108, 449, 126, 20);
		p3.add(lbTankDai_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_8.setBounds(329, 449, 230, 20);
		p3.add(textField_8);
		
		JLabel lbTankHeight_1 = new JLabel("Tank Height* :");
		lbTankHeight_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lbTankHeight_1.setBounds(108, 482, 126, 20);
		p3.add(lbTankHeight_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_9.setBounds(329, 482, 230, 20);
		p3.add(textField_9);
		
		JButton btnGC_1 = new JButton("Gen Cert");
		btnGC_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnGC_1.setBounds(108, 564, 97, 21);
		p3.add(btnGC_1);
		
		JButton btnGS_1 = new JButton("Gen Scale");
		btnGS_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnGS_1.setBounds(283, 564, 97, 21);
		p3.add(btnGS_1);
		lblCustDtls.setBounds(100, 80, 140, 20);
		lblNewLabel.setSize(140, 20);
		lblNewLabel.setLocation(100, 114);
		custName.setSize(230, 20);
		custName.setLocation(322, 114);

		JLabel lblTankLocation = new JLabel("Tank Location :");
		lblTankLocation.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTankLocation.setBounds(100, 336, 134, 20);
		p2.add(lblTankLocation);

		tankLocation = new JTextField();
		tankLocation.setFont(new Font("Arial", Font.PLAIN, 15));
		tankLocation.setBounds(322, 337, 230, 20);
		p2.add(tankLocation);

		JLabel lblTankId = new JLabel("Tank Id* :");
		lblTankId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTankId.setBounds(100, 366, 134, 20);
		p2.add(lblTankId);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setBounds(322, 367, 230, 20);
		p2.add(textField_1);

		JLabel lblValidityDate = new JLabel("Validity Date* :");
		lblValidityDate.setFont(new Font("Arial", Font.PLAIN, 15));
		lblValidityDate.setBounds(100, 410, 134, 20);
		p2.add(lblValidityDate);

		fromDt = new JTextField();
		fromDt.setFont(new Font("Arial", Font.PLAIN, 15));
		fromDt.setBounds(322, 397, 106, 20);
		p2.add(fromDt);

		txfToDate = new JTextField();
		txfToDate.setFont(new Font("Arial", Font.PLAIN, 15));
		txfToDate.setBounds(446, 397, 106, 20);
		p2.add(txfToDate);
		// Date picker 
		//UtilDateModel model = new UtilDateModel();
		//DateModel<UtilDateModel> dtm = new DateModel<UtilDateModel>();
		//JDatePanelImpl datePanel = new JDatePanelImpl(UtilDateModel, Text.proprties);
		//JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		//fromDate = new DatePicker(); 


	}



	public void setMainTab_p1(JPanel p1, JPanel p2, JPanel p3) {

		ButtonGroup bg=new ButtonGroup();
		JRadioButton rbCyVerDe_1 = new JRadioButton("Cylendrical-Verical-dishend");
		rbCyVerDe_1.setBounds(130, 99, 200, 21);
		rbCyVerDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeOftank= "CYVERDE";
				System.out.println("cylindrical vertical tank with dish end selected:"+ typeOftank);
				//p2.show();
				p2.setVisible(true);
				p2.repaint();
				//p1_1.setVisible(false);
			}
		});
		p1_1.setLayout(null);
		rbCyVerDe_1.setSelected(true);
		bg.add(rbCyVerDe_1);
		p1_1.add(rbCyVerDe_1);

		JLabel lblTankSelectionSection = new JLabel("Tank selection section");
		lblTankSelectionSection.setBounds(120, 67, 180, 31);
		lblTankSelectionSection.setFont(new Font("Arial", Font.BOLD, 15));
		lblTankSelectionSection.setBorder(BorderFactory.createEmptyBorder(5, 5, 8, 8));
		p1.add(lblTankSelectionSection);
		p1.setVisible(true);
		JRadioButton rbCyVerFe = new JRadioButton("Cylendrical-Verical-Flatend");
		rbCyVerFe.setBounds(130, 123, 200, 21);
		bg.add(rbCyVerFe);
		p1_1.add(rbCyVerFe);

		JRadioButton rbCyHorDe_1 = new JRadioButton("Cylendrical-Horizontal-dishend");
		rbCyHorDe_1.setSelected(false);
		rbCyHorDe_1.setBounds(130, 152, 200, 21);
		bg.add(rbCyHorDe_1);
		p1_1.add(rbCyHorDe_1);
		
		JRadioButton rdbtnCylendricalhorizontalflatend = new JRadioButton("Cylendrical-Horizontal-Flatend");
		rdbtnCylendricalhorizontalflatend.setBounds(130, 176, 200, 21);
		bg.add(rdbtnCylendricalhorizontalflatend);
		p1_1.add(rdbtnCylendricalhorizontalflatend);


	}


	public JPanel getP1() {
		return p1_1;
	}

	public void actionPerformed(ActionEvent e)
	{

	}


	public void processCertGen(JPanel p2, String tankType) {
		TlvCrtIPOP iopo = new TlvCrtIPOP(); 
		CustomerDtails custDtl = new CustomerDtails();
		com.bki.tlv.cyv.elpt.CyVertElptIPOP  elptIpop = new com.bki.tlv.cyv.elpt.CyVertElptIPOP();
		iopo.setCustDtls(custDtl);
		iopo.setElpt(elptIpop);
		//String custNm = null;
		//String custAdd  = null;
		//Component[] components = p2.getComponents();
		//		 for(Component com : components) {
		// if(com instanceof JTextField && "custName".equalsIgnoreCase().getName())

		//}

		//----- Cust details----
		custNm = custName.getText();
		System.out.println("custNm:"+custNm);
		custDtl.setCustomerName(custNm);
		custAdd  = custAddress.getText();
		custDtl.setCustAdd(custAdd);
		System.out.println("custAdd:"+custAdd);
		mobileNo = custMobNo.getText();
		custDtl.setMobile(mobileNo);
		System.out.println("mobileNo:"+mobileNo);
		emailId = cusrEmailId.getText();
		custDtl.setEmailId(emailId);
		System.out.println("emailId:"+emailId);
		////--------------------

		////---Tank Details------
		// 
		/*
		  String tankLoc;
	String tankId;
	String frDt;
	String toDt; 
		 * */
		tankLoc = tankLocation.getText();
		
		iopo.setTankLocation(tankLoc);
		tankId = textField_1.getText();
		iopo.setTankId(tankId);
		frDt = fromDt.getText();
		iopo.setFromDate(frDt);
		toDt = txfToDate.getText();
		iopo.setToDate(toDt);

		// Tank Dia
		tankDia = textField.getText();
		double tank_Dia = Double.parseDouble(tankDia);
		elptIpop.setD(tank_Dia);
		// Tank Height
		tankHeightStr = tankHeigt.getText();
		double tank_Height = Double.parseDouble(tankHeightStr);
		elptIpop.setH(tank_Height);
		dishHeight = dishHt.getText();
		double dish_Height = Double.parseDouble(dishHeight);
		elptIpop.setA(dish_Height);


		System.out.println("1111tankLoc:"+tankLoc+",tankId:"+tankId+",mobileNo:"+mobileNo);
		System.out.println("222custNm:"+custNm+",custAdd:"+custAdd+",frDt:"+frDt+",toDt:"+toDt);
		System.out.println("333tankDia:"+tankDia+",tankHeigt:"+tankHeightStr+",dishHeight:"+dishHeight);
		if("CYVERDE".equalsIgnoreCase(typeOftank)){
			cert = new com.bki.tlv.cyv.elpt.CyVertElptTLVCert();
		}else if("CYVERFE".equalsIgnoreCase(typeOftank)){

		}
		double capacity = cert.measureCapacity(elptIpop);
		iopo.setCapacity(capacity);
		System.out.println("capacity:"+capacity);

		LinkedHashMap<Integer,String> VolData  = cert.genVolDataCyVDE(elptIpop);
		iopo.setVolData(VolData);
		System.out.println("VolData:"+VolData);
		String htmlcontent = makeHtmltbl(iopo, typeOftank);
		
		System.out.println("htmlcontent:"+htmlcontent);
		String fileNm = custNm+"_"+frDt+".html";
		fileNm = fileNm.replaceAll(" ", "_");
		BKIFileUtil.save2File("C:\\Users\\kedhy\\OneDrive\\BKI_TLV_Crtf-APP_OOD\\ZoutPut\\", fileNm, htmlcontent);

	}

	public String makeHtmltbl(TlvCrtIPOP iopo, String typeOftank) {
		//List<String> dtlLst = new LinkedList<String>();
		ArrayList<String> dtlLst = new ArrayList<String>();
		com.bki.tlv.cyv.elpt.CyVertElptIPOP elpt = null; 
		String htmlFlContent = BKIFileUtil.getHTML_Tmplt_contentCLBFlContent();
		CustomerDtails custDtls = iopo.getCustDtls();
		String custNm = custDtls.getCustomerName();
		//dtlLst.add(custNm); // htmltitle
		System.out.println("htmlFlContent lenth:"+htmlFlContent.length());
		htmlFlContent = htmlFlContent.replace("##$1##", custNm);
		System.out.println("666666custNm:"+custNm);
		// today date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		String todayDt = dtf.format(now);
		//dtlLst.add(todayDt); // date
		htmlFlContent = htmlFlContent.replace("##$2##", todayDt);
		dtlLst.add(custNm); // in customer details table
		htmlFlContent = htmlFlContent.replace("##$3##", custNm);
		String custAdd = custDtls.getCustAdd();
		//dtlLst.add(custAdd);
		htmlFlContent = htmlFlContent.replace("##$4##", custAdd);
		String mobNo = custDtls.getMobile();
		//dtlLst.add(mobNo);
		htmlFlContent = htmlFlContent.replace("##$5##", mobNo);
		/// tank dtls

		String tankLoc = iopo.getTankLocation();
		String tankId = iopo.getTankId();
		tankLoc = tankLoc != null && ! tankLoc.isEmpty() && tankId!= null ? tankLoc +"-"+tankId 
					: (tankLoc == null && tankId != null ? tankId : "123");
		//dtlLst.add(tankLoc);
		htmlFlContent = htmlFlContent.replace("##$6##", tankLoc);
		String tankType = iopo.getTankType();
		System.out.println("----typeOftank--:"+typeOftank);
		//dtlLst.add(typeOftank);
		String tot = "CYVERDE".equalsIgnoreCase(typeOftank) ?
						"Cylindrical-Vertical-Dish End"
						: "CYVERFE".equalsIgnoreCase(typeOftank) ? "Cylindrical-Vertical-Flat End": null; 
		htmlFlContent = htmlFlContent.replace("##$7##", tot);
		// tank dimension
		String dimension = "";
		if("CYVERDE".equalsIgnoreCase(typeOftank)){
			elpt = iopo.getElpt();
			dimension = "Tank Diameter:"+elpt.getD() +",Tank Height:"+elpt.getH()+", Dish Height:"+elpt.getA();

		}else if("CYVERFE".equalsIgnoreCase(typeOftank)){

		}

		//dtlLst.add(dimension);
		htmlFlContent = htmlFlContent.replace("##$8##", dimension);
		//capacity
		String capacity = iopo.getCapacity()+"";
		capacity = capacity.substring(0, capacity.indexOf(".")+4);
		//dtlLst.add(capacity);
		htmlFlContent = htmlFlContent.replace("##$9##", capacity);

		DateTimeFormatter dtf_ = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  
		LocalDateTime now_ = LocalDateTime.now();  
		String todayDt_1 = dtf_.format(now_);	
		iopo.setFromDate(todayDt_1);
		String calDt = iopo.getFromDate();
		//dtlLst.add(calDt);
		htmlFlContent = htmlFlContent.replace("##$10##", calDt);
		String dueDt = iopo.getToDate();
		dtlLst.add(dueDt);
		htmlFlContent = htmlFlContent.replace("##$11##", dueDt);
		double tankH = elpt.getH();
		double tankDh = elpt.getA();
		double totHeight = tankH+tankDh;
		double rows = Math.round(totHeight) % 2d ==0d ? totHeight /2d:  (totHeight +1) /2d;
		System.out.println("rows:"+rows);
		
		com.bki.tlv.cyv.elpt.CyVertElptTLVCert cert = new CyVertElptTLVCert();
		
		LinkedHashMap<Double, String> volData = cert.genVolData_d(elpt);
		int vdSize = volData.size();
		System.out.println("vdSize:"+vdSize);
		
		StringBuilder vdContent = new StringBuilder();
		double d = 1d;
		//for(double d = 1 , j =2 ; d<=vdSize; d++, j ++) {
		while(d<=vdSize) {
			double j = d+1d;
			if(d<=vdSize-1) {
				String  sd = d+"".replace(".00", "");
				String sj = j+"".replace(".00", "");
				String pvcl1 = (String)volData.get(d);
				pvcl1 = pvcl1.substring(0, pvcl1.indexOf(".")+4);
				String pvcl2 = (String)volData.get(j);
				pvcl2 = pvcl2.substring(0, pvcl2.indexOf(".")+4);
				vdContent.append("<tr><td>"+sd+"</td><td>"+pvcl1+"</td><td>"+sj+"</td><td>"+pvcl2+"</td></tr>");
				System.out.println("d:"+d+", j:"+j);
			}else if(d==vdSize){
				String pvcl1 = (String)volData.get(d);
				pvcl1 = pvcl1.substring(0, pvcl1.indexOf(".")+4);
				vdContent.append("<tr><td>"+d+"</td><td>"+pvcl1+"</td><td></td><td></td></tr>");
			}
			//if(j == vdSize-1) {
			if(d== vdSize) {
				break;
			}else {
				d = d+2;
			}
		}
		//dtlLst.add(vdContent.toString());
		
		System.out.println("htmlFlContent:"+htmlFlContent);
		System.out.println("9999-dtlLst:"+dtlLst);
		
		//htmlFlContent = String.format(htmlFlContent,dtlLst);
		htmlFlContent = htmlFlContent.replace("##$##", vdContent.toString());
		System.out.println("5555555htmlFlContent:-"+htmlFlContent);
		return htmlFlContent;
	}
}
//PDF generation
//https://templated.io/blog/how-to-convert-html-to-pdf-using-apache-pdfbox/ 

//https://www.ulfdittmer.com/view?PdfboxTable  ---------------------
//#######################################
//https://github.com/eduardohl/Paginated-PDFBox-Table-Sample/blob/master/src/pdftablesample/PDFTableGenerator.java