package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Vector;

import com.zirong.dbc.DBConnection;
/**
 * ������Ϣչʾ�࣬չʾ������Ϣ
 * @author ZirongHuang
 *
 */
public class PersonalInformation {
	private Connection conn=new DBConnection().getConnection();
	private String id;
	private String name;
	private String role;
	private String vip;
	public PersonalInformation() {}
	/**
	 * ��Ա��������ѯ�˺�Ϊidtxt�ĸ�����Ϣ
	 * @param idtxt
	 * @return
	 */
	public Vector getPersonalInformation(String idtxt) {
		String sql="select �˺�,�ǳ�,��ͥ���,vip from user where �˺�="+idtxt;
		Vector<Vector> v=new Vector<Vector>();
		
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Vector row1=new Vector();
				id=rs.getString("�˺�");
				name=rs.getString("�ǳ�");
				role=rs.getString("��ͥ���");
				vip=rs.getString("VIP");
				Collections.addAll(row1, id,name,role,vip);
				Collections.addAll(v,row1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return v;
	}
}
