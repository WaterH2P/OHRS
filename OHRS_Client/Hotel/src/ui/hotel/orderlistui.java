package ui.hotel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import controller.view_controller_hotelOd;
import vo.OdListvo;
import vo.OdvoForHotel;

public class orderlistui extends JPanel{
	
	private static view_controller_hotelOd vch = new view_controller_hotelOd();

	/*
	 * 常量值
	 * 用于规定输入框和选择框的大小
	 * 也使用于布局中status的位置确定
	 */
	private final static int frame_width=800;
	private final int frame_height=600;
	private final int label_width=100;
	private final int label_height=30;
	private final int textfield_width = 260;
	private final int textfield_height = 30;
	private final static int heightOfTable = 481;
	
	private JLabel kindOfOdL;
	
	private static JComboBox<String> kindOfOdC;
	
	private static JTable OdInforT;
	private static Vector<String> kindOfOdInfor;
	private static DefaultTableModel OdInforTM;
	private static JScrollPane scrollPane;

	private static Vector<Vector<OdvoForHotel>> OdInforvo;
	private static Vector<String> OdKind1 = new Vector<String>();
	private static Vector<String> OdKind2 = new Vector<String>();
	private static Vector<String> OdKind3 = new Vector<String>();
	private static Vector<String> OdKind4 = new Vector<String>();
	private static Vector<Vector<String>> OdKind1s = new Vector<Vector<String>>();
	private static Vector<Vector<String>> OdKind2s = new Vector<Vector<String>>();
	private static Vector<Vector<String>> OdKind3s = new Vector<Vector<String>>();
	private static Vector<Vector<String>> OdKind4s = new Vector<Vector<String>>();
	
	private JPanel jpanelU = new JPanel();
	private JPanel jpanelC = new JPanel();
	
	private static String accredit = "";
	
	private JButton checkOd;
	private JButton updateB;
	private JButton overB;
	
	private Image setting;
	private ImageIcon updateI1;
	private ImageIcon updateI2;
	
	public orderlistui(){
		Images();
		initui();
	}
	
	public void paintComponent(Graphics g) {  
		 super.paintComponent(g);   
		 g.drawImage(setting, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  
	
	private void initui(){
		Labels();
		ComboBoxs();
		Tables();
		Buttons();
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(frame_width, frame_height);
		
		int x = 20;
		int y = 45;
		jpanelU.setLayout(null);
		jpanelU.setOpaque(false);
		jpanelU.setSize(frame_width, 90);
		jpanelU.setBackground(Color.white);
		
		jpanelU.add(kindOfOdL);
		jpanelU.add(kindOfOdC);
		jpanelU.add(checkOd);
		jpanelU.add(updateB);
		jpanelU.add(overB);
		kindOfOdL.setLocation(x, y);
		kindOfOdC.setLocation(x+label_width, y);
		checkOd.setLocation(jpanelU.getWidth()-x*2-checkOd.getWidth()*2, y);
		overB.setLocation(jpanelU.getWidth()-x-checkOd.getWidth(), y);
		updateB.setLocation(jpanelU.getWidth()-x*2-checkOd.getWidth()*3, y);
		
		this.add(jpanelU);
		this.add(jpanelC);
		jpanelU.setLocation(0, 0);
		jpanelC.setLocation(0, 90);
	}
	
	private void Images(){
		setting = Toolkit.getDefaultToolkit().getImage("image/HInforS.jpg");
		updateI1 = new ImageIcon("image/update1.jpg");
		updateI2 = new ImageIcon("image/update2.jpg");
	}
	
	private void Labels(){
		kindOfOdL = new JLabel("订单类型：",JLabel.RIGHT);
		kindOfOdL.setSize(label_width, label_height);
		kindOfOdL.setFont(new Font("华文楷体",1,15));
		kindOfOdL.setForeground(Color.orange);	
	}
	
	private void ComboBoxs(){
		String kindOfOd[] = {"未完成","已完成","逾期","已撤销"};
		kindOfOdC = new JComboBox<String>(kindOfOd);
		kindOfOdC.setFont(new Font("华文楷体",1,15));
		kindOfOdC.setSize(textfield_width/2, textfield_height);
		kindOfOdC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				OdInforT.removeAll();
				if(kindOfOdC.getSelectedItem().toString().equals("未完成")){
					OdInforTM = new DefaultTableModel(OdKind1s, kindOfOdInfor);
					overB.setEnabled(true);
				}
				else if(kindOfOdC.getSelectedItem().toString().equals("已完成")){
					OdInforTM = new DefaultTableModel(OdKind2s, kindOfOdInfor);	
					overB.setEnabled(false);
				}
				else if(kindOfOdC.getSelectedItem().toString().equals("逾期")){
					OdInforTM = new DefaultTableModel(OdKind3s, kindOfOdInfor);	
					overB.setEnabled(false);
				}
				else if(kindOfOdC.getSelectedItem().toString().equals("已撤销")){
					OdInforTM = new DefaultTableModel(OdKind4s, kindOfOdInfor);	
					overB.setEnabled(false);
				}
				OdInforT.setModel(OdInforTM);
				OdInforT.updateUI();
				orderlistui.setTable();
			}
		});
	}
	
	private void Tables(){
		
		kindOfOdInfor = new Vector<String>();
		kindOfOdInfor.add("订单ID");
		kindOfOdInfor.add("订单状态");
		kindOfOdInfor.add("客户ID");
		kindOfOdInfor.add("房间类型");
		kindOfOdInfor.add("最晚入住时间");
		kindOfOdInfor.add("入住天数");
		
		OdInforvo = vch.getOds(accredit);	
		if(OdInforvo.size()==4){
			Vector<OdvoForHotel> odvo = new Vector<OdvoForHotel>();
			odvo = OdInforvo.get(0);
			for(int j=0;j<odvo.size();j++){
				OdListvo odvo2 = new OdListvo().exchange(odvo.get(j));
				OdKind1 = new Vector<String>();
				OdKind1.add(odvo2.getOdID());
				OdKind1.add(odvo2.getOdStatus());
				OdKind1.add(odvo2.getclientID());
				OdKind1.add(odvo2.getkindOfRoom());
				OdKind1.add(odvo2.getcomeTime());
				OdKind1.add(String.valueOf(odvo2.getdays()));
				OdKind1s.add(OdKind1);
			}
			odvo = new Vector<OdvoForHotel>();
			odvo = OdInforvo.get(1);
			for(int j=0;j<odvo.size();j++){
				OdListvo odvo2 = new OdListvo().exchange(odvo.get(j));
				OdKind2 = new Vector<String>();
				OdKind2.add(odvo2.getOdID());
				OdKind2.add(odvo2.getOdStatus());
				OdKind2.add(odvo2.getclientID());
				OdKind2.add(odvo2.getkindOfRoom());
				OdKind2.add(odvo2.getcomeTime());
				OdKind2.add(String.valueOf(odvo2.getdays()));
				OdKind2s.add(OdKind2);
			}
			odvo = new Vector<OdvoForHotel>();
			odvo = OdInforvo.get(2);
			for(int j=0;j<odvo.size();j++){
				OdListvo odvo2 = new OdListvo().exchange(odvo.get(j));
				OdKind3 = new Vector<String>();
				OdKind3.add(odvo2.getOdID());
				OdKind3.add(odvo2.getOdStatus());
				OdKind3.add(odvo2.getclientID());
				OdKind3.add(odvo2.getkindOfRoom());
				OdKind3.add(odvo2.getcomeTime());
				OdKind3.add(String.valueOf(odvo2.getdays()));
				OdKind3s.add(OdKind3);
			}
			odvo = new Vector<OdvoForHotel>();
			odvo = OdInforvo.get(3);
			for(int j=0;j<odvo.size();j++){
				OdListvo odvo2 = new OdListvo().exchange(odvo.get(j));
				OdKind4 = new Vector<String>();
				OdKind4.add(odvo2.getOdID());
				OdKind4.add(odvo2.getOdStatus());
				OdKind4.add(odvo2.getclientID());
				OdKind4.add(odvo2.getkindOfRoom());
				OdKind4.add(odvo2.getcomeTime());
				OdKind4.add(String.valueOf(odvo2.getdays()));
				OdKind4s.add(OdKind4);
			}
		}
		
		OdInforTM = new DefaultTableModel(OdKind1s, kindOfOdInfor);
		OdInforT = new JTable(OdInforTM){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
	
		OdInforT.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);	
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器  
		tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示  
		OdInforT.setDefaultRenderer(Object.class, tcr);//设置渲染器 
		OdInforT.getTableHeader().setReorderingAllowed(false);//设置标题不可以动
		OdInforT.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		OdInforT.setShowGrid(false);
		OdInforT.setSize(frame_width, heightOfTable);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, frame_width, heightOfTable);
		scrollPane.getViewport().add(OdInforT);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		OdInforT.setFillsViewportHeight(true);
		OdInforT.setOpaque(false);
		
		orderlistui.setTable();
		
		jpanelC.setLayout(null);
		jpanelC.setOpaque(false);
		jpanelC.setSize(frame_width, heightOfTable);
		jpanelC.setBackground(Color.white);
		jpanelC.add(scrollPane);	
	}
	
	private void Buttons(){
		final int button_width=140;
		final int button_height=35;
		final int button_width2=30;
		final int button_height2=30;
		
		checkOd = new JButton("查看订单信息");
		checkOd.setFont(new Font("华文新魏",1,16));
		checkOd.setForeground(Color.white);
		checkOd.setBackground(new Color(0, 191, 255));
		checkOd.setBorderPainted(false);
		checkOd.setFocusPainted(false);
		checkOd.setSize(button_width, button_height);
		checkOd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkOd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vch.checkOd( orderlistui.getOdInfor());
			}
		});
		
		updateB = new JButton(updateI2);
		updateB.setMargin(new Insets(-1,-1,-1,-1));
		updateB.setBorderPainted(false);
		updateB.setFocusPainted(false);
		updateB.setSize(button_width2, button_height2);
		updateB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateB.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				updateB.setIcon(updateI1);;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				updateB.setIcon(updateI2);;
			}
		});
		updateB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				updateOdlist();
			}
		});
		
		overB = new JButton("置为逾期");
		overB.setFont(new Font("华文新魏",1,16));
		overB.setForeground(Color.white);
		overB.setBackground(new Color(0, 191, 255));
		overB.setBorderPainted(false);
		overB.setFocusPainted(false);
		overB.setSize(button_width, button_height);
		overB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		overB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				OdvoForHotel odvo = orderlistui.getOdInfor();
				if(vch.overOd(accredit, odvo.gethotelID(), odvo.gettotalPrice(), odvo.getOdID()))
					updateOdlist();
				else{
					Font font = new Font("华文楷体",1,15);
				    UIManager.put("OptionPane.font", font);
				    UIManager.put("OptionPane.messageFont", font);
				    UIManager.put("OptionPane.buttonFont", font);
				    JOptionPane.showMessageDialog(null, "操作失败，你心不诚！",
							"", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
private static void setTable(){
		
		//设置JTable列宽
		int numOfOdInfor = OdInforT.getColumnCount();
		for(int i=0;i<numOfOdInfor;i++){
			TableColumn Column = OdInforT.getColumnModel().getColumn(i);
			if(i==1){
				Column.setPreferredWidth(frame_width/numOfOdInfor/3*2);
				Column.setMaxWidth(frame_width/numOfOdInfor/3*2);
				Column.setMinWidth(frame_width/numOfOdInfor/3*2);
			}
			else if(i==4){
				Column.setPreferredWidth(frame_width/numOfOdInfor/3*5);
				Column.setMaxWidth(frame_width/numOfOdInfor/3*5);
				Column.setMinWidth(frame_width/numOfOdInfor/3*5);
			}
			else if(i==5){
				Column.setPreferredWidth(frame_width/numOfOdInfor/3*2+5);
				Column.setMaxWidth(frame_width/numOfOdInfor/3*2+5);
				Column.setMinWidth(frame_width/numOfOdInfor/3*2+5);
			}
			else{
				Column.setPreferredWidth(frame_width/numOfOdInfor);
				Column.setMaxWidth(frame_width/numOfOdInfor);
				Column.setMinWidth(frame_width/numOfOdInfor);
			}
		}
		//设置行高
		OdInforT.setRowHeight(25);
		JTableHeader tableHeader = OdInforT.getTableHeader(); 
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 25));
	}
	
	protected static void setaccredit(String s){
		accredit = s;
	}
	
	protected static void updateOdlist(){
		OdInforvo = new Vector<Vector<OdvoForHotel>>();
		OdKind1 = new Vector<String>();
		OdKind2 = new Vector<String>();
		OdKind3 = new Vector<String>();
		OdKind4 = new Vector<String>();
		OdKind1s = new Vector<Vector<String>>();
		OdKind2s = new Vector<Vector<String>>();
		OdKind3s = new Vector<Vector<String>>();
		OdKind4s = new Vector<Vector<String>>();
		OdInforvo = vch.getOds(accredit);	
		if(OdInforvo.size()==4){
			Vector<OdvoForHotel> odvo = new Vector<OdvoForHotel>();
			odvo = OdInforvo.get(0);
			for(int j=0;j<odvo.size();j++){
				OdListvo odvo2 = new OdListvo().exchange(odvo.get(j));
				OdKind1 = new Vector<String>();
				OdKind1.add(odvo2.getOdID());
				OdKind1.add(odvo2.getOdStatus());
				OdKind1.add(odvo2.getclientID());
				OdKind1.add(odvo2.getkindOfRoom());
				OdKind1.add(odvo2.getcomeTime());
				OdKind1.add(String.valueOf(odvo2.getdays()));
				OdKind1s.add(OdKind1);
			}
			odvo = new Vector<OdvoForHotel>();
			odvo = OdInforvo.get(1);
			for(int j=0;j<odvo.size();j++){
				OdListvo odvo2 = new OdListvo().exchange(odvo.get(j));
				OdKind2 = new Vector<String>();
				OdKind2.add(odvo2.getOdID());
				OdKind2.add(odvo2.getOdStatus());
				OdKind2.add(odvo2.getclientID());
				OdKind2.add(odvo2.getkindOfRoom());
				OdKind2.add(odvo2.getcomeTime());
				OdKind2.add(String.valueOf(odvo2.getdays()));
				OdKind2s.add(OdKind2);
			}
			odvo = new Vector<OdvoForHotel>();
			odvo = OdInforvo.get(2);
			for(int j=0;j<odvo.size();j++){
				OdListvo odvo2 = new OdListvo().exchange(odvo.get(j));
				OdKind3 = new Vector<String>();
				OdKind3.add(odvo2.getOdID());
				OdKind3.add(odvo2.getOdStatus());
				OdKind3.add(odvo2.getclientID());
				OdKind3.add(odvo2.getkindOfRoom());
				OdKind3.add(odvo2.getcomeTime());
				OdKind3.add(String.valueOf(odvo2.getdays()));
				OdKind3s.add(OdKind3);
			}
			odvo = new Vector<OdvoForHotel>();
			odvo = OdInforvo.get(3);
			for(int j=0;j<odvo.size();j++){
				OdListvo odvo2 = new OdListvo().exchange(odvo.get(j));
				OdKind4 = new Vector<String>();
				OdKind4.add(odvo2.getOdID());
				OdKind4.add(odvo2.getOdStatus());
				OdKind4.add(odvo2.getclientID());
				OdKind4.add(odvo2.getkindOfRoom());
				OdKind4.add(odvo2.getcomeTime());
				OdKind4.add(String.valueOf(odvo2.getdays()));
				OdKind4s.add(OdKind4);
			}
		}
		
		if(kindOfOdC.getSelectedIndex()==0)
			OdInforTM = new DefaultTableModel(OdKind1s, kindOfOdInfor);
		else if(kindOfOdC.getSelectedIndex()==1)
			OdInforTM = new DefaultTableModel(OdKind2s, kindOfOdInfor);
		else if(kindOfOdC.getSelectedIndex()==2)
			OdInforTM = new DefaultTableModel(OdKind3s, kindOfOdInfor);
		else if(kindOfOdC.getSelectedIndex()==3)
			OdInforTM = new DefaultTableModel(OdKind4s, kindOfOdInfor);
		
		OdInforT.setModel(OdInforTM);
		OdInforT.updateUI();
		orderlistui.setTable();
	}
	
	private static OdvoForHotel getOdInfor(){
		int row = OdInforT.getSelectedRow();
		String odid = OdInforT.getValueAt(row, 0).toString();
		String odstatus = OdInforT.getValueAt(row, 1).toString();
		OdvoForHotel odvo = new OdvoForHotel();
		if(odstatus.equals("未完成")){
			for(int i=0;i<OdInforvo.get(0).size();i++){
				if(OdInforvo.get(0).get(i).getOdID().equals(odid))
					odvo = OdInforvo.get(0).get(i);
			}
		}
		else if(odstatus.equals("已完成")){
			for(int i=0;i<OdInforvo.get(1).size();i++){
				if(OdInforvo.get(1).get(i).getOdID().equals(odid))
					odvo = OdInforvo.get(1).get(i);
			}
		}
		else if(odstatus.equals("逾期")){
			for(int i=0;i<OdInforvo.get(2).size();i++){
				if(OdInforvo.get(2).get(i).getOdID().equals(odid))
					odvo = OdInforvo.get(2).get(i);
			}
		}
		else if(odstatus.equals("已撤销")){
			for(int i=0;i<OdInforvo.get(3).size();i++){
				if(OdInforvo.get(3).get(i).getOdID().equals(odid))
					odvo = OdInforvo.get(3).get(i);
			}
		}
		return odvo;
	}
	
	protected static void clear(){
		OdInforvo = new Vector<Vector<OdvoForHotel>>();
		accredit = "";
	}
}

