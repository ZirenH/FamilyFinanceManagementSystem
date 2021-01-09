package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Vector;

import com.zirong.dbc.DBConnection;
/**
 * ���ʹ�����
 * @author ZirongHuang
 *
 */
public class WageShow {
	private Connection conn=new DBConnection().getConnection();
	/**
	 * ��ӡ���ʱ�
	 * @param id
	 * @return
	 */
	public Vector<Vector> showWage(String id) {
		String sql="select ����,������,�ص�,����,���,��ע from income where �˺�='"+id+"' and ���� ='����'";
		Vector<Vector> v=new Vector();
		
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			//stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			//System.out.println(rs.next());
			while(rs.next()) {
				Vector row=new Vector();
				String type=rs.getString("����");
				String name=rs.getString("������");
				String place=rs.getString("�ص�");
				String date=rs.getString("����");
				float acount=rs.getFloat("���");
				String remark=rs.getString("��ע");
				Collections.addAll(row, type,name,place,date,acount,remark);
				Collections.addAll(v, row);
				//System.out.println(row);
				}
			}catch(Exception e) {
				e.printStackTrace();
		}
		
		//System.out.println(v);
		return v;
	}
}
