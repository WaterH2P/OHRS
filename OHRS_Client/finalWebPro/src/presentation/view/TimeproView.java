package presentation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimeproView extends JPanel{
	private PromotionViewControllerService controller;
	Image im=Toolkit.getDefaultToolkit().getImage("image/setting.jpg");
	public void paintComponent(Graphics g) {  
		 super.paintComponent(g);   
		 g.drawImage(im, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  
	public TimeproView(PromotionViewControllerService controller){
		this.controller=controller;
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.BLACK);
		String year[]={"2016","2017","2018"};
		String month[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
		String day[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
						"22","23","24","25","26","27","28","29","30","31"};
		
		setLayout(null);
		setSize(700,385);
		JComboBox startyear = new JComboBox(year);
		startyear.setBounds(201, 102, 69, 24);
		startyear.setEditable(false);
		add(startyear);
		
		JComboBox startmonth = new JComboBox(month);
		startmonth.setBounds(354, 102, 52, 24);
		add(startmonth);
		
		JComboBox startday = new JComboBox(day);
		startday.setBounds(500, 102, 52, 24);
		add(startday);
		
		JComboBox finishyear = new JComboBox(year);
		finishyear.setBounds(201, 154, 69, 24);
		add(finishyear);
		
		JComboBox finishmonth = new JComboBox(month);
		finishmonth.setBounds(354, 154, 52, 24);
		add(finishmonth);
		
		JComboBox finishday = new JComboBox(day);
		finishday.setBounds(500, 154, 52, 24);
		add(finishday);
		
		JLabel label = new JLabel("年");
		label.setBounds(306, 104, 24, 21);
		add(label);
		
		JLabel label_1 = new JLabel("月");
		label_1.setBounds(445, 105, 29, 18);
		add(label_1);
		
		JLabel label_2 = new JLabel("日");
		label_2.setBounds(595, 108, 72, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("年");
		label_3.setBounds(306, 157, 24, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("月");
		label_4.setBounds(445, 154, 29, 29);
		add(label_4);
		
		JLabel label_5 = new JLabel("日");
		label_5.setBounds(595, 171, 72, 18);
		add(label_5);
		
		JLabel label_6 = new JLabel("开始时间");
		label_6.setBounds(101, 105, 66, 18);
		add(label_6);
		
		JLabel label_7 = new JLabel("结束时间");
		label_7.setBounds(101, 157, 69, 21);
		add(label_7);
		
		JLabel label_8 = new JLabel("特定时间促销策略制定");
		label_8.setFont(new Font("黑体", Font.PLAIN, 30));
		label_8.setBounds(191, 43, 305, 31);
		add(label_8);
		
		
		JButton cancel = new JButton(new ImageIcon("image/取消1.jpg"));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.makepromotionButtonClicked();
			}
		});
		cancel.setBounds(439, 318, 113, 41);
		add(cancel);
		
		JLabel label_9 = new JLabel("折扣");
		label_9.setBounds(264, 209, 66, 24);
		add(label_9);
		
		JTextField discount = new JTextField();
		discount.setBounds(346, 209, 39, 24);
		add(discount);
		discount.setColumns(10);
		
		JLabel label_10 = new JLabel("%  (输入两位数字)");
		label_10.setFont(new Font("宋体", Font.PLAIN, 22));
		label_10.setBounds(415, 209, 196, 24);
		add(label_10);
		
		String nowpromotion=gettimepromotion();
		String str=" 当前促销为： "+nowpromotion.substring(0,4)+"年"+nowpromotion.substring(4,6)+"月"+nowpromotion.substring(6,8)+"日"+"————"+nowpromotion.substring(8,12)+"年"+nowpromotion.substring(12,14)+"月"+nowpromotion.substring(14,16)+"日"+"  "+nowpromotion.substring(16,18)+"%";
		
		
		JLabel lblNewLabel = new JLabel(str);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(64, 268, 600, 18);
		add(lblNewLabel);
		
		JButton confirm = new JButton(new ImageIcon("image/确定1.jpg"));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//添加事件
				String starttime=startyear.getSelectedItem().toString()+startmonth.getSelectedItem().toString()+startday.getSelectedItem().toString();
				String finishtime=finishyear.getSelectedItem().toString()+finishmonth.getSelectedItem().toString()+finishday.getSelectedItem().toString();
				String number=discount.getText();
				
				maketimepromotion(starttime,finishtime,number);
				
				JFrame frame = new JFrame();					
				frame.setVisible(true);
				frame.getContentPane().setBackground(Color.WHITE);
				frame.setBounds(100, 100, 420, 164);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 frame.getContentPane().setLayout(null);
				 					
				 JLabel lblNewLabel = new JLabel(new ImageIcon("image/制定成功.jpg"));
				 	lblNewLabel.setBounds(0, 0, 402, 117);
				 frame.getContentPane().add(lblNewLabel);
				 					
				 						
				 					
				 	JButton cancel = new JButton(new ImageIcon("image/确定1.jpg"));
				 		cancel.addActionListener(new ActionListener() {
				 		public void actionPerformed(ActionEvent e) {
				 	frame.dispose();
				 			}
				 		});
				 		cancel.setBounds(129, 77, 113, 41);
					frame.getContentPane().add(cancel);
			}
		});
		confirm.setBounds(198, 318, 113, 41);
		add(confirm);
	}
	public void maketimepromotion(String starttime, String finishtime, String number) {
		controller.maketimepromotion(starttime,finishtime,number);
		
	}
	
	public String gettimepromotion(){
		return controller.gettimepromotion();
	}
}
