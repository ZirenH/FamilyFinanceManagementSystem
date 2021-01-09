package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zirong.dbc.DBConnection;
/**
 * 个人信息更新类
 * @author ZirongHuang
 *
 */
public class PersonalInfoUpdate {
	private Connection conn=new DBConnection().getConnection();
	/**
	 * 成员方法，更新账号为id的账户的昵称
	 * @param newname
	 * @param id
	 */
	public void updateInformation(String newname,String id) {
		String	sql="update user set 昵称='"+newname+"'where 账号="+id;
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
