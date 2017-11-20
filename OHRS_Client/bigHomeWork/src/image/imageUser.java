package image;

import javax.swing.ImageIcon;

public class imageUser {
	public ImageIcon[] imageIcon;
	public imageUser(){
		 imageIcon = new ImageIcon[5];
		 init();
	}
	public void init(){
		 for(int i=0 ; i<5;i++){
			 imageIcon[i] = new ImageIcon("media\\userImage\\"+"0 "+i+".jpg");
			// System.out.println(imageIcon[i].getIconHeight());
		 }
	}
}
