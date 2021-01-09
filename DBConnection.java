package com.zirong.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	  private static final String DBRIVER="org.gjt.mm.mysql.Driver"; //����MySQL���ݿ���������
	  private static final String DBURL="jdbc:mysql://localhost:3306/FamilyFinancialSystem"; //����MySQL���ݿ����ӵ�ַ
	  private static final String DBUSER="root"; //MySQL���ݿ������û���
	  private static final String PASSWORD="123456"; //MySQL���ݿ���������
	  private Connection conn=null; //�������Ӷ���
	  public DBConnection() {//���췽���������ݿ�
	    try {
	      Class.forName(DBRIVER);
	      this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
	    } catch (Exception e) {e.printStackTrace();}
	  }
	  public Connection getConnection() {//�������ݿ����Ӷ���
	    return this.conn;
	  }
	  public void close() {//�ر���������
	    if(this.conn!=null) {
	      try {this.conn.close();} 
	      catch (SQLException e) {e.printStackTrace();}
	}
	    }
}