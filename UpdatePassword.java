package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zirong.dbc.DBConnection;

public class UpdatePassword {
	private Connection conn=new DBConnection().getConnection();
	public void updatePassword(String newpassword,String id) {
		String sql="update user set ����='"+newpassword+"'where �˺�="+id;
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
