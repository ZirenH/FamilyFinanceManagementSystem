package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zirong.dbc.DBConnection;
/**
 * ������Ϣ������
 * @author ZirongHuang
 *
 */
public class PersonalInfoUpdate {
	private Connection conn=new DBConnection().getConnection();
	/**
	 * ��Ա�����������˺�Ϊid���˻����ǳ�
	 * @param newname
	 * @param id
	 */
	public void updateInformation(String newname,String id) {
		String	sql="update user set �ǳ�='"+newname+"'where �˺�="+id;
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
