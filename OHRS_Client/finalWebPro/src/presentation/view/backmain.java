package presentation.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class backmain extends JPanel {
	private PromotionViewControllerService controller;
	Image im=Toolkit.getDefaultToolkit().getImage("image/welcome.jpg");
	public void paintComponent(Graphics g) {  
		 super.paintComponent(g);   
		 g.drawImage(im, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  
	public backmain(PromotionViewControllerService controller){
		this.controller=controller;
		setLayout(null);
		JLabel label = new JLabel(new ImageIcon("image/头像.jpg"));
		label.setBounds(0, 0, 136, 144);
		add(label);
	}
}
