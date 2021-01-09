package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Vector;

import com.zirong.dbc.DBConnection;
/**
 * 个人信息展示类，展示个人信息
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
	 * 成员方法，查询账号为idtxt的个人信息
	 * @param idtxt
	 * @return
	 */
	public Vector getPersonalInformation(String idtxt) {
		String sql="select 账号,昵称,家庭身份,vip from user where 账号="+idtxt;
		Vector<Vector> v=new Vector<Vector>();
		
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Vector row1=new Vector();
				id=rs.getString("账号");
				name=rs.getString("昵称");
				role=rs.getString("家庭身份");
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
