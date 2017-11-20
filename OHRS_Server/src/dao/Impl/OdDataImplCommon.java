package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Server.OdDataServerCommon;
import po.orderPo;

public class OdDataImplCommon implements OdDataServerCommon{
	
	private Connection connection = database.getConnection();

	//根据id查找单一订单
	@Override
	public orderPo getOneOdInfo(String Odid) {
		// TODO Auto-generated method stub
		String sql ="select * from ordertable where Odid =?";
		orderPo orderpo = new orderPo();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, Odid);
			ResultSet resultSet = preparedStatement.executeQuery();	
			if(resultSet.next()){
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
				orderpo.station = resultSet.getString(12);
				orderpo.promotion = resultSet.getString(14);
				orderpo.room1V =  resultSet.getString(16);
				orderpo.room2V =  resultSet.getString(17);
				orderpo.room3V =  resultSet.getString(18);
				orderpo.room4V =  resultSet.getString(19);
				orderpo.room5V =  resultSet.getString(20);
				orderpo.Odid = resultSet.getString(15);
			}
			preparedStatement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return orderpo;
	}
}
