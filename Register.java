package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zirong.dbc.DBConnection;

public class Register {
	private Connection conn=new DBConnection().getConnection();
	private String id;
	private String name;
	private String password;
	private String vip;
	public Register() {}
	public boolean operatorToRegister(String idtxt,String nametxt,String passwordtxt,String confirmpasswordtxt) {
		String sql="insert into user (’À∫≈,√‹¬Î,Í«≥∆,VIP) values (?,?,?,'0') ";
		String sql2="select ’À∫≈ from user where ’À∫≈="+idtxt;
		boolean flag=true;
		try(PreparedStatement stmt2=conn.prepareStatement(sql2)){
			ResultSet rs=stmt2.executeQuery();
			while(rs.next()) {
				if(idtxt.equals(rs.getString(1)))
					flag=false;
			}
		}catch(SQLException e2) {
			e2.printStackTrace();
		}
		if(flag) {
			try(PreparedStatement stmt=conn.prepareStatement(sql);){
				stmt.setString(1, idtxt);
				stmt.setString(2, nametxt);
				stmt.setString(3, passwordtxt);
				stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
