package image;

import javax.swing.ImageIcon;

public class infoImage {
	public ImageIcon infoimage[] ;
	public infoImage(){
		infoimage = new ImageIcon[3];
		for(int i =0;i<infoimage.length;i++){
			infoimage [i ] = new ImageIcon("media\\infoImage\\"+i+".png");
		}
	}
}
