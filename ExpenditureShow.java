package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Vector;

import com.zirong.dbc.DBConnection;
/**
 * ֧����Ĳ�����
 * @author ZirongHuang
 *
 */
public class ExpenditureShow {
	private Connection conn = new DBConnection().getConnection();
	/**
	 * �������ĳ�Ա�����������˺�Ϊid�ĳ�Ա����
	 * @param id
	 * @return
	 */
	public Vector showExpenditure(String id) {
		String sql = "select id,��;,֧����,����,���,��ע from expenditure where �˺�=?";
		Vector<Vector> v = new Vector();

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			// System.out.println(rs.next());
			while (rs.next()) {
				Vector row = new Vector();
				int id1	= rs.getInt("id");
				String type = rs.getString("��;");
				String name = rs.getString("֧����");
				String date = rs.getString("����");
				float acount = rs.getFloat("���");
				String remark = rs.getString("��ע");
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
	 * �������ĳ�Ա����������֧�����
	 * @param id
	 * @return
	 */
	public Float getSum(String id) {
		String sql="select ��� from expenditure where �˺�=?";
		Float sum=0f;
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Float acount=rs.getFloat("���");
				sum+=acount;
				}
			}catch(Exception e) {
				e.printStackTrace();
		}
		sum=(float) Math.round(((sum*100)/100));
		return sum;
	}
	/**
	 * ֧����ӳ�Ա���������֧�������ݿ�
	 * @param purpose
	 * @param name
	 * @param date
	 * @param acount
	 * @param remark
	 * @param id
	 */
	public void add(String purpose, String name, String date, float acount, String remark, String id) {
		String sql = "insert into expenditure(��;,֧����,����,���,��ע,�˺�) values (?,?,?,?,?,?)";
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
	 * �������ĳ�Ա����,ɾ���˺�Ϊrow��һ������
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
	 * �������ĳ�Ա��������������Ϊ���ߴ���name��һ������
	 * @param name
	 * @return
	 */
	public Vector search(String name) {
		String sql = "select ��;,֧����,����,���,��ע from expenditure where ֧���� like '%" + name + "%'";
		Vector<Vector> v = new Vector();

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			// System.out.println(rs.next());
			while (rs.next()) {
				Vector row = new Vector();
				String type = rs.getString("��;");
				String name1 = rs.getString("֧����");
				String date = rs.getString("����");
				float acount = rs.getFloat("���");
				String remark = rs.getString("��ע");
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
	 * �������ĳ�Ա����������֧�����һ������
	 * @param row
	 * @param purpose
	 * @param name
	 * @param date
	 * @param acount
	 * @param remark
	 */
	public void update(int row,String purpose, String name, String date, Float acount, String remark) {
		conn = new DBConnection().getConnection();
		String sql="update expenditure set ��;=?,֧����=?,����=?,���=?,��ע=? where id="+row;
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
