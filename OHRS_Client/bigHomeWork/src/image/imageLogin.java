package image;

import javax.swing.ImageIcon;

public class imageLogin {
	public ImageIcon[] imageIconForBackground;
	public ImageIcon[] imageLogin;
	public ImageIcon[] imageCreat;
	public ImageIcon[] imageFind;
	public ImageIcon[] imageExit;
	public imageLogin(){
	//	给图标对象赋值
		imageLogin = new ImageIcon[3];
		imageCreat = new ImageIcon[3];
		imageExit = new ImageIcon[3];
		imageFind = new ImageIcon[3];
		imageIconForBackground = new ImageIcon[3];
		for(int i=0;i<imageIconForBackground.length;i++){
			imageExit [i ] = new ImageIcon("media\\imgForlogin\\exit\\"+i+".jpg");
			imageIconForBackground[i ] = new ImageIcon("media\\imgForlogin\\"+i+".jpg");
			imageLogin[i] = new ImageIcon("media\\imgForlogin\\login\\"+i+".jpg");
			imageCreat[i ]=new ImageIcon("media\\imgForlogin\\creat\\"+i+".png");
			imageFind[i ] = new ImageIcon("media\\imgForlogin\\findBack\\"+i+".png");
		//	System.out.println(imageIconForBackground[i].getIconHeight());
		}
	}
}
