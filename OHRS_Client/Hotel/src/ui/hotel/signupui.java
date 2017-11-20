package ui.hotel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import controller.view_controller_hotelSignup;
import logic.Impl.monitorbl;
import vo.HotelInforvo;

/*
 * @author hzp
 * @version 1.0.20161118
 */
public class signupui extends JPanel{
	
	private view_controller_hotelSignup vch = new view_controller_hotelSignup();
	
	private final int name = 0;
	private final int password = 1;
	private final int confirmpassword = 2;
	private final int telephone = 3;
	private final int address = 4;
	private final int introduction = 5;
	private final int tradearea = 6;
	private final int level = 7;
	/*
	 * 常量值
	 * 用于规定输入框和选择框的大小
	 * 也使用于布局中status的位置确定
	 */
	private final int textfield_width = 280;
	private final int textfield_height = 35;
	private final int label_width=120;
	private final int label_height=30;
	private final int button_width=140;
	private final int button_height=50;
	/*
	 * labels
	 * kind是标识信息类别
	 * status是检测输入后反馈信息
	 */
	private JLabel kind[] = new JLabel[8];
	private JLabel statusHotel[] = new JLabel[6];
	
	//输入框和选择框
	private static JTextField nameT = new JTextField("");
	private static JTextField telephoneT = new JTextField("");
	private static JTextField addressT = new JTextField("");
	private static JTextArea introductionT = new JTextArea("");
	private static JScrollPane introductionSP = new JScrollPane(introductionT);
	
	private static JPasswordField passwordT = new JPasswordField(15);
	private static JPasswordField confirmpasswordT = new JPasswordField(15);
	
	private static JComboBox<String> tradeareaC = new JComboBox<String>();
	private static JComboBox<String> levelC = new JComboBox<String>();
	
	//buttons
	private JButton backb;
	private JButton nextb;
	
	private final int LD = 0;
	private final int LS = 1;
	private final int SD = 2;
	private final int SS = 3;
	private final int family = 4;
	
	private final static int numOfRoomKind = 5;
	private final int numOfRoomInfor = 2;
	
	private JLabel kindOfRoom[] = new JLabel[numOfRoomKind];
	private JLabel kindOfInfor[] = new JLabel[numOfRoomInfor];
	private JLabel statusRoom[] = new JLabel[numOfRoomKind];
	
	private static JTextField numOfRoom[] = new JTextField[numOfRoomKind];
	private static JTextField priceOfRoom[] = new JTextField[numOfRoomKind];

	private JButton submitb = new JButton("提交注册");
	
	private Image setting;
	
	private static HotelInforvo infor = new HotelInforvo();
	
	public signupui(int i){
		images();
		if(i==1)
			initui1();
		else
			initui2();
	}
	
	public void paintComponent(Graphics g) {  
		 super.paintComponent(g);   
		 g.drawImage(setting, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  
	
	private void initui1(){
		Labels1();
		TextFields1();
		Buttons1();
		ComboBoxs();
		TextAreas();
		
		//设置界面中一些常量值
		final int frame_width=700;
		final int frame_height=600;
		final int label_gap=45;	
		final int label_textfield_gap=115;
		
		//创建JPanel，并添加标识、文本框、选择框、按钮
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(frame_width,frame_height);
		
		// 为方便修改，x和y保存jpanel的大小
		int x=frame_width/8;
		int y=90;
		
		//标识的添加和排版
		int labelg=label_gap;

		for(int i=0;i<kind.length;i++)
			this.add(kind[i]);
		kind[name].setLocation(x, y+labelg*0);
		kind[password].setLocation(x, y+labelg*1);
		kind[confirmpassword].setLocation(x, y+labelg*2);
		kind[tradearea].setLocation(x, y+labelg*3);
		kind[level].setLocation(x, y+labelg*4);
		kind[telephone].setLocation(x, y+labelg*5);
		kind[address].setLocation(x, y+labelg*6);
		kind[introduction].setLocation(x, y+labelg*7);
		
		//文本框的添加和排版
		int textw=textfield_width;
		int texth=textfield_height;
		int ltg=label_textfield_gap;
		
		this.add(nameT);
		this.add(passwordT);
		this.add(confirmpasswordT);
		this.add(tradeareaC);
		this.add(levelC);
		this.add(telephoneT);
		this.add(addressT);
		this.add(introductionSP);
		nameT.setLocation(x+ltg, y+labelg*0);
		passwordT.setLocation(x+ltg, y+labelg*1);
		confirmpasswordT.setLocation(x+ltg, y+labelg*2);
		tradeareaC.setLocation(x+ltg, y+labelg*3);
		levelC.setLocation(x+ltg, y+labelg*4);
		telephoneT.setLocation(x+ltg, y+labelg*5);
		addressT.setLocation(x+ltg, y+labelg*6);
		introductionSP.setLocation(x+ltg, y+labelg*7);	
		
		//标识输入是否正确的添加和排版
		//不添加商圈和星级的判断标识
		for(int i=0;i<statusHotel.length;i++)
			this.add(statusHotel[i]);
		statusHotel[name].setLocation(x+ltg+textw, y+labelg*0);
		statusHotel[password].setLocation(x+ltg+textw, y+labelg*1);
		statusHotel[confirmpassword].setLocation(x+ltg+textw, y+labelg*2);
		statusHotel[telephone].setLocation(x+ltg+textw, y+labelg*5);
		statusHotel[address].setLocation(x+ltg+textw, y+labelg*6);
		statusHotel[introduction].setLocation(x+ltg+textw, y+labelg*7);
		
		//按钮的添加
		this.add(backb);
		this.add(nextb);
		backb.setLocation(x+ltg+textw, y+labelg*6+texth*4+10);
		nextb.setLocation(x+ltg, y+labelg*6+texth*4+10);
		
	}
	
	private void images(){
		setting = Toolkit.getDefaultToolkit().getImage("image/HSignupS4.jpg");
	}
	
	private void Labels1(){
		for(int i=0;i<kind.length;i++){
			kind[i]=new JLabel("",JLabel.RIGHT);
			kind[i].setSize(label_width, label_height);
			kind[i].setFont(new Font("wingding",1,20));
			kind[i].setForeground(Color.black);
		}
		for(int i=0;i<statusHotel.length;i++){
			statusHotel[i]=new JLabel("");
			statusHotel[i].setSize(label_width*2, label_height);
			statusHotel[i].setFont(new Font("华文楷体",1,15));
			statusHotel[i].setForeground(Color.red);
		}
		kind[name].setText("酒店名称：");
		kind[password].setText("密码：");
		kind[confirmpassword].setText("确认密码：");
		kind[tradearea].setText("商圈：");
		kind[level].setText("星级：");
		kind[telephone].setText("联系电话：");
		kind[address].setText("详细地址：");
		kind[introduction].setText("酒店描述：");

	}
	
	private void TextFields1(){
		Font textFont = new Font("华文楷体",1, 18);
		Color focus = Color.black;
		Color losefocus = Color.blue;
		
		//初始化名称、密码、确认密码、地址、介绍输入框
		nameT.setSize(textfield_width, textfield_height);
		passwordT.setSize(textfield_width, textfield_height);
		confirmpasswordT.setSize(textfield_width, textfield_height);
		telephoneT.setSize(textfield_width, textfield_height);
		addressT.setSize(textfield_width, textfield_height);
		introductionT.setSize(textfield_width, textfield_height);
		nameT.setOpaque(false);
		nameT.setFont(textFont);
		nameT.setBorder(new LineBorder(Color.gray));
		passwordT.setOpaque(false);
		passwordT.setFont(textFont);
		passwordT.setBorder(new LineBorder(Color.gray));
		confirmpasswordT.setOpaque(false);
		confirmpasswordT.setFont(textFont);
		confirmpasswordT.setBorder(new LineBorder(Color.gray));
		telephoneT.setOpaque(false);
		telephoneT.setFont(textFont);
		telephoneT.setBorder(new LineBorder(Color.gray));
		addressT.setOpaque(false);
		addressT.setFont(textFont);
		addressT.setBorder(new LineBorder(Color.gray));
		
		//对选择的反馈
		nameT.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				nameT.setForeground(focus);
				nameT.setBorder(new LineBorder(new Color(0, 191, 255)));
				nameT.setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				nameT.setForeground(losefocus);
				nameT.setBorder(new LineBorder(Color.gray));
				nameT.setOpaque(false);
			}  
		});
		passwordT.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				passwordT.setForeground(focus);
				passwordT.setBorder(new LineBorder(new Color(0, 191, 255)));
				passwordT.setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				passwordT.setForeground(losefocus);
				passwordT.setBorder(new LineBorder(Color.gray));
				passwordT.setOpaque(false);
			}  
		});
		confirmpasswordT.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				confirmpasswordT.setForeground(focus);
				confirmpasswordT.setBorder(new LineBorder(new Color(0, 191, 255)));
				confirmpasswordT.setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				confirmpasswordT.setForeground(losefocus);
				confirmpasswordT.setBorder(new LineBorder(Color.gray));
				confirmpasswordT.setOpaque(false);
			}  
		});
		telephoneT.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				telephoneT.setForeground(focus);
				telephoneT.setBorder(new LineBorder(new Color(0, 191, 255)));
				telephoneT.setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				telephoneT.setForeground(losefocus);
				telephoneT.setBorder(new LineBorder(Color.gray));
				telephoneT.setOpaque(false);
			}  
		});
		addressT.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				addressT.setForeground(focus);
				addressT.setBorder(new LineBorder(new Color(0, 191, 255)));
				addressT.setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				addressT.setForeground(losefocus);
				addressT.setBorder(new LineBorder(Color.gray));
				addressT.setOpaque(false);
			}  
		});
		
		//添加对输入的控制
		nameT.addKeyListener(new InputOnlyEnglishOrChinese());
		passwordT.addKeyListener(new InputNoSpace());
		confirmpasswordT.addKeyListener(new InputNoSpace());
		telephoneT.addKeyListener(new InputOnlyNum());
		addressT.addKeyListener(new InputNoSpace());
	}
	
	private void ComboBoxs(){
		
		//初始化商圈、星级选择框
		String tradearea[]={"  南京","  上海","  北京","  香港"};
		tradeareaC=new JComboBox<String>(tradearea);
		tradeareaC.setFont(new Font("华文楷体",1,15));
		tradeareaC.setSize(textfield_width, textfield_height);
		
		
		String level[]={"    1","    2","    3","    4","    5"};
		levelC=new JComboBox<String>(level);	
		levelC.setFont(new Font("华文楷体",1,15));	
		levelC.setSize(textfield_width, textfield_height);
	}
	
	private void TextAreas(){
		Font areaFont = new Font("华文楷体",1, 18);
		Color focus = Color.black;
		Color losefocus = Color.blue;
		//初始化简介输入框
		introductionSP.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		introductionSP.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		introductionSP.setOpaque(false);
		introductionSP.getViewport().setOpaque(false);
		introductionT.setFont(areaFont);
		introductionT.setWrapStyleWord(true);  
		introductionT.setLineWrap(true);
		introductionSP.setSize(textfield_width, (int)(textfield_height*2.5));
		introductionT.setSize(textfield_width, (int)(textfield_height*2.5));
		
		introductionT.setOpaque(false);
		introductionT.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				introductionT.setForeground(focus);
				introductionT.setBorder(new LineBorder(new Color(0, 191, 255)));
				introductionT.setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				introductionT.setForeground(losefocus);
				introductionT.setBorder(new LineBorder(Color.gray));
				introductionSP.getViewport().setOpaque(false);
				introductionT.setOpaque(false);
			}  
		});
		
		introductionT.addKeyListener(new InputNoSpace());
	}
	
	
	private void Buttons1(){
		
		backb = new JButton("返回");
		backb.setFont(new Font("华文新魏",1,20));
		backb.setForeground(Color.white);
		backb.setBackground(new Color(0, 191, 255));
		backb.setBorderPainted(false);
		backb.setFocusPainted(false);
		backb.setSize( button_width, button_height);
		backb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backb.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				backb.setBackground(new Color(0, 220, 255));   
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backb.setBackground(new Color(0, 191, 255));  
			}
		});
		backb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vch.hotelSignupToLogin();
				clear();
			}
		});
		
		nextb = new JButton("填写客房信息");
		nextb.setFont(new Font("华文新魏",1,20));	
		nextb.setForeground(Color.white);
		nextb.setBackground(new Color(0, 191, 255));
		nextb.setBorderPainted(false);
		nextb.setFocusPainted(false);
		nextb.setSize(button_width*3/2, button_height);
		nextb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextb.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				nextb.setBackground(new Color(0, 220, 255));   
			}

			@Override
			public void mouseExited(MouseEvent e) {
				nextb.setBackground(new Color(0, 191, 255));  
			}
		});
		nextb.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 boolean checkresultAll[] = new boolean[statusHotel.length];
				 boolean issuccessful = true;
				 for(int i=0;i<checkresultAll.length;i++)
					 checkresultAll[i] = false;
				
				 //对密码和第二个密码的检测
				 String temp="", tempc="";
				 temp = new String(passwordT.getPassword());
				 tempc = new String(confirmpasswordT.getPassword());

				 if(temp.length()==0){
					 statusHotel[password].setText("请输入密码");
					 checkresultAll[password] = false;
				 }
				 else{
					 statusHotel[password].setText("");
					 checkresultAll[password] = true;
				 }
				 if(!temp.equals(tempc)){
					 statusHotel[confirmpassword].setText("两次密码不同，请重新输入");
					 checkresultAll[confirmpassword] = false;
				 }
				 else{
					 statusHotel[confirmpassword].setText("");
					 checkresultAll[confirmpassword] = true;
				 }
				 //对 名称 输入的检测
				 int lengthOfName = 0;
				 String tempName = nameT.getText();
				 for(int i=0;i<tempName.length();i++){
					 if(tempName.charAt(i)>= '\u4E00' && tempName.charAt(i)<='\u9FA5')
						 lengthOfName += 2;
					 else
						 lengthOfName++;
				 }
				 if(lengthOfName>15){
					 statusHotel[name].setText("请勿超过15个字母或7个汉字！");
					 checkresultAll[name] = false;
				 }
				 else if(lengthOfName==0){
					 statusHotel[name].setText("请输入酒店名称！");
					 checkresultAll[name] = false;
				 }
				 else{
					 statusHotel[name].setText("");
					 checkresultAll[name] = true;
				 }
				 //对 电话 输入的检测
				 if(telephoneT.getText().length()!=11){
					 statusHotel[telephone].setText("请输入11位电话号码！");
					 checkresultAll[telephone] = false;
				 }
				 else{
					 statusHotel[telephone].setText("");
					 checkresultAll[telephone] = true;
				 }
				 //对 地址输入 的检测
				 if(addressT.getText().length()==0){
					 statusHotel[address].setText("请输入地址！");
					 checkresultAll[address] = false;
				 }
				 else{
					 statusHotel[address].setText("");
					 checkresultAll[address] = true;	 
				 }
				 //对 酒店介绍 输入的检测
				 if(introductionT.getText().length()==0){
					 statusHotel[introduction].setText("请输入酒店介绍！");
					 checkresultAll[introduction] = false;
				 }
				 else{
					 statusHotel[introduction].setText("");
					 checkresultAll[introduction] = true;	 
				 }
				 for(boolean tempboolean : checkresultAll){
					 if(!tempboolean){
						 issuccessful = false;
						 break;
					 }
					 issuccessful = true;
				 }
				 if(issuccessful){
					 infor.setname(nameT.getText());
					 infor.settradearea(tradeareaC.getSelectedItem().toString());
					 infor.setlevel(levelC.getSelectedItem().toString());
					 infor.settelephone(telephoneT.getText());
					 infor.setaddress(addressT.getText());
					 infor.setintroduction(introductionT.getText());
					 vch.signupHotelToRoom();
				 }
			 }
		}
		);
		
	}
	
	private void initui2(){
		Labels2();
		TextFields2();
		Buttons2();
		
		//设置界面中一些常量值
		final int frame_width=700;
		final int frame_height=600;
		final int label_gap=50;	
		final int label_textfield_gap=130;
		
		//创建JPanel，并添加标识、文本框、选择框、按钮
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(frame_width,frame_height);
		
		// 为方便修改，x和y保存jpanel的大小
		int x=frame_width/8;
		int y=100;
		
		//标识的添加和排版
		int labelg=label_gap;
		int textw=textfield_width/2+10;
		int ltg=label_textfield_gap;
		
		for(int i=0;i<kindOfRoom.length;i++){
			this.add(kindOfRoom[i]);
			kindOfRoom[i].setLocation(x, y+labelg*(i+1));
		}
		for(int i=0;i<kindOfInfor.length;i++){
			this.add(kindOfInfor[i]);
			kindOfInfor[i].setLocation(x+ltg+textw*i, y);
		}
		
		//文本框的添加和排版
		for(int i=0;i<numOfRoom.length;i++){
			this.add(numOfRoom[i]);
			numOfRoom[i].setLocation(x+ltg, y+labelg*(i+1));
		}
		for(int i=0;i<priceOfRoom.length;i++){
			this.add(priceOfRoom[i]);
			priceOfRoom[i].setLocation(x+ltg+textw, y+labelg*(i+1));
		}
		
		//状态标识的添加和排版
		for(int i=0;i<statusRoom.length;i++){
			this.add(statusRoom[i]);
			statusRoom[i].setLocation(x+ltg+textw*2, y+labelg*(i+1));
		}
		
		//按钮的添加和排版
		this.add(backb);
		this.add(submitb);
		backb.setLocation(x+ltg+(int)(textw*1.5), y+labelg*(numOfRoomKind+1));
		submitb.setLocation(x+ltg, y+labelg*(numOfRoomKind+1));
		
	}
	
	private void Labels2(){
		
		for(int i=0;i<kindOfRoom.length;i++){
			kindOfRoom[i]=new JLabel("",JLabel.CENTER);
			kindOfRoom[i].setSize(label_width, label_height);
			kindOfRoom[i].setFont(new Font("wingding",1,20));
			kindOfRoom[i].setForeground(Color.black);
		}
		kindOfRoom[LD].setText("豪华双人间:");
		kindOfRoom[LS].setText("豪华单人间:");
		kindOfRoom[SD].setText("标准双人间:");
		kindOfRoom[SS].setText("标准单人间:");
		kindOfRoom[family].setText("家庭间:");
		
		for(int i=0;i<kindOfInfor.length;i++){
			kindOfInfor[i]=new JLabel("",JLabel.CENTER);
			kindOfInfor[i].setSize(textfield_width/2, textfield_height);
			kindOfInfor[i].setFont(new Font("wingding",1,20));
			kindOfInfor[i].setForeground(Color.black);
		}
		kindOfInfor[0].setText("价格");
		kindOfInfor[1].setText("数量");
		
		for(int i=0;i<statusRoom.length;i++){
			statusRoom[i]=new JLabel("");
			statusRoom[i].setSize(label_width*2, label_height);
			statusRoom[i].setFont(new Font("华文楷体",1,15));
			statusRoom[i].setForeground(Color.red);
		}
	}
	
	private void TextFields2(){
		Font textFont = new Font("华文楷体",1, 18);
		Color focus = Color.black;
		Color losefocus = Color.blue;
		
		for(int i=0;i<numOfRoomKind;i++){	
			numOfRoom[i] = new JTextField("");
			numOfRoom[i].setFont(textFont);
			numOfRoom[i].setSize(textfield_width/2, textfield_height);
			numOfRoom[i].setHorizontalAlignment(JTextField.CENTER);
			numOfRoom[i].addKeyListener(new InputOnlyNum());
			numOfRoom[i].setOpaque(false);
			numOfRoom[i].setBorder(new LineBorder(Color.gray));

			priceOfRoom[i] = new JTextField("");
			priceOfRoom[i].setFont(textFont);
			priceOfRoom[i].setSize(textfield_width/2, textfield_height);
			priceOfRoom[i].setHorizontalAlignment(JTextField.CENTER);
			priceOfRoom[i].addKeyListener(new InputOnlyNum());
			priceOfRoom[i].setOpaque(false);
			priceOfRoom[i].setBorder(new LineBorder(Color.gray));
		}
		numOfRoom[LD].addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				numOfRoom[LD].setForeground(focus);
				numOfRoom[LD].setBorder(new LineBorder(new Color(0, 191, 255)));
				numOfRoom[LD].setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				numOfRoom[LD].setForeground(losefocus);
				numOfRoom[LD].setBorder(new LineBorder(Color.gray));
				numOfRoom[LD].setOpaque(false);
			}  
		});
		numOfRoom[LS].addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				numOfRoom[LS].setForeground(focus);
				numOfRoom[LS].setBorder(new LineBorder(new Color(0, 191, 255)));
				numOfRoom[LS].setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				numOfRoom[LS].setForeground(losefocus);
				numOfRoom[LS].setBorder(new LineBorder(Color.gray));
				numOfRoom[LS].setOpaque(false);
			}  
		});
		numOfRoom[SD].addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				numOfRoom[SD].setForeground(focus);
				numOfRoom[SD].setBorder(new LineBorder(new Color(0, 191, 255)));
				numOfRoom[SD].setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				numOfRoom[SD].setForeground(losefocus);
				numOfRoom[SD].setBorder(new LineBorder(Color.gray));
				numOfRoom[SD].setOpaque(false);
			}  
		});
		numOfRoom[SS].addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				numOfRoom[SS].setForeground(focus);
				numOfRoom[SS].setBorder(new LineBorder(new Color(0, 191, 255)));
				numOfRoom[SS].setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				numOfRoom[SS].setForeground(losefocus);
				numOfRoom[SS].setBorder(new LineBorder(Color.gray));
				numOfRoom[SS].setOpaque(false);
			}  
		});
		numOfRoom[family].addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				numOfRoom[family].setForeground(focus);
				numOfRoom[family].setBorder(new LineBorder(new Color(0, 191, 255)));
				numOfRoom[family].setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				numOfRoom[family].setForeground(losefocus);
				numOfRoom[family].setBorder(new LineBorder(Color.gray));
				numOfRoom[family].setOpaque(false);
			}  
		});
		
		priceOfRoom[LD].addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				priceOfRoom[LD].setForeground(focus);
				priceOfRoom[LD].setBorder(new LineBorder(new Color(0, 191, 255)));
				priceOfRoom[LD].setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				priceOfRoom[LD].setForeground(losefocus);
				priceOfRoom[LD].setBorder(new LineBorder(Color.gray));
				priceOfRoom[LD].setOpaque(false);
			}  
		});
		priceOfRoom[LS].addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				priceOfRoom[LS].setForeground(focus);
				priceOfRoom[LS].setBorder(new LineBorder(new Color(0, 191, 255)));
				priceOfRoom[LS].setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				priceOfRoom[LS].setForeground(losefocus);
				priceOfRoom[LS].setBorder(new LineBorder(Color.gray));
				priceOfRoom[LS].setOpaque(false);
			}  
		});
		priceOfRoom[SD].addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				priceOfRoom[SD].setForeground(focus);
				priceOfRoom[SD].setBorder(new LineBorder(new Color(0, 191, 255)));
				priceOfRoom[SD].setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				priceOfRoom[SD].setForeground(losefocus);
				priceOfRoom[SD].setBorder(new LineBorder(Color.gray));
				priceOfRoom[SD].setOpaque(false);
			}  
		});
		priceOfRoom[SS].addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				priceOfRoom[SS].setForeground(focus);
				priceOfRoom[SS].setBorder(new LineBorder(new Color(0, 191, 255)));
				priceOfRoom[SS].setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				priceOfRoom[SS].setForeground(losefocus);
				priceOfRoom[SS].setBorder(new LineBorder(Color.gray));
				priceOfRoom[SS].setOpaque(false);
			}  
		});
		priceOfRoom[family].addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				priceOfRoom[family].setForeground(focus);
				priceOfRoom[family].setBorder(new LineBorder(new Color(0, 191, 255)));
				priceOfRoom[family].setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				priceOfRoom[family].setForeground(losefocus);
				priceOfRoom[family].setBorder(new LineBorder(Color.gray));
				priceOfRoom[family].setOpaque(false);
			}  
		});

	}
	
	private void Buttons2(){
		Font font = new Font("华文楷体",1,15);
	    UIManager.put("OptionPane.font", font);
	    UIManager.put("OptionPane.messageFont", font);
	    UIManager.put("OptionPane.buttonFont", font);
		
		backb = new JButton("返回");
		backb.setFont(new Font("华文新魏",1,20));
		backb.setForeground(Color.white);
		backb.setBackground(new Color(0, 191, 255));
		backb.setBorderPainted(false);
		backb.setFocusPainted(false);
		backb.setSize( button_width, button_height);
		backb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backb.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				backb.setBackground(new Color(0, 220, 255));   
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backb.setBackground(new Color(0, 191, 255));  
			}
		});
		backb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				vch.signupRoomToHotel();
			}
		});
		 	
		submitb.setFont(new Font("华文新魏",1,20));	
		submitb.setForeground(Color.white);
		submitb.setBackground(new Color(0, 191, 255));
		submitb.setBorderPainted(false);
		submitb.setFocusPainted(false);
		submitb.setSize( button_width*3/2, button_height);
		submitb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
		submitb.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				submitb.setBackground(new Color(0, 220, 255));   
			}

			@Override
			public void mouseExited(MouseEvent e) {
				submitb.setBackground(new Color(0, 191, 255));  
			}
		});
		submitb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int num[] = new int[numOfRoomKind];
				int price[] = new int[numOfRoomKind];
				boolean checkresult[] = new boolean[numOfRoomKind];
				boolean issuccessful = false;
				for(int i=0;i<numOfRoomKind;i++){
					if(numOfRoom[i].getText().length()>0)
						num[i] = Integer.valueOf(numOfRoom[i].getText());
					else{
						num[i] = 0;
						numOfRoom[i].setText("0");
					}
					if(priceOfRoom[i].getText().length()>0)
						price[i] = Integer.valueOf(priceOfRoom[i].getText());
					else{
						price[i] = 0;
						priceOfRoom[i].setText("0");
					}
				}
				checkresult = monitorbl.signupcheckHotelInfor(num, price);
				for(int i=0;i<numOfRoomKind;i++){
					if(!checkresult[i])
						statusRoom[i].setText("大小请勿超过100000");
				}
				for(boolean temp : checkresult){
					if(!temp){
						issuccessful = false;
						break;
					}
					issuccessful = true;
				}
				if(issuccessful){
					Font font = new Font("华文楷体",1,15);
				    UIManager.put("OptionPane.font", font);
				    UIManager.put("OptionPane.messageFont", font);
				    UIManager.put("OptionPane.buttonFont", font);
				    
					String id = "";
					infor.setLD(numOfRoom[LD].getText(), priceOfRoom[LD].getText());
					infor.setLS(numOfRoom[LS].getText(), priceOfRoom[LS].getText());
					infor.setSD(numOfRoom[SD].getText(), priceOfRoom[SD].getText());
					infor.setSS(numOfRoom[SS].getText(), priceOfRoom[SS].getText());
					infor.setfamily(numOfRoom[family].getText(), priceOfRoom[family].getText());
					
					id = vch.signup(new String(passwordT.getPassword()), infor);
					if(id.length()==0)
						JOptionPane.showMessageDialog(null, "未连接服务器！",
								"", JOptionPane.ERROR_MESSAGE);
					else{
						if(id.equals("false"))
							JOptionPane.showMessageDialog(null, "商圈内酒店已存在！",
								"", JOptionPane.ERROR_MESSAGE);
						else{
							JOptionPane.showMessageDialog(null, "您的ID是"+id+"\n"+"请使用ID登录！",
									"账户ID",JOptionPane.WARNING_MESSAGE);	
							vch.signupSuccessful();
							clear();
						}
					}
				}
				
			}
		});
	}
	
	protected static void clear(){
		infor = new HotelInforvo();
		
		nameT.setText("");
		telephoneT.setText("");
		addressT.setText("");
		introductionT.setText("");
		
		passwordT.setText("");
		confirmpasswordT.setText("");
		
		tradeareaC.setSelectedItem(0);
		levelC.setSelectedItem(0);
		
		for(int i=0;i<numOfRoomKind;i++){
			numOfRoom[i].setText("");
			priceOfRoom[i].setText("");
		}
	}
}

