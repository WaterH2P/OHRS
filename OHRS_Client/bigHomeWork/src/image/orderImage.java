package image;

import java.awt.Image;

import javax.swing.ImageIcon;

public class orderImage {
	public ImageIcon successImage[];
	public ImageIcon failImage[];
	public ImageIcon workImage[];
	public ImageIcon allImage[];
//	private int sizeX = 50,sizeY = 50;
//	private imgSize imgSize;
	public orderImage(){
		//imgSize = new imgSize();
		successImage = new ImageIcon[3];
		failImage = new ImageIcon[3];
		workImage = new ImageIcon[3];
		allImage = new ImageIcon[3];
		for(int i = 0; i<successImage.length;i++){
			allImage[i] =  new ImageIcon("media\\orderImage\\allOrder\\"+i+".png");
			successImage[i ]= new ImageIcon("media\\orderImage\\successOrder\\"+i+".png");
			failImage[i ] = new ImageIcon("media\\orderImage\\failOrder\\"+i+".png");
			workImage [ i ] = new ImageIcon("media\\orderImage\\countOrder\\"+i+".png");
		}
	}
}
