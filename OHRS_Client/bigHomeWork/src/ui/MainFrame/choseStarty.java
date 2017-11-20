package ui.MainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Runner.runner;

public class choseStarty extends JFrame{
	public ImageIcon back = new ImageIcon("image\\优惠方案.jpg");
	public int sure_X = 220,sure_Y=200;
	public ArrayList<String> starty = new ArrayList<String>();
	public choseStarty(runner runner){
		Toolkit toolkit = this.getToolkit();
		this.setBounds(toolkit.getScreenSize().width/3, toolkit.getScreenSize().height/4, 300	, 235);
		this.setUndecorated(true);
		this.setVisible(false);
		this.addMouseListener(new startyListener(runner,this));
		starty.add("元旦节期间八折优惠");
		starty.add("预订豪华单人间，赠送100元代金卷");
		starty.add("入住本酒店赠送高档毛绒玩偶");
	}
	public void paintStarty(ArrayList<String>info){
		this.starty = (ArrayList<String>) info.clone();
	}
	/*
	public static void main(String[]args){
		new choseStarty();
	}
	*/
	public void paint(Graphics g){
		g.setColor(new Color(225	, 102, 142));
		g.setFont(new Font("宋体",Font.BOLD,16));

		g.drawImage(back.getImage(), 0, 0, this);
		g.drawString(starty.get(0), 30, 100);
		for(int i=0;i<starty.size()-1;i++){
			g.drawString(starty.get(1+i), 30, 160+30*i);
		}
	}
}
class startyListener implements MouseListener{
	
	choseStarty vauleNotEnough;
	runner runner;
	public startyListener(runner runner,choseStarty choseStarty){
		this.vauleNotEnough =choseStarty;
		this.runner=runner;
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>30&&e.getX()<340&&e.getY()>100&&e.getY()<125){
			runner.choseVaule(1);
		}
		else{
			for(int i=0;i<vauleNotEnough.starty.size()-1;i++){
				if(e.getY()>160+30*i&&e.getY()<190+30*i&&e.getX()>30&&e.getX()<340){
					runner.choseVaule(i+1);
				}
			}
		}
	}

}
