package presentation.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PromotionView extends JPanel{
	private PromotionViewControllerService controller;
	Image im=Toolkit.getDefaultToolkit().getImage("image/setting.jpg");
	public void paintComponent(Graphics g) {  
		 super.paintComponent(g);   
		 g.drawImage(im, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  
	public PromotionView (PromotionViewControllerService controller){
		this.controller=controller;
		setLayout(null);
		ButtonGroup bg =new ButtonGroup();
		
		JRadioButton timepro = new JRadioButton("节假日优惠制定");
		timepro.setBounds(237, 60, 174, 41);
		timepro.setBackground(Color.PINK);
		add(timepro);
		
		JRadioButton vippro = new JRadioButton("会员在特定商圈优惠制定");
		vippro.setBounds(237, 157, 243, 41);
		vippro.setBackground(Color.PINK);
		add(vippro);
		
		bg.add(timepro);
		bg.add(vippro);
		timepro.setSelected(true);
		
		JButton confirm = new JButton(new ImageIcon("image/确定1.jpg"));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(timepro.isSelected()){
					controller.timeproButtonClicked();
				}else{
					controller.vip_locationProButtonClicked();
				}
			}
		});
		confirm.setBounds(133, 247, 113, 41);
		add(confirm);
		
		JButton cancel = new JButton(new ImageIcon("image/取消1.jpg"));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancel.setBounds(429, 247, 113, 41);
		add(cancel);
	}
}
