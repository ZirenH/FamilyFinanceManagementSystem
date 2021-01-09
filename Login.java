package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zirong.dbc.DBConnection;
import com.zirong.vo.User;

public class Login {
	private Connection conn=new DBConnection().getConnection();
	private String id;
	private String password;
	public Login() {}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void getConnectionToLogin(String idtxt,String passwordtxt) {
		String sql="select ’À∫≈,√‹¬Î from user where ’À∫≈="+idtxt;
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				id=rs.getString(1);
				password=rs.getString(2);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
