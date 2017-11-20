package ui.abstrct;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * 
 * @author 高翔
 * @version 1.0
 * @see 规定了界面的位置与大小，以及可见与不可见等基本方法�
 */
public abstract class frameSize extends JFrame{
	public static int sizeX =700,sizeY = 600;
	Color colour =new Color(231, 247, 248);
	protected Toolkit toolkit;
	/**
	 * @param 规定界面大小与位置的方法
	 */
	public void initOfSize(){
		toolkit = Toolkit.getDefaultToolkit();
		this.setBounds(toolkit.getScreenSize().width/5, toolkit.getScreenSize().height/8, sizeX, sizeY);
		//System.out.println(toolkit.getScreenSize().width/5*3+"  "+toolkit.getScreenSize().height/8*6);
		this.setResizable(false);
	}
	public void setVT(){
		this.setVisible(true);
	}
	public void setVF(){
		this.setVisible(false);
	}
}
