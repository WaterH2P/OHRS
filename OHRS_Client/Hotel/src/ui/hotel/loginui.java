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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import controller.view_controller_hotelLogin;
import factory.hotelui_main;

public class loginui extends JPanel{
	/**
	 * @author: hzp
	 * @version: 1.0.20161209
	 */
	
	/*
	 * 监控登陆界面的请求
	 * 比如 跳转注册界面、登录请求
	 */
	private view_controller_hotelLogin vch = new view_controller_hotelLogin();
	
	/*
	 * 常量值
	 * 用于规定输入框和选择框的大小
	 * 也使用于布局中status的位置确定
	 */
	private final int frame_width=450;
	private final int frame_height=340;
	private final int label_width = 80;
	private final int label_height = 40;
	private final int textfield_width = 180;
	private final int textfield_height = 40;
	private final int button_width = 120;
	private final int button_height = 40;
	
	private final int upSize = 30;
	
	private JLabel IDL;
	private JLabel passwordL;
	
	private static JTextField IDTF;
	private static JPasswordField passwordPF;
	
	private JButton signupB;
	private JButton findpasswordB;
	private JButton loginB;
	private JButton exitB;
	
	private Image setting;
	private ImageIcon exitI;
	private ImageIcon exitI2;
	
	public loginui(){
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
		Buttons();
		
		//设置界面中一些常量值
		final int label_gap=40;	
		final int label_textfield_gap=90;
		
		//创建JPanel，并添加标识、文本框、选择框、按钮
		this.setOpaque(false);
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(frame_width,frame_height);
				
		// 为方便修改，x和y保存jpanel的大小
		int x=frame_width/10;
		int y=160;
		
		//标识的添加和排版
		int labelg=label_gap;
		int textw=textfield_width;
		int ltg=label_textfield_gap;
		
		this.add(IDL);
		this.add(passwordL);
		IDL.setLocation(x, y);
		passwordL.setLocation(x, y+labelg);
		//输入框的添加和排版
		this.add(IDTF);
		this.add(passwordPF);
		IDTF.setLocation(x+ltg, y);
		passwordPF.setLocation(x+ltg, y+labelg);
		
		this.add(loginB);
		this.add(signupB);
		this.add(findpasswordB);
		loginB.setLocation(x+ltg, y+labelg*2+10);
		signupB.setLocation(x+ltg+textw, y);
		findpasswordB.setLocation(x+ltg+textw, y+labelg);
		
		this.add(exitB);
		exitB.setLocation(this.getWidth()-exitB.getWidth(), 0);
	}
	
	private void Images(){
		setting = Toolkit.getDefaultToolkit().getImage("image/HloginS.jpg");
		exitI = new ImageIcon("image/HLoginExit3.jpg");
		exitI2 = new ImageIcon("image/HLoginExit4.jpg");
	}
	
	private void Labels(){
		IDL = new JLabel("账户:",JLabel.RIGHT);
		IDL.setSize(label_width, label_height);
		IDL.setFont(new Font("华文楷体",4,18));
		
		passwordL = new JLabel("密码:",JLabel.RIGHT);
		passwordL.setSize(label_width, label_height);
		passwordL.setFont(new Font("华文楷体",4,18));
	}
	
	private void TextFields(){
		IDTF = new JTextField();
		IDTF.setMargin(new Insets(0, 10, 0, 0));
		IDTF.setSize(textfield_width, textfield_height);
		IDTF.setFont(new Font("华文楷体",1,18));
		IDTF.setForeground(Color.black);
		IDTF.setOpaque(false);
		IDTF.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				IDTF.setBorder(new LineBorder(new Color(0, 191, 255)));
				IDTF.setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				IDTF.setBorder(new LineBorder(Color.gray));
				IDTF.setOpaque(false);
			}  
		});
		
		passwordPF = new JPasswordField();
		passwordPF.setSize(textfield_width, textfield_height);
		passwordPF.setFont(new Font("华文楷体",1,18));
		passwordPF.setForeground(Color.black);
		passwordPF.setOpaque(false);
		passwordPF.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				passwordPF.setBorder(new LineBorder(new Color(0, 191, 255)));
				passwordPF.setOpaque(true);
			}  
			public void focusLost(FocusEvent e) {
				passwordPF.setBorder(new LineBorder(Color.gray));
				passwordPF.setOpaque(false);
			}  
		});
	}
	
	private void Buttons(){
		Font font = new Font("华文楷体",1,15);
	    UIManager.put("OptionPane.font", font);
	    UIManager.put("OptionPane.messageFont", font);
	    UIManager.put("OptionPane.buttonFont", font);
		
		signupB = new JButton("注册账户");
		signupB.setFont(new Font("华文新魏",1,18));
		signupB.setForeground(Color.orange);
		signupB.setBorderPainted(false);
		signupB.setOpaque(false);
		signupB.setContentAreaFilled(false);
		signupB.setFocusPainted(false);
		signupB.setSize( button_width, button_height);
		signupB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signupB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				signupB.setForeground(Color.yellow);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signupB.setForeground(Color.orange);
			}
		});
		signupB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vch.hotelsignup();
			}
		});
			
		findpasswordB = new JButton("找回密码");
		findpasswordB.setFont(new Font("华文新魏",1,18));
		findpasswordB.setForeground(Color.orange);
		findpasswordB.setBorderPainted(false);
		findpasswordB.setOpaque(false);
		findpasswordB.setContentAreaFilled(false);
		findpasswordB.setFocusPainted(false);
		findpasswordB.setSize( button_width, button_height);
		findpasswordB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		findpasswordB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				findpasswordB.setForeground(Color.yellow);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				findpasswordB.setForeground(Color.orange);
			}
		});
		findpasswordB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "请拨打15155551111！","", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		loginB = new JButton("登录");
		loginB.setFont(new Font("华文新魏",1,20));
		loginB.setForeground(Color.white);
		loginB.setBackground(new Color(0, 191, 255));
		loginB.setBorderPainted(false);
		loginB.setFocusPainted(false);
		loginB.setSize( textfield_width, textfield_height);
		loginB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				loginB.setBackground(new Color(0, 220, 255));   
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginB.setBackground(new Color(0, 191, 255));  
			}
		});
		loginB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String accredit = "";
					if(IDTF.getText().length()>0)
						accredit = vch.login(IDTF.getText(), new String(passwordPF.getPassword()));
					//如果传回的String是"false"，表明登录失败
					//如果传回的String是"Online"，表明已登录
					//否则传回的是 授权码
				if(accredit.equals("Online"))
					JOptionPane.showMessageDialog(null, "账号已登录！","", JOptionPane.ERROR_MESSAGE);
				else if(accredit.equals("false"))
					JOptionPane.showMessageDialog(null, "账号或密码错误！","", JOptionPane.ERROR_MESSAGE);
				else{
					//授权码的设置
					changeui.setaccredit(accredit);
					inforui.setaccredit(accredit);
					promotionui.setaccredit(accredit);
					promotionlistui.setaccredit(accredit);
					orderui.setaccredit(accredit);
					orderlistui.setaccredit(accredit);
					hotelui_main.get_main_hotelui().setid(IDTF.getText());
					clear();
					vch.loginsuccessfully();	
				}
			}
		});
		
		exitB = new JButton(exitI);
		exitB.setSize(upSize, upSize);
		exitB.setMargin(new Insets(-1,-1,-1,-1));
		exitB.setBorderPainted(false);
		exitB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				exitB.setIcon(exitI2);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitB.setIcon(exitI); 
			}
		});
		exitB.addActionListener(new ActionListener(){
			 @Override
		     public void actionPerformed(ActionEvent e) {
		     System.exit(0);
		     }
		});
	}
	
	protected static void clear(){
		IDTF.setText("");
		passwordPF.setText("");
	}
}
