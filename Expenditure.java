package com.zirong.vo;

import java.io.Serializable;
/**
 * ֧��ʵ���࣬ ���Բ�����س�Ա��������ͨ���������ݿ������ɱ��
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
	 * ʵ����Expenditure����
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
