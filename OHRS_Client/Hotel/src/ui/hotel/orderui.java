package ui.hotel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.view_controller_hotelOd;
import vo.OdvoForHotel;

public class orderui extends JPanel{
	
	private static view_controller_hotelOd vch = new view_controller_hotelOd();
	
	private final int OdID = 0;
	private final int Odstatus = 1;
	private final int clientID = 2;
	private final int hotelID = 3;
	private final int kindOfRoom = 4;
	private final int numOfRoom = 5;
	private final int priceOfRoom = 6;
	private final int comeTime = 7;
	private final int days = 8;
	private final int promotion = 9;
	private final int totalPrice = 10;
	private final int comment = 11;
	/*
	 * 常量值
	 * 用于规定输入框和选择框的大小
	 * 也使用于布局中status的位置确定
	 */
	private final int label_width=150;
	private final int label_height=30;
	private final int textfield_width = 180;
	private final int textfield_height = 35;
	
	private final int numOfInforL = 12;
	private final int numOfInforT = 11;
	
	private JLabel titleL;
	private JLabel OdInforL[] = new JLabel[numOfInforL];
	private JTextField OdInforT[] = new JTextField[numOfInforT];
	private JTextArea commentT = new JTextArea();
	private JScrollPane commentSP = new JScrollPane(commentT);
	
	private JButton backB;
	private JButton executeB;
	private JButton registB;
	
	private Image setting;
	
	private static String accredit = "";
	
	private static OdvoForHotel inforvo = new OdvoForHotel();
	public orderui(OdvoForHotel odvo){
		inforvo = odvo;
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
		TextAreas();
		Buttons();
		
		//设置界面中一些常量值
		final int frame_width=800;
		final int frame_height=600;
		final int label_gap=50;	
		final int label_textfield_gap=150;
		
		//创建JPanel，并添加标识、文本框、选择框、按钮
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(frame_width,frame_height);
				
		// 为方便修改，x和y保存jpanel的大小
		int x=frame_width/8-40;
		int y=80;
				
		//标识的添加和排版
		int labelg=label_gap;
		int textw=textfield_width;
		int ltg=label_textfield_gap;
		
		this.add(titleL);
		titleL.setLocation((frame_width-titleL.getWidth())/2,20);
		for(int i=0;i<OdInforL.length-1;i++){
			this.add(OdInforL[i]);
			if(i%2==0)
				OdInforL[i].setLocation(x, y+labelg*(i/2));
			else
				OdInforL[i].setLocation(x+ltg+textw, y+labelg*(i/2));
		}
		this.add(OdInforL[comment]);
		OdInforL[comment].setLocation(x, y+labelg*(OdInforL.length/2));
		
		//文本框的添加和排版
		for(int i=0;i<OdInforT.length;i++){
			this.add(OdInforT[i]);
			if(i%2==0)
				OdInforT[i].setLocation(x+ltg, y+labelg*(i/2));
			else
				OdInforT[i].setLocation(x+ltg*2+textw, y+labelg*(i/2));
		}
		
		this.add(commentSP);
		commentSP.setLocation(x+ltg, y+labelg*(numOfInforT/2+1));
		
		this.add(executeB);
		this.add(registB);
		executeB.setVisible(false);
		registB.setVisible(false);
		executeB.setLocation(x+ltg, y+labelg*(numOfInforT/2+3));
		registB.setLocation(x+ltg, y+labelg*(numOfInforT/2+3));
		
		if(OdInforT[Odstatus].getText().equals("未完成"))
			executeB.setVisible(true);
		else if(OdInforT[Odstatus].getText().equals("逾期")){
			registB.setVisible(true);
		}
		this.add(backB);
		backB.setLocation(x+ltg*2+textw, y+labelg*(numOfInforT/2+3));
	}
	
	private void Images(){
		setting = Toolkit.getDefaultToolkit().getImage("image/HInforS.jpg");
	}
	
	private void Labels(){
		titleL = new JLabel("订单信息",JLabel.CENTER);
		titleL.setSize(label_width*2, label_height);
		titleL.setFont(new Font("华文行楷",4,25));
		titleL.setForeground(new Color(0, 191, 255));
		for(int i=0;i<OdInforL.length;i++){
			OdInforL[i] = new JLabel();
			OdInforL[i]=new JLabel("",JLabel.RIGHT);
			OdInforL[i].setSize(label_width, label_height);
			OdInforL[i].setFont(new Font("wingding",1,20));
			OdInforL[i].setForeground(Color.black);
		}
		OdInforL[OdID].setText("订单编号：");
		OdInforL[Odstatus].setText("订单状态：");
		OdInforL[clientID].setText("客户ID：");
		OdInforL[hotelID].setText("酒店ID：");
		OdInforL[kindOfRoom].setText("房间类型：");
		OdInforL[numOfRoom].setText("房间数量：");
		OdInforL[priceOfRoom].setText("房间单价：");
		OdInforL[comeTime].setText("最晚入住时间：");
		OdInforL[days].setText("入住天数：");
		OdInforL[promotion].setText("优惠政策：");
		OdInforL[totalPrice].setText("总价：");
		OdInforL[comment].setText("评价：");
		
		
	}
	
	private void TextFields(){
		for(int i=0;i<OdInforT.length;i++){
			OdInforT[i] = new JTextField("");
			OdInforT[i].setSize(textfield_width, textfield_height);
			OdInforT[i].setOpaque(false);
			OdInforT[i].setEditable(false);
			OdInforT[i].setFont(new Font("华文楷体",1,18));
			OdInforT[i].setForeground(Color.green);
			OdInforT[i].setHorizontalAlignment(JTextField.CENTER);
		}
		OdInforT[OdID].setText(inforvo.getOdID());
		OdInforT[Odstatus].setText(inforvo.getOdstatus());
		OdInforT[clientID].setText(inforvo.getclientID());
		OdInforT[hotelID].setText(inforvo.gethotelID());
		OdInforT[kindOfRoom].setText(inforvo.getkindOfRoom());
		OdInforT[numOfRoom].setText(String.valueOf(inforvo.getnumOfRoom()));
		OdInforT[priceOfRoom].setText(inforvo.getpriceOfRoom());
		OdInforT[comeTime].setText(inforvo.getcomeTime());
		OdInforT[days].setText(String.valueOf(inforvo.getdays()));
		OdInforT[promotion].setText(inforvo.getpromotion());
		OdInforT[totalPrice].setText(String.valueOf(inforvo.gettotalPrice()));
	}
	
	private void TextAreas(){
		commentSP.setSize(textfield_width*2+label_width, textfield_height*2);
		commentSP.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		commentSP.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		commentSP.setOpaque(false);
		commentSP.getViewport().setOpaque(false);
		
		commentT.setSize(textfield_width*2+label_width, textfield_height*2);
		commentT.setFont(new Font("楷体",1,15));
		commentT.setWrapStyleWord(true);  
		commentT.setLineWrap(true);
		commentT.setEditable(false);
		commentT.setOpaque(false);
		
		commentT.setText(inforvo.getcomment());
	}
	
	private void Buttons(){
		final int button_width=140;
		final int button_height=50;
		
		backB = new JButton("返回");
		backB.setFont(new Font("华文新魏",1,20));
		backB.setForeground(Color.white);
		backB.setBackground(new Color(0, 191, 255));
		backB.setBorderPainted(false);
		backB.setFocusPainted(false);
		backB.setSize( button_width, button_height);
		backB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				backB.setBackground(new Color(0, 220, 255));   
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backB.setBackground(new Color(0, 191, 255));  
			}
		});
		backB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vch.Odback();
			}
		});
		 
		executeB = new JButton("执行订单");
		executeB.setFont(new Font("华文新魏",1,20));	
		executeB.setForeground(Color.white);
		executeB.setBackground(new Color(0, 191, 255));
		executeB.setBorderPainted(false);
		executeB.setFocusPainted(false);
		executeB.setSize( button_width*3/2, button_height);
		executeB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		executeB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				executeB.setBackground(new Color(0, 220, 255));   
			}

			@Override
			public void mouseExited(MouseEvent e) {
				executeB.setBackground(new Color(0, 191, 255));  
			}
		});
		executeB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(vch.executeOd(accredit, OdInforT[hotelID].getText(),OdInforT[OdID].getText(),
						Integer.valueOf(OdInforT[totalPrice].getText()))){
					orderlistui.updateOdlist();
					vch.Odback();
				}
				else{
					Font font = new Font("华文楷体",1,15);
				    UIManager.put("OptionPane.font", font);
				    UIManager.put("OptionPane.messageFont", font);
				    UIManager.put("OptionPane.buttonFont", font);
				    JOptionPane.showMessageDialog(null, "执行失败，你心不诚！",
							"", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		registB = new JButton("补登记");
		registB.setFont(new Font("华文新魏",1,20));	
		registB.setForeground(Color.white);
		registB.setBackground(new Color(0, 191, 255));
		registB.setBorderPainted(false);
		registB.setFocusPainted(false);
		registB.setSize( button_width*3/2, button_height);
		registB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				registB.setBackground(new Color(0, 220, 255));   
			}

			@Override
			public void mouseExited(MouseEvent e) {
				registB.setBackground(new Color(0, 191, 255));  
			}
		});
		registB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				OdInforT[comeTime].setText(df.format(new Date()).substring(0, 16));
				inforvo.setcomeTime(OdInforT[comeTime].getText());
				if(vch.executeOd(accredit, inforvo.gethotelID(), 
						inforvo.getOdID(), inforvo.gettotalPrice(), inforvo.getcomeTime())){
					orderlistui.updateOdlist();
					vch.Odback();
				}
				else{
					Font font = new Font("华文楷体",1,15);
				    UIManager.put("OptionPane.font", font);
				    UIManager.put("OptionPane.messageFont", font);
				    UIManager.put("OptionPane.buttonFont", font);
				    JOptionPane.showMessageDialog(null, "补登记失败，你心不诚！",
							"", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	protected static void setaccredit(String s){
		accredit = s;
	}
}
