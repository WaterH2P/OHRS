package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Server.ClientDataServerCommon;

public class ClientDataImplCommon implements ClientDataServerCommon{
	
	private Connection connection = database.getConnection();
	
	//获取用户信用值的方法
	@Override
	public String GetClientValue(String clientid) {
		// TODO Auto-generated method stub
		String sql = "select value  from infotable where clientid = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, clientid);
			ResultSet resultSet =preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getString(1);
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "找不到用户";
	}
	

}
