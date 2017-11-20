package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import dao.Server.ClientDataServerForWebmanager;

public class ClientDataImplForWebmanager implements ClientDataServerForWebmanager{

	private Connection connection = database.getConnection();
	
	//网站管理人员获取用户信息的方法
	@Override
	public ArrayList<String> WebGetClientInfor(String clientid) {
		// TODO Auto-generated method stub
		String sql = "select name,sex,clientid,password,value,birthday,phone,station,VIP  from infotable where clientid = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, clientid);
			ResultSet resultSet =preparedStatement.executeQuery();
			if(resultSet.next()){
				ArrayList<String> info = new ArrayList<String>();
				for(int i =0;i<9;i++){
					info.add(resultSet.getString(i+1));
				}
				return info;
			}
		}catch(SQLException e){
		e.printStackTrace();
		}
		return new ArrayList<String>();
	}

	//网站管理人员获取所有用户信息的方法
	@Override
	public Vector<ArrayList<String>> WebGetAllClientInfor() {
		// TODO Auto-generated method stub
		String sql = "select name,sex,clientid,password,value,birthday,phone,station,VIP  from infotable ";
		Vector<ArrayList<String>> vector = new Vector<ArrayList<String>>();
		try{	
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setString(1, clientid);
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()){
				ArrayList<String> info = new ArrayList<String>();
				info.add(resultSet.getString(1));
				info.add(resultSet.getString(2));
				info.add(resultSet.getString(3));
				info.add(resultSet.getString(4));
				info.add(resultSet.getString(5));
				info.add(resultSet.getString(6));
				info.add(resultSet.getString(7));
				info.add(resultSet.getString(8));
				info.add(resultSet.getString(9));
				vector.add(info);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return vector;
	}

	//网站管理人员更改用户信息的方法
	@Override
	public void WebSetClientInfor(ArrayList<String> info, String clientid) {
		// TODO Auto-generated method stub
		String sql ="update infotable set name =? , sex =?,password =?, birthday = ?,phone =? ,station =?  where  clientid =?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, info.get(0));
			preparedStatement.setString(2, info.get(1));
			preparedStatement.setString(3, info.get(2));
			preparedStatement.setString(4, info.get(3));
			preparedStatement.setString(5, info.get(4));
			preparedStatement.setString(6, info.get(5));
			preparedStatement.setString(7, clientid);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
