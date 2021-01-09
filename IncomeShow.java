package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Vector;

import com.zirong.dbc.DBConnection;
/**
 * 收入表的操作类
 * @author ZirongHuang
 *
 */
public class IncomeShow {
	private Connection conn=new DBConnection().getConnection();
	/**
	 * 带参数的成员方法，查找账号为id的成员方法
	 * @param id
	 * @return
	 */
	public Vector showIncome(String id) {
		String sql="select id,类型,收入人,地点,日期,金额,备注 from income where 账号=?";
		Vector<Vector> v=new Vector();
		
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			
			//System.out.println(rs.next());
			while(rs.next()) {
				Vector row=new Vector();
				int id1=rs.getInt("id");
				String type=rs.getString("类型");
				String name=rs.getString("收入人");
				String place=rs.getString("地点");
				String date=rs.getString("日期");
				float acount=rs.getFloat("金额");
				String remark=rs.getString("备注");
				Collections.addAll(row, id1,type,name,place,date,acount,remark);
				Collections.addAll(v, row);
				}
			}catch(Exception e) {
				e.printStackTrace();
		}
		//System.out.println(v);
		return v;
	}
	/**
	 * 带参数的成员方法，计算收入金额
	 * @param id
	 * @return
	 */
	public Float incomeSum(String id) {
		String sql="select 金额 from income where 账号=?";
		Float sum=0f;
		Float acount=0f;
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				acount=rs.getFloat("金额");
				sum+=acount;
				}
			}catch(Exception e) {
				e.printStackTrace();
		}
		sum=(float) Math.round(((sum*100)/100));
		return sum;
	}
	/**
	 * 支出添加成员方法，添加支出至数据库
	 * @param type
	 * @param name
	 * @param place
	 * @param date
	 * @param acount
	 * @param remark
	 * @param id
	 */
	public void add(String type, String name,String place, String date, float acount, String remark, String id) {
		String sql = "insert into income(类型,收入人,地点,日期,金额,备注,账号) values (?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, type);
			stmt.setString(2, name);
			stmt.setString(3, place);
			stmt.setString(4, date);
			stmt.setFloat(5, acount);
			stmt.setString(6, remark);
			stmt.setString(7, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 带参数的成员方法,删除账号为row的一行数据
	 * @param row
	 */
	public void delete(int row) {
		String sql = "delete from income where id=" + row;
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 带参数的成员方法，更新支出表的一行数据
	 * @param row
	 * @param purpose
	 * @param place
	 * @param name
	 * @param date
	 * @param acount
	 * @param remark
	 */
	public void update(int row,String purpose, String place,String name, String date, Float acount, String remark) {
		conn = new DBConnection().getConnection();
		String sql="update income set 类型=?,收入人=?,地点=?,日期=?,金额=?,备注=? where id="+row;
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {

			/*System.out.println(name);*/
			stmt.setString(1, purpose);
			stmt.setString(2, name);
			stmt.setString(3, place);
			stmt.setString(4, date);
			stmt.setFloat(5, acount);
			stmt.setString(6, remark);
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 带参数的成员方法，查找名字为或者带有name的一行数据
	 * @param name
	 * @return
	 */
	public Vector search(String name) {
		String sql = "select id,类型,收入人,地点,日期,金额,备注 from income where 收入人 like '%" + name + "%'";
		Vector<Vector> v = new Vector();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Vector row = new Vector();
				int id1=rs.getInt("id");
				String type = rs.getString("类型");
				String name1 = rs.getString("收入人");
				String place = rs.getString("地点");
				String date = rs.getString("日期");
				float acount = rs.getFloat("金额");
				String remark = rs.getString("备注");
				Collections.addAll(row, id1,type,name1,place, date, acount, remark);
				Collections.addAll(v, row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(v);
		return v;
	}
}
