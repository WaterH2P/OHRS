package ui.outFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Runner.runner;

public class vauleFrame extends JFrame{
	public runner runner;
	public ImageIcon[] imageIcons = new ImageIcon[2];
	public ArrayList<String> vaule;
	public int begins = 70,beginy =50;
	public vauleFrame(){
		this.setBounds(500,300, 700,500);
		this.setVisible(true);
		Container container = this.getContentPane();
		imageIcons[0] = new ImageIcon("image\\弹窗.jpg");
		imageIcons[1] = new ImageIcon("image\\保存.png");
		vaule = new ArrayList<String>();
		vaule.add("管理员增加100信用值,剩余100；2016/12/25");
		vaule.add("鸿星酒店增加1000信用值，剩余1000；2016/12/25");
		vaule.add("鸿星酒店扣除1000信用值，剩余100；2016/12/25");
		vaule.add("鸿星酒店增加100信用值，剩余200；2016/12/25");
		vaule.add("好再来酒店扣除1000信用值，剩余-800；2016/12/25");
		vaule.add("充值1000信用值，剩余200；2016/12/25");
		this.addMouseListener(new exitListener(this));
		this.addMouseWheelListener(new exitListener(this));
		repaint();
	}
	public void setVaule(ArrayList<String> vauled){
		vaule = (ArrayList<String>) vauled.clone();
		repaint();
	}
	public void paint(Graphics g){
		g.setColor(new Color(225	, 102, 142));
		g.setFont(new Font("宋体",Font.BOLD,24));
		g.drawImage(imageIcons[0].getImage(), 0, 0, this);
		g.drawImage(imageIcons[1].getImage(), 550,420, this);
		for(int i=0;i<vaule.size();i++){
			if(beginy+i*30<=400&&beginy+i*30>=100){
				g.drawString(vaule.get(i), begins, beginy+i*30);
			}
		}
	}
	/*
	public static void main(String[]args){
		vauleFrame vauleFrame =new vauleFrame();
		vauleFrame.setVisible(true);
	}
	*/
}
class exitListener implements MouseListener,MouseWheelListener{
	public vauleFrame vauleFrame;
	
	public exitListener(vauleFrame vauleFrame) {
		// TODO Auto-generated constructor stub
		this.vauleFrame =vauleFrame;
		
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		int i = e.getWheelRotation();
		if(i<0){
				vauleFrame.beginy-=5;
				vauleFrame.repaint();
		}
		else{
			vauleFrame.beginy+=5;
			vauleFrame.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>550&&e.getX()<585&&e.getY()>420&&e.getY()<455){
			vauleFrame.setVisible(false);
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}