package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dao.Server.OdDataServerForClient;
import po.orderPo;

public class OdDataImplForClient implements OdDataServerForClient{

	private Connection connection = database.getConnection();
	
	//用户获取所有订单
	@Override
	public Vector<orderPo> clientGetOrder(String clientid) {
		// TODO Auto-generated method stub
		String sql = "select *  from ordertable where clientid =?";
		Vector<orderPo> orderList = new Vector<orderPo>();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,clientid);
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()){
				orderPo  orderpo = new orderPo();
				orderpo.clientid = resultSet.getString(1);
				orderpo.hotelid = resultSet.getString(2);
				orderpo.inTime = resultSet.getString(3);
				orderpo.days = resultSet.getString(4);
				orderpo.money = resultSet.getString(5);
				orderpo.room1N = resultSet.getString(6);
				orderpo.room2N = resultSet.getString(7);
				orderpo.room3N = resultSet.getString(8);
				orderpo.room4N= resultSet.getString(9);
				orderpo.room5N = resultSet.getString(10);
				orderpo.comment = resultSet.getString(11);
				orderpo.promotion = resultSet.getString(14);
				orderpo.station = resultSet.getString(12);
				orderpo.room1V =  resultSet.getString(16);
				orderpo.room2V =  resultSet.getString(17);
				orderpo.room3V =  resultSet.getString(18);
				orderpo.room4V =  resultSet.getString(19);
				orderpo.room5V =  resultSet.getString(20);
				orderpo.Odid = resultSet.getString(15);
				orderList.add(orderpo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return orderList;
	}

	/*
	 * 根据用户ID生存订单
	 * 数据顺序  用户id、酒店id、入住时间、退房时间、金额、房间1、2、3、4、5，
	 * 评价、状态（正常、未完成、逾期）、是否处理、采用的策略、订单id
	 */
	@Override
	public void creatNewOrder(orderPo orderPo) {
		// TODO Auto-generated method stub
		String sql = "insert into ordertable (clientid,hotelid,inTime,days,money,room1N,room2N,room3N,room4N,room5N,comment,station,check,promotion,Odid,room1V,room2V,room3V,room4V,room5V)"
				+ " "+"  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{	
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, orderPo.clientid);
			preparedStatement.setString(2, orderPo.hotelid);
			preparedStatement.setString(3, orderPo.inTime);
			preparedStatement.setString(4, orderPo.days);
			preparedStatement.setString(5, orderPo.money);
			preparedStatement.setString(6, orderPo.room1N);
			preparedStatement.setString(7, orderPo.room2N);
			preparedStatement.setString(8,orderPo.room3N);
			preparedStatement.setString(9,orderPo.room4N);
			preparedStatement.setString(10,orderPo.room5N);
			preparedStatement.setString(11, orderPo.comment);
			preparedStatement.setString(12, orderPo.station);
			preparedStatement.setString(13,"0");
			preparedStatement.setString(14, orderPo.promotion);
			preparedStatement.setString(15,orderPo.Odid);
			preparedStatement.setString(16,orderPo.room1V);
			preparedStatement.setString(17,orderPo.room2V);
			preparedStatement.setString(18,orderPo.room3V);
			preparedStatement.setString(19,orderPo.room4V);
			preparedStatement.setString(20,orderPo.room5V);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
