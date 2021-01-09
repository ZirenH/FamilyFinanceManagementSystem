package com.zirong.DAO;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import com.zirong.dbc.DBConnection;
/**
 * VIP数据操作类
 * @author ZirongHuang
 *
 */
public class VipShow{
	private String id;
	private Connection conn=new DBConnection().getConnection();
	/**
	 * 带参数的构造方法，实例化账号为id的实例
	 * @param id
	 */
	public VipShow(String id) {
		this.id=id;
	}
	/**
	 * 成员方法，更新账号为id的账号的VIP数据
	 */
	public void update() {
		String sql="update user set vip=1 where 账号=?";
		try(PreparedStatement stmt=conn.prepareStatement(sql)) {
			stmt.setString(1,id);
			stmt.executeUpdate();
		}catch(Exception e) {
			
		}
	}
	/**
	 * 成员方法，查询账号为id的VIP数据
	 * @return
	 */
	public float search() {
		String sql="select VIP from user where 账号=?";
		float vip=0;
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				vip=rs.getFloat("VIP");
				}
			}catch(Exception e) {
				e.printStackTrace();
		}
		return vip;
	}
}
