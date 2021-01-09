package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Vector;

import com.zirong.dbc.DBConnection;

public class MoneyManagementShow {
	private Connection conn=new DBConnection().getConnection();
	public Vector<Vector> showWage(String id,String t) {
		String sql="select 类型,收入人,地点,日期,金额,备注 from income where 账号="+id;
		Vector<Vector> v=new Vector();
		
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
//			if(t.contains("股票")||t.contains("基金")||t.contains("存款利息")) {
//				stmt.setString(1, "%"+t+"%");
//			}	
			ResultSet rs=stmt.executeQuery();
			//System.out.println(rs.next());
			while(rs.next()) {
				Vector row=new Vector();
				String type=rs.getString("类型");
				if(type.contains("股票")||type.contains("基金")||type.contains("存款&利息")) {
					String name=rs.getString("收入人");
					String place=rs.getString("地点");
					String date=rs.getString("日期");
					float acount=rs.getFloat("金额");
					String remark=rs.getString("备注");
					Collections.addAll(row, type,name,place,date,acount,remark);
					Collections.addAll(v, row);
				}
				//System.out.println(row);
				}
			}catch(Exception e) {
				e.printStackTrace();
		}
		
		//System.out.println(v);
		return v;
	}
}
