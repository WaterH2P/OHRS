package presentation.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import presentation.controller.PromotionViewControllerImpl;
import vo.OdvoForWebpromotion;

public class MainView extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private PromotionViewControllerService controller;
	
	private JPanel contentPane;
	 
	private JPanel choosepanel;
	
	private JPanel changepanel;
	
	private JButton back;
	
	private JButton makepromotion;
	
	private JButton watchorders;
	
	private JButton addcredit;
	
	private JButton exit;
	
	private AddcreditView addcreditjp;
	
	private PromotionView prochoosejp;
	
	private backmain mainjp;
	
	private TimeproView timeprojp;
	
	private VipproView vip_locationProjp;
	
	private JPanel unusualorderjp;
	
	private CardLayout card = new CardLayout(); 
	
	private DefaultTableModel orderListModel;
	
	private JTable orderTable;
	
	private JFrame delayFrame;
	
	private JPanel delayPanel;
	
	public MainView(PromotionViewControllerService controller){
		
		
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setBounds(100, 100, 700, 500);
		
		
		initpanel();
		
		intiChoosebutton();
		
		setContentPane(contentPane);
		contentPane.setLocation(0, 0);
	
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
}
	
	private void initpanel() {
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setSize(this.getWidth(), this.getHeight());
		
		mainjp=new backmain(controller);
		prochoosejp = new PromotionView(controller);
		addcreditjp = new AddcreditView(controller);
		timeprojp   = new TimeproView(controller);
		vip_locationProjp = new VipproView(controller);
		unusualorderjp = new JPanel();

		
		choosepanel = new JPanel();
		choosepanel.setBackground(Color.white);
		choosepanel.setBounds(0, 0, 695, 80);
		contentPane.add(choosepanel);
		choosepanel.setLayout(null);
		
		changepanel = new JPanel(card);
		
		changepanel.add(mainjp,"主界面");
		changepanel.add(prochoosejp,"选择促销策略");
		changepanel.add(addcreditjp,"信用充值");
		changepanel.add(timeprojp,"时间促销策略制定");
		changepanel.add(vip_locationProjp,"会员在特定商圈促销策略制定");
		changepanel.add(unusualorderjp,"查看异常订单");
		
		changepanel.setBackground(Color.GRAY);
		changepanel.setBounds(0, 80, 695, 385);
		contentPane.add(changepanel);
		
	}
	
	private void intiChoosebutton(){
		
		back = new JButton(new ImageIcon("image/1.jpg"));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backButtonClicked();
			}
		});
		back.setBounds(0, 0, 134, 80);
		choosepanel.add(back);
		
		makepromotion = new JButton(new ImageIcon("image/2.jpg"));
		makepromotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.makepromotionButtonClicked();
			}
		});
		makepromotion.setBounds(135, 0, 134, 80);
		choosepanel.add(makepromotion);
		
		watchorders = new JButton(new ImageIcon("image/3.jpg"));
		watchorders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.watchordersButtonClicked();
			}
		});
		watchorders.setBounds(271, 0, 134, 80);
		choosepanel.add(watchorders);
		
		addcredit = new JButton(new ImageIcon("image/4.jpg"));
		addcredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addcreditButtonClicked();
			}
		});
		addcredit.setBounds(407, 0, 134, 80);
		choosepanel.add(addcredit);
		
		exit = new JButton(new ImageIcon("image/5.jpg"));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exit.setBounds(543, 0, 150, 80);
		choosepanel.add(exit);
	}
	
	
		public void backButtonClicked() {
		card.show(changepanel,"主界面");
	}
		
		public void makepromotionButtonClicked() {
			
			card.show(changepanel,"选择促销策略");
			
		}
		
		public void watchordersButtonClicked() {
			card.show(changepanel, "查看异常订单");
			unusualorderjp.setLayout(null);
			unusualorderjp.setSize(700,385);
			JScrollPane scrollPane = new JScrollPane();
			
			Vector<String> vColumns = new Vector<String>();
			vColumns.add("订单编号");
			vColumns.add("客户编号");
			vColumns.add("宾馆编号");
			vColumns.add("入住天数");
			vColumns.add("订单最晚执行时间");
			vColumns.add("订单价值");
			
			//数据
			Vector<Vector<String>> vData = new Vector<Vector<String>>();
			Vector<OdvoForWebpromotion> odvo = new Vector<OdvoForWebpromotion>();
			odvo = controller.getAllUnusualOrders();
			for(int i=0;i<odvo.size();i++){
				Vector<String> temp = new Vector<String>();
				temp.add(odvo.get(i).getOdid());
				temp.add(odvo.get(i).getclientid());
				temp.add(odvo.get(i).gethotelid());
				temp.add(odvo.get(i).getdays());
				temp.add(odvo.get(i).getinTime());
				temp.add(odvo.get(i).getmoney());
				vData.add(temp);
			}
			scrollPane.setBackground(Color.black);
			//模型
			orderListModel = new DefaultTableModel(vData, vColumns);
			//表格
			orderTable = new JTable(orderListModel){

				public boolean isCellEditable(int row, int column){
					return false;
				}
			};
			orderTable.setSize(700,295);
			scrollPane.setSize(700,295);
			orderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.getViewport().add(orderTable);
			orderTable.setFillsViewportHeight(true);
			unusualorderjp.add(scrollPane);
			JButton confirm = new JButton(new ImageIcon("image/撤销异常订单.jpg"));
			confirm.setBounds(280, 320,113, 27);
			unusualorderjp.add(confirm);
			confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.cancelorderButtonClicked();
				}
			});
		}
		
		public void addcreditButtonClicked() {
			
			card.show(changepanel,"信用充值");
			
			
		}
		
		public void exitButtonClicked() {
			
		}
		
		public void timeproButtonClicked(){
			
			card.show(changepanel,"时间促销策略制定");
			
			
		}
		
		public void vip_locationProButtonClicked(){
			
			card.show(changepanel,"会员在特定商圈促销策略制定");
			
			
		}
		
		
		
		public void cancelorderButtonClicked(){
			int index = orderTable.getSelectedRow();
			if(index == -1){
				JOptionPane.showMessageDialog(null, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String orderNo=((String)orderTable.getValueAt(index, 0));
			String clientid=((String)orderTable.getValueAt(index, 1));
			String money=((String)orderTable.getValueAt(index, 5));
			
			JFrame frame = new JFrame();
			frame.setVisible(true);
			frame.getContentPane().setBackground(Color.WHITE);
			frame.setBounds(100, 100, 420, 164);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JButton recallall = new JButton(new ImageIcon("image/恢复全部信用值.jpg"));
			recallall.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					recallunusualorder(clientid,money,orderNo);
					frame.dispose();
					orderListModel.removeRow(index);
				}
			});
			recallall.setBounds(27, 25, 148, 27);
			frame.getContentPane().add(recallall);
			
			JButton recallhalf = new JButton(new ImageIcon("image/恢复一半信用值.jpg"));
			recallhalf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int half=Integer.parseInt(money)/2;
					String s = String.valueOf(half);
					recallunusualorder(clientid,s,orderNo);
					frame.dispose();
					orderListModel.removeRow(index);
				}
			});
			recallhalf.setBounds(204, 25, 137, 27);
			frame.getContentPane().add(recallhalf);
			
			JButton cancel = new JButton(new ImageIcon("image/取消.jpg"));
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			cancel.setBounds(129, 77, 113, 27);
			frame.getContentPane().add(cancel);
			
		}
		
		public void recallunusualorder(String clientid,String money, String orderid){
			controller.recallunusualorder(clientid, money, orderid);
		}
		
}