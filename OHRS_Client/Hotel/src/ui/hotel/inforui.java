package ui.hotel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import controller.view_controller_hotelInfor;
import rmi.RMIClient;
import vo.Busyroomvo;
import vo.HotelInforvo;

import javax.swing.JPanel;

public class inforui extends JPanel{	
	/**
	 * @author: hzp
	 * @version: 1.0.20161209
	 */
	
	private view_controller_hotelInfor vch = new view_controller_hotelInfor();
	
	private final int name = 0;
	private final int id = 1;
	private final int tradearea = 2;
	private final int level = 3;
	private final int telephone =4;
	private final int address = 5;
	private final int introduction = 6;
	private final int numOfHotelInfor = 7;
	/*
	 * 常量值
	 * 用于规定输入框和选择框的大小
	 * 也使用于布局中status的位置确定
	 */
	private final int textfield_width = 100;
	private final int textfield_height = 35;
	private final int image_width = 30;
	private final int image_height = 30;
	
	/*
	 * numOfRoomInfor:每种客房的信息数量
	 * kind_room：客房种类数目
	 */
	private static final int numOfRoomInfor = 6;
	private static final int numOfRoomKind = 5;
	private final int numOfRoomInforEdit = 2;
	private final int indexOfPriceOfroom = 0;
	private final int indexOfNumOfroom = 1;
	private final int indexOfBusyroom = 2;
	private final int indexOfNumOfRegisterroom = 3;
	private final int indexOfNumOfEmptyroom = 4;
	/*
	 * 用于显示修改信息后检测的结果
	 */
	private static JLabel checkresult1;
	private static JLabel checkresult2;
	/*
	 * kindOfHotelInfor:酒店信息的种类
	 */
	private JLabel kindOfHotelInfor[] = new JLabel[numOfHotelInfor];
	private JLabel kindOfRoomInfor[] = new JLabel[numOfRoomInfor];
	private JLabel kindOfRoom[] = new JLabel[numOfRoomKind];
	/*
	 * kindOfHotelInfor:酒店信息的种类
	 * data_room：客房的数据：大小=种类*每一种数据大小
	 */
	private static JTextField dataOfRoom[][] = new JTextField[numOfRoomKind][(numOfRoomInfor-1)];
	/*
	 * 用于显示酒店信息内容的显示框
	 * 用于编辑时修改酒店信息的输入框
	 */
	private static JTextField nameT = new JTextField();
	private static JTextField idT = new JTextField();
	private static JTextField tradeareaT = new JTextField();
	private static JTextField levelT = new JTextField();
	private static JTextField telephoneT = new JTextField();
	private static JTextField addressT = new JTextField();
	private static JTextField introductionT = new JTextField();

	private JComboBox<String> tradeareaC = new JComboBox<String>();
	private JComboBox<String> levelC = new JComboBox<String>();

	private JButton edit_commit[] = new JButton[6];
	private int editHotelInfor = 0;
	private int commitHotelInfor = 1;
	private int editRoomInfor = 2;
	private int commitRoomInfor = 3;
	private int editBusyroomInfor = 4;
	private int commitBusyroomInfor = 5;
	
	private Image setting;
	private ImageIcon change1_1;
	private ImageIcon change1_2;
	private ImageIcon change2_1;
	private ImageIcon change2_2;
	private ImageIcon change3_1;
	private ImageIcon change3_2;
	private ImageIcon confirm1_1;
	private ImageIcon confirm1_2;
	
	private LineBorder mylineBorder = new LineBorder(Color.white);
	private LineBorder mylineBorder2 = new LineBorder(new Color(0, 191, 255));
	private Color textColor = Color.green;
	
	private static HotelInforvo inforvo = new HotelInforvo();
	private static Busyroomvo busyroomvo = new Busyroomvo();
	private static String accredit = "";
	
	public inforui(){
		Images();
		initui();
	}
	
	public void paintComponent(Graphics g) {  
		 super.paintComponent(g);   
		 g.drawImage(setting, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  
	
	private void initui(){
		Labels();
		TextFields();
		ComboBoxs();
		Buttons();
		
		//设置界面中一些常量值
		final int frame_width=800;
		final int frame_height=600;
		
		final int label_gap=33;	
		
		//创建JPanel，并添加标识、文本框、选择框、按钮
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(frame_width,frame_height);
		
		// 为方便修改，x和y保存jpanel的大小
//		int x = frame_width/6-30;
		int x = 40;
		int y = 30;
		/*
		 * 酒店信息标识的排版
		 */
		int labelg=label_gap+5;
		
		this.add(checkresult1);
		checkresult1.setLocation(x, y+labelg*6);
		
		this.add(checkresult2);
		checkresult2.setLocation(x, y+labelg*13);
		

		for(int i=0;i<kindOfHotelInfor.length;i++)
			this.add(kindOfHotelInfor[i]);
		kindOfHotelInfor[name].setLocation(x,y);
		kindOfHotelInfor[id].setLocation(x+textfield_width*3,y);
		kindOfHotelInfor[tradearea].setLocation(x,y+labelg);
		kindOfHotelInfor[level].setLocation(x+textfield_width*3,y+labelg);
		kindOfHotelInfor[telephone].setLocation(x,y+labelg*2);
		kindOfHotelInfor[address].setLocation(x,y+labelg*3);
		kindOfHotelInfor[introduction].setLocation(x,y+labelg*4);
	
		/*
		 * 酒店信息显示框的排版
		 */
		this.add(nameT);
		this.add(idT);
		this.add(tradeareaT);
		this.add(tradeareaC);
		this.add(levelT);
		this.add(levelC);
		this.add(telephoneT);
		this.add(addressT);
		this.add(introductionT);
		tradeareaC.setVisible(false);
		levelC.setVisible(false);
		
		nameT.setLocation(x+textfield_width,y);
		idT.setLocation(x+textfield_width*4,y);
		tradeareaT.setLocation(x+textfield_width,y+labelg);
		tradeareaC.setLocation(x+textfield_width,y+labelg);
		levelT.setLocation(x+textfield_width*4,y+labelg);	
		levelC.setLocation(x+textfield_width*4,y+labelg);
		telephoneT.setLocation(x+textfield_width,y+labelg*2);
		addressT.setLocation(x+textfield_width,y+labelg*3);
		introductionT.setLocation(x+textfield_width,y+labelg*4);
		/*
		 * 客房信息类别的排版
		 */
		for(int i=0;i<kindOfRoomInfor.length;i++)
			this.add(kindOfRoomInfor[i]);
		kindOfRoomInfor[0].setLocation(x+textfield_width*0,y+labelg*7);
		kindOfRoomInfor[1].setLocation(x+textfield_width*1,y+labelg*7);
		kindOfRoomInfor[2].setLocation(x+textfield_width*2,y+labelg*7);
		kindOfRoomInfor[3].setLocation(x+textfield_width*4,y+labelg*7);
		kindOfRoomInfor[4].setLocation(x+textfield_width*5,y+labelg*7);
		kindOfRoomInfor[5].setLocation(x+textfield_width*6,y+labelg*7);
		for(int i=0;i<kindOfRoom.length;i++)
			this.add(kindOfRoom[i]);
		kindOfRoom[0].setLocation(x,y+labelg*8);
		kindOfRoom[1].setLocation(x,y+labelg*9);
		kindOfRoom[2].setLocation(x,y+labelg*10);
		kindOfRoom[3].setLocation(x,y+labelg*11);
		kindOfRoom[4].setLocation(x,y+labelg*12);
		//客房信息的添加和排版
		for(int i=0;i<dataOfRoom.length;i++){
			for(int j=0;j<dataOfRoom[0].length;j++){
				this.add(dataOfRoom[i][j]);
				if(j>1)
					dataOfRoom[i][j].setLocation(x+textfield_width*(j+2),y+labelg*(8+i));
				else
					dataOfRoom[i][j].setLocation(x+textfield_width*(j+1),y+labelg*(8+i));
			}
		}
		/*
		 * 添加修改酒店信息、房间信息、入住客房信息的按钮和提交按钮
		 */
		this.add(edit_commit[editHotelInfor]);
		this.add(edit_commit[commitHotelInfor]);
		edit_commit[editHotelInfor].setLocation(x+textfield_width*3+30, y+labelg*2); 
		edit_commit[commitHotelInfor].setLocation(x+textfield_width*3+30, y+labelg*2); 
		this.add(edit_commit[editRoomInfor]);
		this.add(edit_commit[commitRoomInfor]);
		edit_commit[editRoomInfor].setLocation(x+textfield_width*3+10, y+labelg*7); 
		edit_commit[commitRoomInfor].setLocation(x+textfield_width*3+10, y+labelg*7);
		this.add(edit_commit[editBusyroomInfor]);
		this.add(edit_commit[commitBusyroomInfor]);
		edit_commit[editBusyroomInfor].setLocation(x+textfield_width*3+30+image_width, y+labelg*7);
		edit_commit[commitBusyroomInfor].setLocation(x+textfield_width*3+30+image_width, y+labelg*7);
	}
	
	private void Images(){
		setting = Toolkit.getDefaultToolkit().getImage("image/HInforS.jpg");
		change1_1 = new ImageIcon("image/change7.jpg");
		change1_2 = new ImageIcon("image/change8.jpg");
		change2_1 = new ImageIcon("image/change5.jpg");
		change2_2 = new ImageIcon("image/change6.jpg");
		change3_1 = new ImageIcon("image/change4.jpg");
		change3_2 = new ImageIcon("image/change3.jpg");
		confirm1_1 = new ImageIcon("image/confirm2.jpg");
		confirm1_2 = new ImageIcon("image/confirm3.jpg");
	}
	
	private void Labels(){
		Color myblue = new Color(0, 191, 255);
		/*
		 * 对酒店修改后的基本信息的检测
		 */
		checkresult1 = new JLabel("",JLabel.CENTER);
		checkresult1.setSize(textfield_width*6, textfield_height);
		checkresult1.setFont(new Font("华文楷体",1,15));
		checkresult1.setForeground(Color.red);
		/*
		 * 对酒店修改后的客房信息的检测
		 */
		checkresult2 = new JLabel("",JLabel.CENTER);
		checkresult2.setSize(textfield_width*6, textfield_height);
		checkresult2.setFont(new Font("华文楷体",1,15));
		checkresult2.setForeground(Color.red);
		
		/*
		 * 酒店基本信息标识的初始化
		 */
		for(int i=0;i<kindOfHotelInfor.length;i++){
			kindOfHotelInfor[i] = new JLabel();
			kindOfHotelInfor[i].setHorizontalAlignment(JLabel.RIGHT);
			kindOfHotelInfor[i].setSize(textfield_width, textfield_height);
			kindOfHotelInfor[i].setFont(new Font("华文楷体",1,18));
			kindOfHotelInfor[i].setForeground(myblue);
		}
		kindOfHotelInfor[introduction].setSize(textfield_width, textfield_height*2);
		kindOfHotelInfor[name].setText("酒店名称：");
		kindOfHotelInfor[id].setText("酒店ID：");
		kindOfHotelInfor[tradearea].setText("商圈：");
		kindOfHotelInfor[level].setText("星级：");
		kindOfHotelInfor[telephone].setText("联系电话：");
		kindOfHotelInfor[address].setText("详细地址：");
		kindOfHotelInfor[introduction].setText("酒店介绍：");
		
		/*
		 * 初始化房间类别的标识
		 */
		for(int i=0;i<kindOfRoom.length;i++){
			kindOfRoom[i] = new JLabel();
			kindOfRoom[i].setHorizontalAlignment(JTextField.CENTER);
			kindOfRoom[i].setSize(textfield_width, textfield_height);
			kindOfRoom[i].setFont(new Font("华文新魏",1,16));
			kindOfRoom[i].setForeground(myblue);
		}
		kindOfRoom[0].setText("豪华双人间");
		kindOfRoom[1].setText("豪华单人间");
		kindOfRoom[2].setText("标准双人间");
		kindOfRoom[3].setText("标准单人间");
		kindOfRoom[4].setText("家庭间");
		
		/*
		 * 初始化房间信息的标识
		 */
		for(int i=0;i<kindOfRoomInfor.length;i++){
			kindOfRoomInfor[i] = new JLabel();
			kindOfRoomInfor[i].setHorizontalAlignment(JTextField.CENTER);
			kindOfRoomInfor[i].setSize(textfield_width, textfield_height);
			kindOfRoomInfor[i].setFont(new Font("华文楷体",1,18));
			kindOfRoomInfor[i].setForeground(Color.blue);	
		}
		kindOfRoomInfor[0].setText("类型");
		kindOfRoomInfor[1].setText("价格/元");
		kindOfRoomInfor[2].setText("数量/间");
		kindOfRoomInfor[3].setText("入住数量");
		kindOfRoomInfor[4].setText("预定数量");
		kindOfRoomInfor[5].setText("空闲数量");
		
	}
	
	private void TextFields(){
		/*
		 * 酒店基本信息显示Label初始化
		 */
		idT.setBorder(null);
		
		nameT.setOpaque(false);
		idT.setOpaque(false);
		tradeareaT.setOpaque(false);
		levelT.setOpaque(false);
		telephoneT.setOpaque(false);
		addressT.setOpaque(false);
		introductionT.setOpaque(false);
		
		nameT.setBorder(mylineBorder);
		tradeareaT.setBorder(mylineBorder);
		levelT.setBorder(mylineBorder);
		telephoneT.setBorder(mylineBorder);
		addressT.setBorder(mylineBorder);
		introductionT.setBorder(mylineBorder);
		
		nameT.setFont(new Font("华文楷体",1,15));
		idT.setFont(new Font("华文楷体",1,15));
		tradeareaT.setFont(new Font("华文楷体",1,15));
		levelT.setFont(new Font("华文楷体",1,15));
		telephoneT.setFont(new Font("华文楷体",1,15));
		addressT.setFont(new Font("华文楷体",1,15));
		introductionT.setFont(new Font("华文楷体",1,15));
		
		nameT.setForeground(textColor);
		idT.setForeground(textColor);
		tradeareaT.setForeground(textColor);
		levelT.setForeground(textColor);
		telephoneT.setForeground(textColor);
		addressT.setForeground(textColor);
		introductionT.setForeground(textColor);
		
		nameT.setSize(textfield_width*2, textfield_height);
		idT.setSize(textfield_width*2, textfield_height);
		tradeareaT.setSize(textfield_width*2, textfield_height);
		levelT.setSize(textfield_width*2, textfield_height);	
		telephoneT.setSize(textfield_width*2, textfield_height);
		addressT.setSize(textfield_width*5, textfield_height);
		introductionT.setSize(textfield_width*5, textfield_height*2);
		
		/*
		 * 获取酒店基本信息
		 */
		try{
			inforvo = RMIClient.getInstance().gethotelServe().gethotelinfor(accredit);
		}catch (RemoteException e){
			e.printStackTrace();
		}catch (Exception el){
			el.printStackTrace();
		}
		nameT.setText("  "+inforvo.getname());
		idT.setText("  "+inforvo.getid());
		tradeareaT.setText("  "+inforvo.gettradearea());
		levelT.setText("  "+inforvo.getlevel());
		telephoneT.setText("  "+inforvo.gettelephone());
		addressT.setText("  "+inforvo.getaddress());
		introductionT.setText("  "+inforvo.getintroduction());
		
		nameT.addKeyListener(new InputNoSpace());
		addressT.addKeyListener(new InputNoSpace());
		introductionT.addKeyListener(new InputNoSpace());
		telephoneT.addKeyListener(new InputOnlyNum());
		
		nameT.setEditable(false);
		idT.setEditable(false);
		tradeareaT.setEditable(false);
		levelT.setEditable(false);
		telephoneT.setEditable(false);
		addressT.setEditable(false);
		introductionT.setEditable(false);

		/*
		 * 酒店客房基本信息的获取和显示
		 */
		for(int i=0;i<dataOfRoom.length;i++){
			for(int j=0;j<dataOfRoom[0].length;j++){
				dataOfRoom[i][j] = new JTextField();
				dataOfRoom[i][j].setOpaque(false);
				dataOfRoom[i][j].setBorder(mylineBorder);
				dataOfRoom[i][j].setHorizontalAlignment(JTextField.CENTER);
				dataOfRoom[i][j].setSize(textfield_width, textfield_height);
				dataOfRoom[i][j].setFont(new Font("华文新魏",1,15));
				dataOfRoom[i][j].setForeground(textColor);
				dataOfRoom[i][j].setEditable(false);
				dataOfRoom[i][j].addKeyListener(new InputOnlyNum());
			}
		}
		int data[][] = inforvo.datatogether();
		for(int i=0;i<dataOfRoom.length;i++){
			for(int j=0;j<inforvo.getLD().length;j++){
				dataOfRoom[i][j].setText(String.valueOf(data[i][j]));
			}
		}
		/*
		 * 获取酒店入住客房信息
		 */
		try{
			busyroomvo = RMIClient.getInstance().gethotelServe().getbusyroominfor(accredit);
		}catch (RemoteException e){
			e.printStackTrace();
		}catch (Exception el){
			el.printStackTrace();
		}
		int dataOfBusyroom[][] = busyroomvo.datatogether();
		for(int i=0;i<dataOfBusyroom.length;i++){
			for(int j=0;j<dataOfBusyroom[0].length;j++){
				dataOfRoom[i][j+indexOfBusyroom].setText(String.valueOf(dataOfBusyroom[i][j]));
			}
		}
		for(int i=0;i<dataOfBusyroom.length;i++){
			dataOfRoom[i][indexOfNumOfEmptyroom].setText(String.valueOf( Integer.valueOf(dataOfRoom[i][indexOfNumOfroom].getText())
					-Integer.valueOf(dataOfRoom[i][indexOfBusyroom].getText())
					-Integer.valueOf(dataOfRoom[i][indexOfNumOfRegisterroom].getText())));
		}
	}

	private void ComboBoxs(){
		/*
		 * 初始化商圈、星级选择框
		 */
		String tradeareaS[]={"  南京","  上海","  北京","  连云港"};
		tradeareaC=new JComboBox<String>(tradeareaS);
		tradeareaC.setFont(new Font("华文楷体",1,15));
		tradeareaC.setSize(textfield_width*2, textfield_height);
				
		String levelS[]={"    1","    2","    3","    4","    5"};
		levelC=new JComboBox<String>(levelS);	
		levelC.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
		levelC.setFont(new Font("华文楷体",1,15));	
		levelC.setSize(textfield_width*2, textfield_height);
	}
	
	private void Buttons(){
		Font font = new Font("华文楷体",1,15);
	    UIManager.put("OptionPane.font", font);
	    UIManager.put("OptionPane.messageFont", font);
	    UIManager.put("OptionPane.buttonFont", font);
		
		final int button_width = 150;
		final int button_height = 50;
		
		for(int i=0;i<edit_commit.length;i++){
			edit_commit[i] = new JButton();
			edit_commit[i].setFont(new Font("华文新魏",1,18));
			edit_commit[i].setForeground(Color.white);
			edit_commit[i].setBackground(new Color(0, 191, 255));
			edit_commit[i].setBorderPainted(false);
			edit_commit[i].setFocusPainted(false);
			edit_commit[i].setSize( button_width, button_height);
			edit_commit[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			if(i%2==1)
				edit_commit[i].setVisible(false);
		}
		/*
		 * 修改酒店信息的按钮和提交按钮
		 */
		edit_commit[editHotelInfor].setIcon(change1_1);
		edit_commit[editHotelInfor].setMargin(new Insets(-1,-1,-1,-1));
		edit_commit[editHotelInfor].setSize(image_width, image_height);
		edit_commit[editHotelInfor].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				edit_commit[editHotelInfor].setIcon(change1_2);;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				edit_commit[editHotelInfor].setIcon(change1_1);;
			}
		});
		edit_commit[commitHotelInfor].setIcon(confirm1_1);
		edit_commit[commitHotelInfor].setMargin(new Insets(-1,-1,-1,-1));
		edit_commit[commitHotelInfor].setSize(image_width, image_height);
		edit_commit[commitHotelInfor].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				edit_commit[commitHotelInfor].setIcon(confirm1_2);;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				edit_commit[commitHotelInfor].setIcon(confirm1_1);;
			}
		});
		/*
		 * 修改客房信息的按钮和提交按钮
		 */
		edit_commit[editRoomInfor].setIcon(change2_1);
		edit_commit[editRoomInfor].setMargin(new Insets(-1,-1,-1,-1));
		edit_commit[editRoomInfor].setSize(image_width, image_height);
		edit_commit[editRoomInfor].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				edit_commit[editRoomInfor].setIcon(change2_2);;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				edit_commit[editRoomInfor].setIcon(change2_1);;
			}
		});
		edit_commit[commitRoomInfor].setIcon(confirm1_1);
		edit_commit[commitRoomInfor].setMargin(new Insets(-1,-1,-1,-1));
		edit_commit[commitRoomInfor].setSize(image_width, image_height);
		edit_commit[commitRoomInfor].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				edit_commit[commitRoomInfor].setIcon(confirm1_2);;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				edit_commit[commitRoomInfor].setIcon(confirm1_1);;
			}
		});
		/*
		 * 修改入住信息的按钮和提交按钮
		 */
		edit_commit[editBusyroomInfor].setIcon(change3_1);
		edit_commit[editBusyroomInfor].setMargin(new Insets(-1,-1,-1,-1));
		edit_commit[editBusyroomInfor].setSize(image_width, image_height);
		edit_commit[editBusyroomInfor].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				edit_commit[editBusyroomInfor].setIcon(change3_2);;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				edit_commit[editBusyroomInfor].setIcon(change3_1);;
			}
		});
		edit_commit[commitBusyroomInfor].setIcon(confirm1_1);
		edit_commit[commitBusyroomInfor].setMargin(new Insets(-1,-1,-1,-1));
		edit_commit[commitBusyroomInfor].setSize(image_width, image_height);
		edit_commit[commitBusyroomInfor].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				edit_commit[commitBusyroomInfor].setIcon(confirm1_2);;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				edit_commit[commitBusyroomInfor].setIcon(confirm1_1);;
			}
		});
		/*
		 * 修改酒店信息按钮点击后
		 */
		edit_commit[editHotelInfor].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				edit_commit[editHotelInfor].setVisible(false);
				edit_commit[commitHotelInfor].setVisible(true);
				edit_commit[editRoomInfor].setVisible(false);
				edit_commit[editBusyroomInfor].setVisible(false);
				
				nameT.setText(nameT.getText().replaceAll(" ", ""));
				nameT.setEditable(true);
				nameT.setBorder(mylineBorder2);
				nameT.setOpaque(true);
				
				tradeareaC.setSelectedItem(tradeareaT.getText());
				tradeareaC.setVisible(true);
				tradeareaT.setVisible(false);
				
				levelC.setSelectedItem(levelT.getText());
				levelC.setVisible(true);
				levelT.setVisible(false);
				
				telephoneT.setText(telephoneT.getText().replaceAll(" ", ""));
				telephoneT.setEditable(true);
				telephoneT.setBorder(mylineBorder2);
				telephoneT.setOpaque(true);
				
				addressT.setText(addressT.getText().replaceAll(" ", ""));
				addressT.setEditable(true);
				addressT.setBorder(mylineBorder2);
				addressT.setOpaque(true);
				
				introductionT.setText(introductionT.getText().replaceAll(" ", ""));
				introductionT.setEditable(true);
				introductionT.setBorder(mylineBorder2);
				introductionT.setOpaque(true);
			}
		});
		edit_commit[commitHotelInfor].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean checkresults[] = new boolean[4];
				boolean isRight = true;
				String result = "";
				//对 酒店名称 输入的检测
				if(nameT.getText().length()==0){
					checkresults[0] = false;
					result = result+"  请填写酒店名称";
				}
				else if(nameT.getText().length()>20){
					checkresults[0] = false;
					result = result+"  名称请勿超过20个字母";
				}
				else{
					checkresults[0] = true;
				}
				//对 联系电话 输入的检测
				if(telephoneT.getText().length()!=11){
					checkresults[1] = false;
					result = result+"  请填写11位联系电话";
				}
				else{
					checkresults[1] = true;
				}
				//对 酒店地址 输入的检测
				if(addressT.getText().length()==0){
					checkresults[2] = false;
					result = result+"  请填写酒店地址";
				}
				else{
					checkresults[2] = true;
				}
				//对 酒店介绍 输入的检测
				if(introductionT.getText().length()==0){
					checkresults[3] = false;
					result = result+"  请填写酒店描述";
				}
				else{
					checkresults[3] = true;
				}
				for(int i=0;i<checkresults.length;i++){
					if(!checkresults[i]){
						isRight = false;
						break;
					}
					isRight = true;
				}
				if(!isRight){
					checkresult1.setText(result);
				}
				else{
					checkresult1.setText("");
					inforvo.setname(nameT.getText().replaceAll(" ", ""));
					inforvo.settelephone(telephoneT.getText().replaceAll(" ", ""));
					inforvo.setaddress(addressT.getText().replaceAll(" ", ""));
					inforvo.setintroduction(introductionT.getText().replaceAll(" ", ""));
					if(vch.editHotelInfor(accredit, inforvo)){
						edit_commit[editHotelInfor].setVisible(true);
						edit_commit[commitHotelInfor].setVisible(false);
						edit_commit[editRoomInfor].setVisible(true);
						edit_commit[editBusyroomInfor].setVisible(true);
						
						nameT.setEditable(false);
						nameT.setText("  "+nameT.getText());
						nameT.setOpaque(false);
						nameT.setBorder(mylineBorder);
						
						tradeareaT.setText("  "+tradeareaC.getSelectedItem().toString());
						tradeareaT.setVisible(true);
						tradeareaC.setVisible(false);
						
						levelT.setText("  "+levelC.getSelectedItem().toString());
						levelT.setVisible(true);
						levelC.setVisible(false);
						
						telephoneT.setText("  "+telephoneT.getText());
						telephoneT.setEditable(false);
						telephoneT.setOpaque(false);
						telephoneT.setBorder(mylineBorder);
						
						addressT.setText("  "+addressT.getText());
						addressT.setEditable(false);
						addressT.setOpaque(false);
						addressT.setBorder(mylineBorder);
						
						introductionT.setText("  "+introductionT.getText());
						introductionT.setEditable(false);
						introductionT.setOpaque(false);
						introductionT.setBorder(mylineBorder);
					}
					else{
						JOptionPane.showMessageDialog(null, "商圈内酒店已存在！",
								"", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		edit_commit[editRoomInfor].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				edit_commit[editHotelInfor].setVisible(false);
				edit_commit[editRoomInfor].setVisible(false);
				edit_commit[commitRoomInfor].setVisible(true);
				edit_commit[editBusyroomInfor].setVisible(false);
				for(int i=0;i<dataOfRoom.length;i++){
					for(int j=0;j<numOfRoomInforEdit;j++){
						dataOfRoom[i][j].setEditable(true);
						dataOfRoom[i][j].setBorder(mylineBorder2);
						dataOfRoom[i][j].setOpaque(true);
					}
				}
			}
		});
		edit_commit[commitRoomInfor].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean isRight = true;
				for(int i=0;i<dataOfRoom.length&&isRight;i++){
					for(int j=0;j<numOfRoomInforEdit;j++){
						if(dataOfRoom[i][j].getText().length()>6){
							isRight = false;
							break;
						}
						isRight = true;
					}
				}
				if(isRight){
					checkresult2.setText("");
					inforvo.setLD(dataOfRoom[0][indexOfPriceOfroom].getText(), dataOfRoom[0][indexOfNumOfroom].getText());
					inforvo.setLS(dataOfRoom[1][indexOfPriceOfroom].getText(), dataOfRoom[1][indexOfNumOfroom].getText());
					inforvo.setSD(dataOfRoom[2][indexOfPriceOfroom].getText(), dataOfRoom[2][indexOfNumOfroom].getText());
					inforvo.setSS(dataOfRoom[3][indexOfPriceOfroom].getText(), dataOfRoom[3][indexOfNumOfroom].getText());
					inforvo.setfamily(dataOfRoom[4][indexOfPriceOfroom].getText(), dataOfRoom[4][indexOfNumOfroom].getText());
					if(vch.editHotelInfor(accredit, inforvo)){
						edit_commit[editHotelInfor].setVisible(true);
						edit_commit[editRoomInfor].setVisible(true);
						edit_commit[commitRoomInfor].setVisible(false);
						edit_commit[editBusyroomInfor].setVisible(true);
						for(int i=0;i<dataOfRoom.length;i++){
							for(int j=0;j<numOfRoomInforEdit;j++){
								dataOfRoom[i][j].setEditable(false);
								dataOfRoom[i][j].setBorder(mylineBorder);
								dataOfRoom[i][j].setOpaque(false);
								if(dataOfRoom[i][j].getText().length()==0)
									dataOfRoom[i][j].setText("0");
							}
						}
						for(int i=0;i<dataOfRoom.length;i++){
							dataOfRoom[i][indexOfNumOfEmptyroom].setText(String.valueOf( Integer.valueOf(dataOfRoom[i][indexOfNumOfroom].getText())
									-Integer.valueOf(dataOfRoom[i][indexOfBusyroom].getText())
									-Integer.valueOf(dataOfRoom[i][indexOfNumOfRegisterroom].getText())));
						}
						checkresult2.setText("");
					}
					else{
						checkresult2.setText("修改失败，原因不详！");
					}
				}
				else{
					checkresult2.setText("客房数量和价格大小不要大于1000000！");
				}
			}
		});
		edit_commit[editBusyroomInfor].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				edit_commit[editHotelInfor].setVisible(false);
				edit_commit[editRoomInfor].setVisible(false);
				edit_commit[editBusyroomInfor].setVisible(false);
				edit_commit[commitBusyroomInfor].setVisible(true);
				for(int i=0;i<dataOfRoom.length;i++){
					int j = indexOfBusyroom;
					dataOfRoom[i][j].setEditable(true);
					dataOfRoom[i][j+1].setEditable(true);
					dataOfRoom[i][j].setOpaque(true);
					dataOfRoom[i][j+1].setOpaque(true);
					dataOfRoom[i][j].setBorder(mylineBorder2);
					dataOfRoom[i][j+1].setBorder(mylineBorder2);
				}
			}
		});
		edit_commit[commitBusyroomInfor].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean isRight = true;
				for(int i=0;i<dataOfRoom.length;i++){
					int k = indexOfNumOfroom;
					int j = indexOfBusyroom;
					int h = indexOfNumOfRegisterroom;
					if((Integer.valueOf(dataOfRoom[i][j].getText())+Integer.valueOf(dataOfRoom[i][h].getText()))
							>Integer.valueOf(dataOfRoom[i][k].getText())){
						checkresult2.setText("入住和预定数目之和大于总客房数目！");
						isRight = false;
						break;
					}
					isRight = true;
				}
				if(isRight){
					checkresult2.setText("");
					busyroomvo.setnum_LD_regist(Integer.valueOf(dataOfRoom[0][indexOfBusyroom].getText()));
					busyroomvo.setnum_LD_order(Integer.valueOf(dataOfRoom[0][indexOfBusyroom+1].getText()));
					busyroomvo.setnum_LS_regist(Integer.valueOf(dataOfRoom[1][indexOfBusyroom].getText()));
					busyroomvo.setnum_LS_order(Integer.valueOf(dataOfRoom[1][indexOfBusyroom+1].getText()));
					busyroomvo.setnum_SD_regist(Integer.valueOf(dataOfRoom[2][indexOfBusyroom].getText()));
					busyroomvo.setnum_SD_order(Integer.valueOf(dataOfRoom[2][indexOfBusyroom+1].getText()));
					busyroomvo.setnum_SS_regist(Integer.valueOf(dataOfRoom[3][indexOfBusyroom].getText()));
					busyroomvo.setnum_SS_order(Integer.valueOf(dataOfRoom[3][indexOfBusyroom+1].getText()));
					busyroomvo.setnum_family_regist(Integer.valueOf(dataOfRoom[4][indexOfBusyroom].getText()));
					busyroomvo.setnum_family_order(Integer.valueOf(dataOfRoom[4][indexOfBusyroom+1].getText()));
					if(vch.editbusyroominfor(accredit, busyroomvo)){
						edit_commit[editHotelInfor].setVisible(true);
						edit_commit[editRoomInfor].setVisible(true);
						edit_commit[editBusyroomInfor].setVisible(true);
						edit_commit[commitBusyroomInfor].setVisible(false);
						for(int i=0;i<dataOfRoom.length;i++){
							int j = indexOfBusyroom;
							dataOfRoom[i][j].setEditable(false);
							dataOfRoom[i][j+1].setEditable(false);
							dataOfRoom[i][j].setOpaque(false);
							dataOfRoom[i][j+1].setOpaque(false);
							dataOfRoom[i][j].setBorder(mylineBorder);
							dataOfRoom[i][j+1].setBorder(mylineBorder);
						}
						for(int i=0;i<dataOfRoom.length;i++){
							dataOfRoom[i][indexOfNumOfEmptyroom].setText(String.valueOf( Integer.valueOf(dataOfRoom[i][indexOfNumOfroom].getText())
									-Integer.valueOf(dataOfRoom[i][indexOfBusyroom].getText())
									-Integer.valueOf(dataOfRoom[i][indexOfNumOfRegisterroom].getText())));
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "修改失败，原因不详！",
								"", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
	
	protected static void setaccredit(String s){
		accredit = s;
	}
	
	public static Image makeColorTransparent(Image im, final Color color) {
		ImageFilter filter = new RGBImageFilter() {
	            // the color we are looking for... Alpha bits are set to opaque
			public int markerRGB = color.getRGB() | 0xFF000000;
	 
			@Override
			public final int filterRGB(int x, int y, int rgb) {
				if ((rgb | 0xFF000000) == markerRGB) {
					// Mark the alpha bits as zero - transparent
					return 0x00FFFFFF & rgb;
				} 
				else {
					return rgb;
				}
			}
		};
	 
		ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	    }
	
	protected static void clear(){
		inforvo = new HotelInforvo();
		busyroomvo = new Busyroomvo();
		
		for(int i=0;i<dataOfRoom.length;i++)
			for(int j=0;j<dataOfRoom[0].length;j++)
				dataOfRoom[i][j].setText("");

		nameT.setText("");
		idT.setText("");
		tradeareaT.setText("");
		levelT.setText("");
		telephoneT.setText("");
		addressT.setText("");
		introductionT.setText("");
		
		accredit = "";
	}
}







