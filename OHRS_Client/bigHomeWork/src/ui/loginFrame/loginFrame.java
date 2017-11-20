package ui.loginFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.PasswordView;

import Runner.runner;
import image.imageLogin;
import ui.thread.loginFrameThread;

public class loginFrame extends JFrame{
	/**
	 * @author 楂樼繑
	 * @see 鏈被鏄櫥闄嗙晫闈㈢殑涓荤被锛屾兜鐩栦簡鐧婚檰鐣岄潰鐨勪富妗嗘灦
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * 鍚勫睘鎬ф剰涔変緷娆℃槸锛�
	 * 绯荤粺缁勪欢
	 * 瀹瑰櫒瀵硅薄
	 * 鐧婚檰鎸夐挳		
	 * 娉ㄥ唽鎸夐挳
	 * 鎵惧洖瀵嗙爜
	 * 绾跨▼
	 * 璐﹀彿鍖�
	 * 瀵嗙爜鍖�
	 */
	public static int sizeX = 455,sizeY=384;
	Toolkit toolkit ;
	runner runner ;
	Container container;
	public loginButton loginButton;
	public creatButton  creatButton;
	public findScrectButton findScrectButton;
	public textFeild textField_account;
	public JPasswordField textField_Screat;
	public exitButton exitButton;
	imageLogin imageLogin;
	loginFrameThread loginFrameThread;
	public loginFrame (runner runner){
		super();
		this.runner = runner;
		init();
		setSize();
		addButtons();
		setPlace();
		
	}
	private void setPlace() {
		// TODO Auto-generated method stub
		textField_account.getPlaceInformation(146, 232, 200, 30);
		textField_Screat.setBounds(146, 268, 200, 30);
	}
	private void addButtons() {
		// TODO Auto-generated method stub
		container.setLayout(null);
		container.setBackground(new Color(231, 247, 248));
		loginButton.addToFrame(container,146,305);
		findScrectButton.addToFrame(container,360,268 );
		creatButton.addToFrame(container,360,232);
		container.add(textField_account.textField);
		container.add(textField_Screat);
		exitButton.addToFrame(container,374,310);
		loginFrameThread.backlabel.addToFrame(container);
		loginFrameThread.userLabel.addToFrame(container);
	}
	private void init(){
		imageLogin = new imageLogin();
		toolkit = Toolkit.getDefaultToolkit();
		container = this.getContentPane();
		loginButton  = new loginButton(imageLogin.imageLogin,runner);
		creatButton  = new creatButton(imageLogin.imageCreat,runner);
		findScrectButton = new findScrectButton(imageLogin.imageFind,runner);
		textField_account = new textFeild(runner);
		textField_Screat = new JPasswordField();
		exitButton = new exitButton(imageLogin.imageExit,runner);
		loginFrameThread = new loginFrameThread();
	//	backgroundLabel = new backgroundLabel();
	}
	private void setSize(){
		this.setBounds(toolkit.getScreenSize().width/3, toolkit.getScreenSize().height/4, sizeX,sizeY);
	//	System.out.println( toolkit.getScreenSize().width /3+"  "+toolkit.getScreenSize().height/2);
	//	this.setBackground(Color.WHITE);
		//this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	
	/*	//甯冨眬娴嬭瘯鍑芥暟锟�
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
			System.out.println(e.getX()+"  "+e.getY());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	*/
	}
}
