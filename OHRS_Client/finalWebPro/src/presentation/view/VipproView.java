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

public class VipproView extends JPanel{
	private PromotionViewControllerService controller;
	Image im=Toolkit.getDefaultToolkit().getImage("image/setting.jpg");
	public void paintComponent(Graphics g) {  
		 super.paintComponent(g);   
		 g.drawImage(im, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  
	public VipproView(PromotionViewControllerService controller){
		setLayout(null);
		setSize(700,385);
		JLabel levelposition = new JLabel("会员在特定商圈优惠制定");
		levelposition.setFont(new Font("黑体", Font.PLAIN, 18));
		levelposition.setBounds(39, 208, 210, 56);
		add(levelposition);
		
		JLabel label = new JLabel("会员等级制定");
		label.setFont(new Font("黑体", Font.PLAIN, 18));
		label.setBounds(247, 21, 108, 52);
		add(label);
		
		JTextField uplevel = new JTextField();
		uplevel.setBounds(276, 86, 86, 24);
		add(uplevel);
		uplevel.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("会员升级所需信用值为：");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(73, 70, 176, 56);
		add(lblNewLabel_1);
		
		String shangquan[]={"南京","上海","北京"};
		JComboBox position = new JComboBox(shangquan);
		position.setBounds(452, 226, 100, 24);
		add(position);
		
		JLabel label_1 = new JLabel("等级");
		label_1.setBounds(263, 229, 44, 18);
		add(label_1);
		
		JLabel label_2 = new JLabel("商圈");
		label_2.setBounds(417, 229, 44, 18);
		add(label_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 171, 700, 4);
		add(panel);
		
		JButton levelconfirm = new JButton(new ImageIcon("image/确定1.jpg"));
		levelconfirm.setBounds(432, 85, 113, 41);
		add(levelconfirm);
		levelconfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				 	uplevel.setText("");
				 			}
				 		});
				 		cancel.setBounds(129, 77, 113, 41);
					frame.getContentPane().add(cancel);
			}
		});
		
		JButton cancel = new JButton(new ImageIcon("image/取消1.jpg"));
		cancel.setBounds(432, 295, 113, 41);
		add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.makepromotionButtonClicked();
			}
		});
		
		JTextField smalllevel = new JTextField();
		smalllevel.setBounds(298, 226, 37, 24);
		add(smalllevel);
		smalllevel.setColumns(10);
		
		JLabel label_3 = new JLabel("——");
		label_3.setBounds(340, 229, 30, 18);
		add(label_3);
		
		JTextField biglevel = new JTextField();
		biglevel.setColumns(10);
		biglevel.setBounds(366, 226, 37, 24);
		add(biglevel);
		
		
		JLabel label_4 = new JLabel("折扣");
		label_4.setBounds(558, 229, 37, 18);
		add(label_4);
		
		JTextField discount = new JTextField();
		discount.setBounds(600, 226, 37, 24);
		add(discount);
		discount.setColumns(10);
		
		JLabel label_5 = new JLabel("%");
		label_5.setBounds(651, 226, 35, 24);
		add(label_5);
		
		JButton discountconfirm = new JButton(new ImageIcon("image/确定1.jpg"));
		discountconfirm.setBounds(106, 295, 113, 41);
		add(discountconfirm);
		discountconfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String level1=smalllevel.getText();
				String level2=biglevel.getText();
				String pos=position.getSelectedItem().toString();
				String dis=discount.getText();
				//makelevelpromotion(level1,level2,pos,dis);
				
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
				 	uplevel.setText("");
				 			}
				 		});
				 		cancel.setBounds(129, 77, 113, 41);
					frame.getContentPane().add(cancel);
			}
		});
		
		
	}
	public void makelevelpromotion(String level1, String level2, String pos,String dis) {
		controller.makelevelpromotion(level1,level2,pos,dis);
		
	}
}
