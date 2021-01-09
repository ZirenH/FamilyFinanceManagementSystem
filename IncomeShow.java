package com.zirong.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Vector;

import com.zirong.dbc.DBConnection;
/**
 * �����Ĳ�����
 * @author ZirongHuang
 *
 */
public class IncomeShow {
	private Connection conn=new DBConnection().getConnection();
	/**
	 * �������ĳ�Ա�����������˺�Ϊid�ĳ�Ա����
	 * @param id
	 * @return
	 */
	public Vector showIncome(String id) {
		String sql="select id,����,������,�ص�,����,���,��ע from income where �˺�=?";
		Vector<Vector> v=new Vector();
		
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			
			//System.out.println(rs.next());
			while(rs.next()) {
				Vector row=new Vector();
				int id1=rs.getInt("id");
				String type=rs.getString("����");
				String name=rs.getString("������");
				String place=rs.getString("�ص�");
				String date=rs.getString("����");
				float acount=rs.getFloat("���");
				String remark=rs.getString("��ע");
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
	 * �������ĳ�Ա����������������
	 * @param id
	 * @return
	 */
	public Float incomeSum(String id) {
		String sql="select ��� from income where �˺�=?";
		Float sum=0f;
		Float acount=0f;
		try(PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				acount=rs.getFloat("���");
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
	 * @param type
	 * @param name
	 * @param place
	 * @param date
	 * @param acount
	 * @param remark
	 * @param id
	 */
	public void add(String type, String name,String place, String date, float acount, String remark, String id) {
		String sql = "insert into income(����,������,�ص�,����,���,��ע,�˺�) values (?,?,?,?,?,?,?)";
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
	 * �������ĳ�Ա����,ɾ���˺�Ϊrow��һ������
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
	 * �������ĳ�Ա����������֧�����һ������
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
		String sql="update income set ����=?,������=?,�ص�=?,����=?,���=?,��ע=? where id="+row;
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
	 * �������ĳ�Ա��������������Ϊ���ߴ���name��һ������
	 * @param name
	 * @return
	 */
	public Vector search(String name) {
		String sql = "select id,����,������,�ص�,����,���,��ע from income where ������ like '%" + name + "%'";
		Vector<Vector> v = new Vector();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Vector row = new Vector();
				int id1=rs.getInt("id");
				String type = rs.getString("����");
				String name1 = rs.getString("������");
				String place = rs.getString("�ص�");
				String date = rs.getString("����");
				float acount = rs.getFloat("���");
				String remark = rs.getString("��ע");
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
