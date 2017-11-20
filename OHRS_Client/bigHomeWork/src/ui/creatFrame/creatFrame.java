package ui.creatFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Runner.runner;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class creatFrame extends JFrame {

	public JPanel contentPane;
	public ArrayList<String> info = new ArrayList<String>();
	public exitListener exitListener;
	public updateListener updateListener;
	public JTextField name;
	public JTextField sex;
	public JTextField birthday;
	public JTextField VIP;
	public JTextField phone;
	public JPasswordField passwordField;
	public JPasswordField passwordField_1;
	public runner runner;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public creatFrame(runner runner) {
		exitListener = new exitListener(runner);
		updateListener = new updateListener(runner);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 343);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(237, 243, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\网上预定系统\\bigHomeWork\\image\\注册图片.jpg"));
		lblNewLabel.setBounds(0, 0, 418, 302);
		contentPane.add(lblNewLabel);
		
		JButton okButton = new JButton("");
		okButton.addActionListener(updateListener
		);
		okButton.setBounds(83, 312, 93, 23);
		contentPane.add(okButton);
		okButton.setIcon(new ImageIcon("image\\0.png"));
		
		okButton.setRolloverIcon(new ImageIcon("image\\2.png"));
		okButton.setPressedIcon(new ImageIcon("image\\1.png"));
		okButton.setContentAreaFilled(false);
	
		okButton.setContentAreaFilled(false);
		okButton.setFocusable(false);
		okButton.setBorderPainted(false);
		
		JButton exitButton = new JButton("");
		exitButton.setBounds(242, 312, 93, 23);
		exitButton.setIcon(new ImageIcon("image\\0.jpg"));
		exitButton.addActionListener(exitListener);
		exitButton.setRolloverIcon(new ImageIcon("image\\2.jpg"));
		exitButton.setPressedIcon(new ImageIcon("image\\1.jpg"));
		exitButton.setContentAreaFilled(false);
	
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusable(false);
		exitButton.setBorderPainted(false);
		contentPane.add(exitButton);
		
		name = new JTextField();
		name.setBackground(Color.BLACK);
		name.setForeground(Color.GRAY);
		name.setBounds(83, 70, 66, 21);
		contentPane.add(name);
		name.setColumns(10);
		name.setBorder (null);
		name.setBackground (null);
		sex = new JTextField();
		sex.setEditable(true);
		sex.setText("");
		sex.setBounds(83, 114, 66, 21);
		contentPane.add(sex);
		sex.setColumns(10);
		sex.setBorder (null);
		sex.setBackground (null);
		birthday = new JTextField();
		birthday.setBounds(83, 164, 122, 21);
		contentPane.add(birthday);
		birthday.setColumns(10);
		birthday.setBorder (null);
		birthday.setBackground (null);
		VIP = new JTextField();
		VIP.setBounds(119, 199, 145, 28);
		contentPane.add(VIP);
		VIP.setColumns(10);
		VIP.setBorder (null);
		VIP.setBackground (null);
		phone = new JTextField();
		phone.setEnabled(true);
		phone.setEditable(true);
		phone.setText("");
		phone.setBounds(119, 247, 145, 28);
		contentPane.add(phone);
		phone.setColumns(10);
		phone.setBorder (null);
		phone.setBackground (null);
		passwordField = new JPasswordField();
		passwordField.setBounds(253, 70, 122, 21);
		contentPane.add(passwordField);
		passwordField.setBorder (null);
		passwordField.setBackground (null);
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(267, 114, 136, 21);
		contentPane.add(passwordField_1);
		passwordField_1.setBorder (null);
		passwordField_1.setBackground (null);
	}
	
	/*
	public static void main(String[]args){
		creatFrame creatFrame = new creatFrame();
		creatFrame.setVisible(true);
	}
	*/
}
