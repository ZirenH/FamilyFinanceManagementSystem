package com.zirong.vo;

import java.io.Serializable;
/**
 * ����ʵ����
 *  ���Բ�����س�Ա��������ͨ���������ݿ������ɱ��
 * @author ZirongHuang
 *
 */

public class Income implements Serializable {
	private String type;	
	private String name;
	private String place;	
	private String data;	
	private Double amount;	
	private String remark;	
	public Income() {
		
	}
	public Income(String type, String name,String place, String data, Double amount, String remark) {
		super();
		this.type = type;
		this.name=name;
		this.place = place;
		this.data = data;
		this.amount = amount;
		this.remark = remark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return type +"\\t"+ place +"\\t"+ data +"\\t"+ amount +"\\t"+ remark ;
	}
	
}
