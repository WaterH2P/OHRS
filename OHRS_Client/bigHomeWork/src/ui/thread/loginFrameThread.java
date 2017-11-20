package ui.thread;



import javax.swing.ImageIcon;

import ui.loginFrame.backgroundLabel;
import ui.loginFrame.userLabel;
public class loginFrameThread implements Runnable{
		Thread thread;
		public backgroundLabel backlabel;
		public userLabel userLabel;
		int  sleeptime = 1000;
		public loginFrameThread(){
			backlabel = new backgroundLabel();
			userLabel  = new userLabel();
			init();
		}
		private void init(){
			thread = new Thread(this);
			thread.start();
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				backlabel.setBackImg();
				try{
					Thread.sleep(sleeptime);
				}catch(InterruptedException e){
					backlabel.label.setIcon(new ImageIcon("src\\media\\imgForlogin\\error.jpg"));
				}
			}
		}
	
		
}
