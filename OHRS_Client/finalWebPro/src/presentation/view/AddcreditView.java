package presentation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddcreditView extends JPanel{
	private PromotionViewControllerService controller;
	Image im=Toolkit.getDefaultToolkit().getImage("image/setting.jpg");
	public void paintComponent(Graphics g) {  
		 super.paintComponent(g);   
		 g.drawImage(im, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  
	public AddcreditView(PromotionViewControllerService controller){
		

		this.controller=controller;
		setLayout(null);
		setSize(700,385);
		JLabel title = new JLabel("信用充值");
		title.setForeground(Color.GRAY);
		title.setFont(new Font("黑体", Font.PLAIN, 45));
		title.setBounds(240, 13, 197, 77);
		add(title);
		
		JLabel namelabel = new JLabel("用户名：");
		namelabel.setFont(new Font("黑体", Font.PLAIN, 15));
		namelabel.setForeground(Color.GRAY);
		namelabel.setBounds(163, 106, 72, 18);
		add(namelabel);
		
		JTextField name = new JTextField();
		name.setBounds(293, 103, 144, 24);
		name.setBackground(Color.PINK);
		name.setFont(new Font("黑体", Font.PLAIN, 15));
		add(name);
		name.setColumns(10);
		
		
		JLabel addlabel = new JLabel("充值数额：");
		addlabel.setForeground(Color.GRAY);
		addlabel.setFont(new Font("黑体", Font.PLAIN, 15));
		addlabel.setBounds(163, 162, 90, 18);
		add(addlabel);
		
		JTextField credit = new JTextField();
		credit.setBounds(293, 159, 144, 24);
		credit.setBackground(Color.PINK);
		credit.setFont(new Font("黑体", Font.PLAIN, 15));
		add(credit);
		credit.setColumns(10);
		
		JButton onehundred = new JButton(new ImageIcon("image/100.jpg"));
		onehundred.setBounds(140, 214, 113, 27);
		add(onehundred);
		onehundred.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				credit.setText("100");
			}
		});
		
		JButton twohundred = new JButton(new ImageIcon("image/200.jpg"));
		twohundred.setBounds(285, 214, 113, 27);
		add(twohundred);
		twohundred.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				credit.setText("200");
			}
		});
		
		
		JButton threehundred = new JButton(new ImageIcon("image/300.jpg"));
		threehundred.setBounds(443, 214, 113, 27);
		add(threehundred);
		threehundred.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				credit.setText("300");
			}
		});
		
		JButton confirm = new JButton(new ImageIcon("image/确定.jpg"));
		confirm.setBounds(194, 280, 113, 27);
		add(confirm);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String thename=name.getText();
				String thecredit=credit.getText();
				if(thename.length()!=9||Integer.parseInt(thecredit)<100||Integer.parseInt(thecredit)>3000){
				JOptionPane.showMessageDialog(null, "客户ID或充值信用值错误","", JOptionPane.ERROR_MESSAGE);
				}else{
					if(addcredit(thename,thecredit)){
						JFrame frame = new JFrame();					
						frame.setVisible(true);
						frame.getContentPane().setBackground(Color.WHITE);
						frame.setBounds(100, 100, 420, 164);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						 frame.getContentPane().setLayout(null);
						 					
						 JLabel lblNewLabel = new JLabel(new ImageIcon("image/充值成功.jpg"));
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
				}
			}
		});
		
		
		JButton cancel = new JButton(new ImageIcon("image/取消.jpg"));
		cancel.setBounds(372, 280, 113, 27);
		add(cancel);
		
		JLabel nametip = new JLabel("（请输入九位客户ID）");
		nametip.setFont(new Font("黑体", Font.PLAIN, 15));
		nametip.setForeground(Color.GRAY);
		nametip.setBounds(451, 106, 153, 18);
		add(nametip);
		
		JLabel credittip = new JLabel("（请输入整百数）");
		credittip.setFont(new Font("黑体", Font.PLAIN, 15));
		credittip.setForeground(Color.GRAY);
		credittip.setBounds(451, 162, 127, 18);
		add(credittip);
	}
		
	
	public boolean addcredit(String userid,String credit) {
		try {
			if(controller.addcredit(userid,credit)){	
				return true;
			}
			else{
				return false;
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
