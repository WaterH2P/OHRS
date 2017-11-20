package image;

import javax.swing.ImageIcon;

public class errorImage {
	public ImageIcon nameImage;
	public ImageIcon passwardImage;
	public ImageIcon[] sureImage;
	public errorImage(){
		sureImage = new ImageIcon[3];
		nameImage = new ImageIcon("media\\errorImage\\name.png");
		passwardImage = new ImageIcon("media\\errorImage\\passward.png");
		for(int i =0; i< sureImage.length;i++){
			sureImage [i]= new ImageIcon("media\\errorImage\\button\\"+i+".png");
		}
	}
}
