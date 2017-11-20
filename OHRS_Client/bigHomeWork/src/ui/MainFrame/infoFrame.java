package ui.MainFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Runner.runner;
import clientPo.poController;
import ui.error.nameError;
import ui.outFrame.vauleFrame;

public class infoFrame extends JFrame{
	public ImageIcon[]icons =new ImageIcon[8];
	public ImageIcon user= new ImageIcon("image\\头像.png");
	public int x=0,y=2,z = 4;
	public int could =2,keep =5, exit =7;
	public runner runner;
	public ImageIcon[] imageIcons =new ImageIcon[9];
	public ArrayList<String> info;
	public JTextField name;
	public JTextField sex;
	public JTextField phone;
	public JTextField birthday;
	public vauleFrame vauleFrame;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
					infoFrame frame = new infoFrame();
					frame.setVisible(true);
				
	}
	 */
	/**
	 * Create the frame.
	 */
	public infoFrame(runner runner) {
		Toolkit toolkit = this.getToolkit();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(toolkit.getScreenSize().width/4, toolkit.getScreenSize().height/5, 700, 500);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imageIcons[0] = new ImageIcon("image\\背景.jpg");
		imageIcons[1] = new ImageIcon("image\\用户信息查看.png");
		imageIcons[2] = new ImageIcon("image\\可编辑.png");
		imageIcons[3] = new ImageIcon("image\\不可编辑.png");
		imageIcons[4] = new ImageIcon("image\\保存.png");
		imageIcons[5] = new ImageIcon("image\\保存不可选.png");
		imageIcons[6] = new ImageIcon("image\\取消.png");
		imageIcons[7] = new ImageIcon("image\\取消不可选.png");
		imageIcons[8] = new ImageIcon("image\\信用值.png");
		icons[0] = new ImageIcon("image\\信息查看.png");
		icons[1] = new ImageIcon("image\\选下去.png");
		icons[2] = new ImageIcon("image\\账单管理.png");
		icons[3] = new ImageIcon("image\\账单管理玄.png");
		icons[4] = new ImageIcon("image\\酒店预订.png");
		icons[5] = new ImageIcon("image\\酒店预订玄.png");
		icons[6] = new ImageIcon("image\\退出.png");
		this.addMouseListener(new infoPanelListener(runner,this));
		info = new ArrayList<String>();
		info.add("高翔");
		info.add("男");
		info.add("1000");
		info.add("1997/2/28");
		info.add("18805156570");
		info.add("普通会员");
		info.add("630268696");
		name = new JTextField();
		sex = new JTextField();
		phone = new JTextField();
		birthday = new JTextField();
		name.setBackground(null);
		name.setBorder(null);
		sex.setBackground(null);
		sex.setBorder(null);
		phone.setBackground(null);
		phone.setBorder(null);
		birthday.setBackground(null);
		birthday.setBorder(null);
		name.setText(info.get(0));
		sex.setText(info.get(1));
		birthday.setText(info.get(3));
		phone.setText(info.get(4));
		vauleFrame =new vauleFrame();
		vauleFrame.setVisible(false);
		this.runner =runner;
	}
	public void paint(Graphics g){
		g.drawImage(imageIcons[0].getImage()	, 0, 0, this);
		g.drawImage(imageIcons[1].getImage(), 180, 33, this);
		g.drawImage(imageIcons[could]	.getImage(), 240, 340, this);
		g.drawImage(imageIcons[keep].getImage(), 440, 340, this);
		g.drawImage(imageIcons[exit].getImage(), 520, 340, this);
		g.drawImage(user.getImage(), 40, 33	, this);
		g.drawImage(icons[1].getImage(), 40, 168, this);
		g.drawImage(icons[y].getImage(), 40, 219, this);
		g.drawImage(icons[z].getImage(), 40, 270, this);
		g.drawImage(icons[6].getImage(), 40, 321, this);
		g.setColor(new Color(225	, 102, 142));
		g.setFont(new Font("宋体",Font.BOLD,24));
		g.drawString(info.get(0), 280, 135);
		g.drawString(info.get(1),500 , 130);
		g.drawString(info.get(2), 550, 260);
		g.drawString(info.get(3), 280, 200);
		g.drawString(info.get(4), 350	, 320);
		g.drawString(info.get(5), 520,200);
		g.drawString(runner.poController.clientID, 280, 260);
		g.drawImage(imageIcons[8].getImage(), 550,295, this);
	}
	/*
	name.setText(info.get(0));
	sex.setText(info.get(1));
	vaule.setText(info.get(2));
	birthday.setText(info.get(3));
	phone.setText(info.get(4));
	Vip.setText("普通会员");
	clientid.setText(id);
	*/
	public void paintInfo(ArrayList<String> info){
		this.info = (ArrayList<String>) info.clone();
		repaint();
	}
	public void drawmean(int i,int k,int z){
		x=i;y=k;this.z=z;
		repaint();
	}
	public void drawmean(){
		repaint();
	}
	
}
class infoPanelListener implements MouseListener{
	public runner runner ;
	public infoFrame infoFrame ;
	public infoPanelListener (runner runner,infoFrame infoFrame){
		this.runner =runner;
		this.infoFrame =infoFrame;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>46&&e.getX()<151){
			if(e.getY()<362&&e.getY()>321){
				runner.exitAction();
				System.out.println("dsd");
			}
			else if(e.getY()<311&&e.getY()>270){
				runner.meanStartyAction();
				System.out.println("dssd");
			}
			else if(e.getY()>219&&e.getY()<260){
				runner.meanOrderAction();
				System.out.println("dsssd");
			}
			else if(e.getY()>168&&e.getY()<209){
				runner.meanInfoAction();
				System.out.println("dsdd");
			}
			else if(e.getY()<158&&e.getY()>58){
				runner.showWelcome();
				System.out.println("d欢迎");
			}
		}
		else if(e.getX()>240&&e.getX()<263&&e.getY()>340&&e.getY()<373&&infoFrame.could ==2){
			infoFrame.could++;
			infoFrame.exit--;
			infoFrame.keep--;
			infoFrame.repaint();
			infoFrame.add(infoFrame.name);
			infoFrame.add(infoFrame.sex);
			infoFrame.add(infoFrame.birthday);
			infoFrame.add(infoFrame.phone);
			
			infoFrame.name.setBounds(275, 83, 60, 30);
			infoFrame.sex.setBounds(495, 78, 60, 30);
			infoFrame.birthday.setBounds(275, 148, 120, 30);
			infoFrame.phone.setBounds(325, 260, 200, 30);
		}
		else if(e.getX()>440&&e.getX()<475&&e.getY()>340&&e.getY()<375&&infoFrame.keep==4){
			infoFrame.could--;
			infoFrame.exit++;
			infoFrame.keep++;
			infoFrame.info.set(0	, infoFrame.name.getText());
			infoFrame.info.set(1	, infoFrame.sex.getText());
			infoFrame.info.set(3	, infoFrame.birthday.getText());
			infoFrame.info.set(4	, infoFrame.phone.getText());
			infoFrame.repaint();
			infoFrame.remove(infoFrame.name);
			infoFrame.remove(infoFrame.sex);
			infoFrame.remove(infoFrame.birthday);
			infoFrame.remove(infoFrame.phone);
			runner.setInfoChange();;
		}
		else if(e.getX()>520&&e.getX()<555&&e.getY()>340&&e.getY()<375&&infoFrame.keep==4){
			infoFrame.could--;
			infoFrame.exit++;
			infoFrame.keep++;
			infoFrame.repaint();
			infoFrame.remove(infoFrame.name);
			infoFrame.remove(infoFrame.sex);
			infoFrame.remove(infoFrame.birthday);
			infoFrame.remove(infoFrame.phone);
		}
		else if(e.getX()>550&&e.getX()<585&&e.getY()>295&&e.getY()<330){
			infoFrame.vauleFrame.setVisible(true);
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
