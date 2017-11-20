package image;

import javax.swing.ImageIcon;

import org.omg.CORBA.PUBLIC_MEMBER;

public class meanButtonImage {
	public ImageIcon[]  orderImage = new ImageIcon[3];
	public ImageIcon[]  infoImage = new ImageIcon[3];
	public ImageIcon[]  hotalImage = new ImageIcon[3];
	public ImageIcon[]  ExitImage = new ImageIcon[3];
	public meanButtonImage(){
		
		initOrderImage();
	}
	private void initOrderImage() {
		// TODO Auto-generated method stub
		for(int i =0;i< orderImage.length;i++){
			orderImage[i ]= new ImageIcon("media\\meanImage\\order\\"+i+".png");
			infoImage[i ] =  new ImageIcon("media\\meanImage\\info\\"+i+".png");
			hotalImage[i ] = new ImageIcon("media\\meanImage\\hotal\\"+i+".png");
			ExitImage[i] = new ImageIcon("media\\meanImage\\Exit\\"+i+".png");
		}
	}
	
}
