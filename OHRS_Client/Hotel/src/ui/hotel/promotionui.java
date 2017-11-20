package ui.hotel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import controller.view_controller_hotelProm;
import vo.PromvoForHotel;

import javax.swing.JButton;

public class promotionui extends JPanel{
	
	private view_controller_hotelProm vch = new view_controller_hotelProm();
	
	private final int numOfPromKind = 2;
	/*
	 * 常量值
	 * 用于规定输入框和选择框的大小
	 * 也使用于布局中status的位置确定
	 */
	private	final int label_gap=50;	
	private final int label_textfield_gap=120;
	private final int frame_width=600;
	private final int frame_height=380;
	private final int label_width=120;
	private final int label_height=30;
	private final int textfield_width = 140;
	private final int textfield_height = 35;
	private final int button_width=140;
	private final int button_height=50;
	
	private JLabel titleL;
	private JLabel nameL;
	private JLabel kindL;
	private JLabel DorIL; //折扣或者介绍框
	private JLabel percent;
	private static JLabel checkresult;
	
	private static JTextField nameTF;
	private static JTextField discountTF;
	private static JTextArea introductionTA = new JTextArea();
	private JScrollPane introductionSP = new JScrollPane(introductionTA);
	
	private JButton backB;
	private JButton commitB;
	
	private Image setting;
	
	private static JComboBox<String> kindC;
	
	private static PromvoForHotel promvo = new PromvoForHotel();
	private static String accredit = "";

	public promotionui() {
		Images();
		initui();
	}
	
	public void paintComponent(Graphics g) {  
		 super.paintComponent(g);   
		 g.drawImage(setting, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  

	private void initui() {
		Labels();
		TextFields();
		TextAreas();
		ComboBoxs();
		Buttons();
		
		//创建JPanel，并添加标识、文本框、选择框、按钮
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(frame_width,frame_height);
				
		// 为方便修改，x和y保存jpanel的大小
		int x=frame_width/20;
		int y=90;
				
		//标识的添加和排版
		int labelg=label_gap;
		int textw=textfield_width;
		int ltg=label_textfield_gap;
		
		this.add(titleL);
		this.add(nameL);
		this.add(kindL);
		this.add(DorIL);
		this.add(percent);
		this.add(checkresult);
		titleL.setLocation((frame_width-titleL.getWidth())/2, 20);
		nameL.setLocation(x, y);
		kindL.setLocation(x+ltg+textw, y);
		DorIL.setLocation(x, y+labelg);
		percent.setLocation(x+ltg+textw, y+labelg);
		checkresult.setLocation(0, y+labelg*4);
		
		this.add(nameTF);
		this.add(discountTF);
		this.add(introductionSP);
		nameTF.setLocation(x+ltg, y);
		discountTF.setLocation(x+ltg, y+labelg);
		introductionSP.setLocation(x+ltg, y+labelg);
		introductionSP.setVisible(false);
		
		this.add(kindC);
		kindC.setLocation(x+ltg*2+textw, y);
		
		this.add(commitB);
		this.add(backB);
		commitB.setLocation(x+ltg, y+labelg*2+40);
		backB.setLocation(x+ltg*2+textw, y+labelg*2+40);
	}
	
	private void Images(){
		setting = Toolkit.getDefaultToolkit().getImage("image/HPromS.jpg");
	}
	
	private void Labels(){
		
		titleL = new JLabel("制定优惠政策",JLabel.CENTER);
		titleL.setSize(label_width*2, label_height);
		titleL.setFont(new Font("华文行楷",4,22));
		titleL.setForeground(new Color(0, 191, 255));
		
		nameL = new JLabel("优惠名称：",JLabel.RIGHT);
		nameL.setSize(label_width, label_height);
		nameL.setFont(new Font("华文行楷",4,22));
		nameL.setForeground(Color.black);
		
		kindL = new JLabel("优惠类型：",JLabel.RIGHT);
		kindL.setSize(label_width, label_height);
		kindL.setFont(new Font("华文行楷",4,22));
		kindL.setForeground(Color.black);
		
		DorIL = new JLabel("折扣：",JLabel.RIGHT);
		DorIL.setSize(label_width, label_height);
		DorIL.setFont(new Font("华文行楷",4,22));
		DorIL.setForeground(Color.black);
		
		percent = new JLabel("%",JLabel.LEFT);
		percent.setSize(label_width, label_height);
		percent.setFont(new Font("华文行楷",4,22));
		percent.setForeground(Color.black);
		
		checkresult = new JLabel("",JLabel.CENTER);
		checkresult.setSize(frame_width, textfield_height);
		checkresult.setFont(new Font("华文楷体",4,15));
		checkresult.setForeground(Color.red);
	}
	
	private void TextFields(){
		
		nameTF = new JTextField();
		nameTF.setOpaque(false);
		nameTF.setSize(textfield_width, textfield_height);
		nameTF.setFont(new Font("华文楷体",1,16));
		nameTF.setForeground(Color.black);
		nameTF.setHorizontalAlignment(JTextField.CENTER);
		nameTF.addKeyListener(new InputOnlyEnglishOrChinese());
		nameTF.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				nameTF.setBorder(new LineBorder(new Color(0, 191, 255)));
				nameTF.setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				nameTF.setBorder(new LineBorder(Color.gray));
				nameTF.setOpaque(false);
			}  
		});
		
		discountTF = new JTextField();
		discountTF.setOpaque(false);
		discountTF.setSize(textfield_width, textfield_height);
		discountTF.setFont(new Font("华文楷体",1,18));
		discountTF.setForeground(Color.black);
		discountTF.setHorizontalAlignment(JTextField.CENTER);
		discountTF.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				discountTF.setBorder(new LineBorder(new Color(0, 191, 255)));
				discountTF.setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				discountTF.setBorder(new LineBorder(Color.gray));
				discountTF.setOpaque(false);
			}  
		});
		discountTF.addKeyListener(new Discount(){
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyChar=e.getKeyChar();
				String s = discountTF.getText().trim();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9 
						&& s.length()<2) {
				} else {
					e.consume();  
				}
			}
		});
	}
	
	private void TextAreas(){
		introductionTA.setFont(new Font("楷体",1,15));
		introductionTA.setWrapStyleWord(true);  
		introductionTA.setLineWrap(true);
		introductionTA.setEditable(true);
		introductionTA.setSize(textfield_width+label_width, textfield_height*2);
		introductionTA.addKeyListener(new InputNoSpace());
		
		introductionSP.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		introductionSP.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		introductionSP.setSize(textfield_width+label_width, textfield_height*2);
			
	}
	
	private void Buttons(){	
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
				clear();
				vch.cancleMakeProm();
			}
		});
		
		commitB = new JButton("提交");
		commitB.setFont(new Font("华文新魏",1,20));
		commitB.setForeground(Color.white);
		commitB.setBackground(new Color(0, 191, 255));
		commitB.setBorderPainted(false);
		commitB.setFocusPainted(false);
		commitB.setSize( button_width, button_height);
		commitB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		commitB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				commitB.setBackground(new Color(0, 220, 255));   
			}

			@Override
			public void mouseExited(MouseEvent e) {
				commitB.setBackground(new Color(0, 191, 255));  
			}
		});
		commitB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean checkresultAll[] = new boolean[2];
				boolean isRight = true;
				String s1 = "", s2 = "", s3 = "";
				int lengthOfName = 0;
				String tempName = nameTF.getText();
				//对输入名称长度的检测
				for(int i=0;i<tempName.length();i++){
					if(tempName.charAt(i)>= '\u4E00' && tempName.charAt(i)<='\u9FA5')
						lengthOfName += 2;
					else
						lengthOfName++;
				}
				if(lengthOfName>14){   //"<html>" + s1 + "<br>" + s2 + "</html>"
					s1 = "请勿超过14个字母或7个汉字！";
					checkresultAll[0] = false;
				}
				else if(lengthOfName==0){
						s1 = "请输入酒店名称！";
					checkresultAll[0] = false;
				}
				else{
					checkresultAll[0] = true;
				}
				//根据优惠政策类型检测 折扣数额 和 优惠介绍
				if(kindC.getSelectedIndex()==0){
					if(discountTF.getText().length()==0){
						s2 = "请输入折扣数额！";
						checkresultAll[1] = false;
					}
					else if(discountTF.getText().charAt(0)=='0'){
						s2 = "请输入正确的折扣数额！";
						checkresultAll[1] = false;
					}	
					else{
						checkresultAll[1] = true;
					}
				}
				else if(kindC.getSelectedIndex()==1){
					int lengthOfIntroduction = 0;
					String tempIntroduction = nameTF.getText();
					for(int i=0;i<tempIntroduction.length();i++){
						if(tempIntroduction.charAt(i)>= '\u4E00' && tempIntroduction.charAt(i)<='\u9FA5')
							lengthOfIntroduction += 2;
						else
							lengthOfIntroduction++;
					}
					if(lengthOfIntroduction>40){
						s2 = "请勿超过40个字母或20个汉字！";
						checkresultAll[1] = false;
					}
					else if(lengthOfIntroduction==0){
						s2 = "请输入优惠介绍！";
						checkresultAll[1] = false;
					}
					else{
						checkresultAll[1] = true;
					}
				}
				for(boolean tempboolean : checkresultAll){
					if(!tempboolean){
						isRight = false;
						break;
					}
					isRight = true;
				}
				if(!isRight)
					checkresult.setText(s1+"  "+s2+"  "+s3);
				else{
					promvo.setname(nameTF.getText());
					promvo.setkind(kindC.getSelectedItem().toString());
					if(kindC.getSelectedIndex()==0)
						promvo.setdiscount(Integer.valueOf(discountTF.getText()));
					else
						promvo.setintroduction(introductionTA.getText());
					if(vch.submitProm(accredit, promvo)){
						promotionlistui.updatePromlist();
						clear();
						vch.cancleMakeProm();
					}
					else{
						Font font = new Font("华文楷体",1,15);
					    UIManager.put("OptionPane.font", font);
					    UIManager.put("OptionPane.messageFont", font);
					    UIManager.put("OptionPane.buttonFont", font);
					    JOptionPane.showMessageDialog(null, "添加失败，原因不详！",
								"", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
	
	private void ComboBoxs(){
		String kindB[] = new String[numOfPromKind];
		kindB[0] = "折扣优惠";
		kindB[1] = "赠送礼品";
		//按钮确认订单类型判断用的是 if(kindC.getSelectedIndex()==0)
		
		kindC=new JComboBox<String>(kindB);
		kindC.setFont(new Font("华文楷体",1,15));
		kindC.setSize(textfield_width, textfield_height);
		kindC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = (String)kindC.getSelectedItem();
				if(s.equals(kindB[0])){
					checkresult.setText("");
					DorIL.setText("折扣：");
					nameTF.setText("");
					discountTF.setText("");
					discountTF.setVisible(true);
					percent.setVisible(true);
					introductionTA.setText("");
					introductionSP.setVisible(false);
				}
				else if(s.equals(kindB[1])){
					checkresult.setText("");
					DorIL.setText("优惠介绍：");
					nameTF.setText("");
					discountTF.setText("");
					discountTF.setVisible(false);
					percent.setVisible(false);
					introductionTA.setText("");
					introductionSP.setVisible(true);
				}
			}
		});
	}
	protected static void setaccredit(String s){
		accredit = s;
	}
	
	private static void clear(){
		nameTF.setText("");
		discountTF.setText("");
		introductionTA.setText("");
		promvo = new PromvoForHotel();
		checkresult.setText("");
		
		accredit = "";
	}	
}

