package ui.hotel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.view_controller_hotelchange;

public class changeui extends JPanel{
	private view_controller_hotelchange vch = new view_controller_hotelchange();
	
	private final int frame_width = 150;
	private final int frame_height = 600;
	private final int button_width = 150;
	private final int button_height =40;
	
	private JPanel touxiangP;
	
	private JButton Infor;
	private JButton Od;
	private JButton Prom;
	private JButton Logout;
	
	private int status_hotel = 0;
	private int status_Od = 0;
	private int status_Prom = 0;
	
	private Image touxiangI;
	private Image setting;
	private Image setting2;
	private ImageIcon shandian_hotel1;
	private ImageIcon shandian_hotel2;
	private ImageIcon shandian_Od1;
	private ImageIcon shandian_Od2;
	private ImageIcon shandian_Prom1;
	private ImageIcon shandian_Prom2;
	private ImageIcon shandian_exit1;
	private ImageIcon shandian_exit2;
	
	private static String accredit = "";
	
	public changeui(){
		Images();
		initui();
	}
	
	public void paintComponent(Graphics g) {  
		super.paintComponent(g);   
		g.drawImage(setting, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  
	
	private void initui(){
		Buttons();
		
		this.setLayout(null);
		this.setSize(frame_width, frame_height);
		
		JPanel jpanel = new JPanel(){
			public void paintComponent(Graphics g) {  
				super.paintComponent(g);   
				g.drawImage(setting2, 0, 0,this.getWidth(), this.getHeight(), this);  
			}  
		};
		jpanel.setLayout(null);
		jpanel.setSize(frame_width, 300);
		
		int x = 0;
		int y = 35;
		int button_gap = 60;
		
		jpanel.add(Infor);
		jpanel.add(Od);
		jpanel.add(Prom);
		jpanel.add(Logout);
		Infor.setLocation(x, y);
		Od.setLocation(x , y+button_gap);
		Prom.setLocation(x , y+button_gap*2);
		Logout.setLocation(x , y+button_gap*3);
		
		touxiangP = new JPanel(){
			public void paintComponent(Graphics g) {  
				super.paintComponent(g);   
				g.drawImage(touxiangI, 0, 0,this.getWidth(), this.getHeight(), this);  
			}  
		};
		touxiangP.setSize(130, 145);
		
		this.add(touxiangP);
		this.add(jpanel);
		touxiangP.setLocation(10, 20);
		jpanel.setLocation(0, 200);
	}
	
	private void Images(){
		setting = Toolkit.getDefaultToolkit().getImage("image/changeuiS.jpg");
		setting2 = Toolkit.getDefaultToolkit().getImage("image/changeuiS2.jpg");
		touxiangI = Toolkit.getDefaultToolkit().getImage("image/touxiang.jpg");
		shandian_hotel1 = new ImageIcon("image/shandian_hotel1.jpg");
		shandian_hotel2 = new ImageIcon("image/shandian_hotel2.jpg");
		shandian_Od1 = new ImageIcon("image/shandian_Od1.jpg");
		shandian_Od2 = new ImageIcon("image/shandian_Od2.jpg");
		shandian_Prom1 = new ImageIcon("image/shandian_Prom1.jpg");
		shandian_Prom2 = new ImageIcon("image/shandian_Prom2.jpg");
		shandian_exit1 = new ImageIcon("image/shandian_exit1.jpg");
		shandian_exit2 = new ImageIcon("image/shandian_exit2.jpg");
	}
	
	private void Buttons(){
		Infor = new JButton(shandian_hotel2);
		status_hotel = 1;
		Infor.setFont(new Font("华文新魏",1,16));
		Infor.setForeground(Color.white);
		Infor.setBorderPainted(false);
		Infor.setFocusPainted(false);
		Infor.setSize(button_width, button_height);
		Infor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Infor.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				if(status_hotel==0)
					Infor.setIcon(shandian_hotel2);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(status_hotel==0)
					Infor.setIcon(shandian_hotel1);
			}	
		});
		Infor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				status_hotel = 1;
				status_Od = 0;
				status_Prom = 0;
				Infor.setIcon(shandian_hotel2);
				Od.setIcon(shandian_Od1);
				Prom.setIcon(shandian_Prom1);
				vch.ToInfor();
			}
		});
		
		Od = new JButton(shandian_Od1);
		Od.setMargin(new Insets(-1, -1, -1, -1));
		Od.setFont(new Font("华文新魏",1,16));
		Od.setForeground(Color.white);
		Od.setBorderPainted(false);
		Od.setFocusPainted(false);
		Od.setSize(button_width, button_height);
		Od.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Od.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				if(status_Od==0)
					Od.setIcon(shandian_Od2);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(status_Od==0)
					Od.setIcon(shandian_Od1);
			}	
		});
		Od.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				status_hotel = 0;
				status_Od = 1;
				status_Prom = 0;
				Infor.setIcon(shandian_hotel1);
				Od.setIcon(shandian_Od2);
				Prom.setIcon(shandian_Prom1);
				vch.ToOdlist();
			}
		});
		
		Prom = new JButton(shandian_Prom1);
		Prom.setFont(new Font("华文新魏",1,16));
		Prom.setForeground(Color.white);
		Prom.setBorderPainted(false);
		Prom.setFocusPainted(false);
		Prom.setSize(button_width, button_height);
		Prom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Prom.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				if(status_Prom==0)
					Prom.setIcon(shandian_Prom2);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(status_Prom==0)
					Prom.setIcon(shandian_Prom1);
			}	
		});
		Prom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				status_hotel = 0;
				status_Od = 0;
				status_Prom = 1;
				Infor.setIcon(shandian_hotel1);
				Od.setIcon(shandian_Od1);
				Prom.setIcon(shandian_Prom2);
				vch.ToPromlist();
			}
		});
		
		Logout = new JButton(shandian_exit1);
		Logout.setFont(new Font("华文新魏",1,16));
		Logout.setForeground(Color.white);
		Logout.setBorderPainted(false);
		Logout.setFocusPainted(false);
		Logout.setSize(button_width, button_height);
		Logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Logout.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				Logout.setIcon(shandian_exit2);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Logout.setIcon(shandian_exit1);
			}	
		});
		Logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vch.logout(accredit);
			}
		});
	}
	
	protected static void setaccredit(String s){
		accredit = s;
	}
}
