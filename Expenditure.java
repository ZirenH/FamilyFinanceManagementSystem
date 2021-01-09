package com.zirong.vo;

import java.io.Serializable;
/**
 * 支出实体类， 用以产生相关成员变量数据通过连接数据库来生成表等
 * @author ZirongHuang
 *
 */
public class Expenditure implements Serializable{
	private String purpose;
	private String person;
	private String acount;
	private String date;
	private String remark;
	public Expenditure() {
		
	}
	/**
	 * 实例化Expenditure对象
	 * @param purpose
	 * @param person
	 * @param acount
	 * @param date
	 * @param remark
	 */
	public Expenditure(String purpose, String person, String acount, String date, String remark) {
		super();
		this.purpose = purpose;
		this.person = person;
		this.acount = acount;
		this.date = date;
		this.remark = remark;
	}
	/**
	 * 
	 * @return
	 */
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getAcount() {
		return acount;
	}
	public void setAcount(String acount) {
		this.acount = acount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
