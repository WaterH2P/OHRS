package ui.hotel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputOnlyNum implements KeyListener{
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar=e.getKeyChar();
		if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {
			
		} else {
			e.consume();  
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}

class Discount implements KeyListener{
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}

class InputNoSpace implements KeyListener{
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar=e.getKeyChar();
		if (keyChar==KeyEvent.VK_SPACE) {
			e.consume(); 
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}

class InputOnlyEnglish implements KeyListener{
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar=e.getKeyChar();
		if ((keyChar>='A'&& keyChar<='Z')
				||(keyChar>='a' && keyChar<='z')) {
			
		} else {
			e.consume();  
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}	
}

class InputOnlyEnglishOrChinese implements KeyListener{
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar=e.getKeyChar();
		if ((keyChar>='A'&& keyChar<='Z')
				||(keyChar>='a' && keyChar<='z')
				||(keyChar>= '\u4E00' && keyChar<='\u9FA5')) {
			
		} else {
			e.consume();  
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}	
}