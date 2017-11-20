package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.Server.ClientDataServerForWebpromotion;

public class ClientDataImplForWebpromotion implements ClientDataServerForWebpromotion{

	private Connection connection = database.getConnection();

	//网站营销人员更改用户信用值的方法
	@Override
	public void MoneySetClientValue(String value, String clientid) {
		// TODO Auto-generated method stub
		String sql ="update infotable set value = ?  where  clientid =?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, value);
			preparedStatement.setString(2, clientid);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
