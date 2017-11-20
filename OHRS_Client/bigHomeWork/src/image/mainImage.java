package image;

import java.awt.Label;

import javax.swing.ImageIcon;

public class mainImage {
	public ImageIcon[] searchImage = new ImageIcon[3];
	public ImageIcon LabelImage ; 
	public ImageIcon quickImage[];
	imgSize imgSize;
	int size_X = 0;
	public mainImage(){
		imgSize = new imgSize();
		initImage();
	}
	public void initImage(){
		for(int i = 0; i<searchImage.length;i++){
			searchImage[i ] = imgSize.getIconRight(new ImageIcon("media\\mainImage\\"+i+".png"),55,40);
		}
		LabelImage =  new ImageIcon("media\\imageLabel\\во╫ШЁг.jpg");
		double number = (double)LabelImage.getIconHeight()/(double)LabelImage.getIconWidth();
		//System.out.println(819*number);
		LabelImage = imgSize.getIconRight(LabelImage, 160/number, 160);
		quickImage = new ImageIcon[11];
			for(int i=0;i<quickImage.length;i++){
				quickImage[i ] = new ImageIcon("media\\imgForlogin\\0 "+i+".jpg");
			//	System.out.println(imageIconForBackground[i].getIconHeight());
			}
		}
}
