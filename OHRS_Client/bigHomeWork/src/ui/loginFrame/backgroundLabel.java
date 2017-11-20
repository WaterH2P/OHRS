package ui.loginFrame;

import java.awt.Container;
import java.awt.Graphics;

import javax.naming.InitialContext;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import image.imageLogin;
import image.imgSize;

import java.awt.Container;

public class backgroundLabel {
		public JLabel label;
		imageLogin imageLogin;
		ImageIcon imageOut[];
		private int size_X = 449;
		private int size_Y = 210;
		public int backgroundInter=1;
		public backgroundLabel(){
			init();
			setBackImg();
		}
		public void addToFrame(Container container){
			container.add(label);
			label.setBounds(0, 0, size_X,size_Y);
		} 
		private void init() {
			// TODO Auto-generated method stub
			label = new JLabel();
			imageLogin = new imageLogin();
			imageOut =  imageLogin.imageIconForBackground;
		}
		public void setBackImg(){
			label.setIcon(imageOut[backgroundInter]);
			changeBackground();
			//imageInside =  imgSize.getIconRight(imageLogin.imageIconForBackground[backgroundInter],size_X,size_Y);
		}
		private void changeBackground() {
			// TODO Auto-generated method stub
			backgroundInter++;
			if(backgroundInter == imageLogin.imageIconForBackground.length){
				backgroundInter = 0;
			}
			
		}
}
