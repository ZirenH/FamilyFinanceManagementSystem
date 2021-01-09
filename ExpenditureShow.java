package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Vector;

import com.zirong.dbc.DBConnection;
/**
 * 支出表的操作类
 * @author ZirongHuang
 *
 */
public class ExpenditureShow {
	private Connection conn = new DBConnection().getConnection();
	/**
	 * 带参数的成员方法，查找账号为id的成员方法
	 * @param id
	 * @return
	 */
	public Vector showExpenditure(String id) {
		String sql = "select id,用途,支出人,日期,金额,备注 from expenditure where 账号=?";
		Vector<Vector> v = new Vector();

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			// System.out.println(rs.next());
			while (rs.next()) {
				Vector row = new Vector();
				int id1	= rs.getInt("id");
				String type = rs.getString("用途");
				String name = rs.getString("支出人");
				String date = rs.getString("日期");
				float acount = rs.getFloat("金额");
				String remark = rs.getString("备注");
				Collections.addAll(row, id1,type, name, date, acount, remark);
				Collections.addAll(v, row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(v);
		return v;
	}
	/**
	 * 带参数的成员方法，计算支出金额
	 * @param id
	 * @return
	 */
	public Float getSum(String id) {
		String sql="select 金额 from expenditure where 账号=?";
		Float sum=0f;
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Float acount=rs.getFloat("金额");
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
	 * @param purpose
	 * @param name
	 * @param date
	 * @param acount
	 * @param remark
	 * @param id
	 */
	public void add(String purpose, String name, String date, float acount, String remark, String id) {
		String sql = "insert into expenditure(用途,支出人,日期,金额,备注,账号) values (?,?,?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, purpose);
			stmt.setString(2, name);
			stmt.setString(3, date);
			stmt.setFloat(4, acount);
			stmt.setString(5, remark);
			stmt.setString(6, id);
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
		String sql = "delete from expenditure where id=" + row;
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 带参数的成员方法，查找名字为或者带有name的一行数据
	 * @param name
	 * @return
	 */
	public Vector search(String name) {
		String sql = "select 用途,支出人,日期,金额,备注 from expenditure where 支出人 like '%" + name + "%'";
		Vector<Vector> v = new Vector();

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			// System.out.println(rs.next());
			while (rs.next()) {
				Vector row = new Vector();
				String type = rs.getString("用途");
				String name1 = rs.getString("支出人");
				String date = rs.getString("日期");
				float acount = rs.getFloat("金额");
				String remark = rs.getString("备注");
				Collections.addAll(row, type, name1, date, acount, remark);
				Collections.addAll(v, row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(v);
		return v;
	}
	/**
	 * 带参数的成员方法，更新支出表的一行数据
	 * @param row
	 * @param purpose
	 * @param name
	 * @param date
	 * @param acount
	 * @param remark
	 */
	public void update(int row,String purpose, String name, String date, Float acount, String remark) {
		conn = new DBConnection().getConnection();
		String sql="update expenditure set 用途=?,支出人=?,日期=?,金额=?,备注=? where id="+row;
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			/*System.out.println(purpose);
			System.out.println(name);*/
			stmt.setString(1, purpose);
			stmt.setString(2, name);
			stmt.setString(3, date);
			stmt.setFloat(4, acount);
			stmt.setString(5, remark);
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public float[] sort(float[] acount) {
		float t=0;
		for (int i = 0; i < acount.length; i++) {
			for (int j = i + 1; j < acount.length; j++) {
				if(acount[i]<acount[j]) {
					t=acount[i];
					acount[i]=acount[j];
					acount[j]=t;
				}
			}
		}
		return acount;
	}
}
