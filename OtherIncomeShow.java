package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Vector;

import com.zirong.dbc.DBConnection;

public class OtherIncomeShow {
	private Connection conn=new DBConnection().getConnection();
	public Vector showIncome(String id) {
		String sql="select ����,������,�ص�,����,���,��ע from income where �˺�=?";
		Vector<Vector> v=new Vector();
		
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			//System.out.println(rs.next());
			while(rs.next()) {
				Vector row=new Vector();
				String type=rs.getString("����");
				if(!(type.contains("��Ʊ")||type.contains("����")||type.contains("�����Ϣ")||type.contains("����"))) {
					String name=rs.getString("������");
					String place=rs.getString("�ص�");
					String date=rs.getString("����");
					float acount=rs.getFloat("���");
					String remark=rs.getString("��ע");
					Collections.addAll(row, type,name,place,date,acount,remark);
					Collections.addAll(v, row);
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
		}
		//System.out.println(v);
		return v;
	}
}
