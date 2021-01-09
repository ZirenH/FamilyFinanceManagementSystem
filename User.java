package com.zirong.vo;

import java.io.Serializable;
/**
 * 用户实体类
 *  用以产生相关成员变量数据通过连接数据库来生成表等
 * @author ZirongHuang
 *
 */
public class User implements Serializable {
	private String id;
	private String password;
	private String name;
	private String role;
	private Double amount;
	private Boolean vip;
	public User() {
		
	}
	public User(String id, String password, String name,String role, Double amount, Boolean vip) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.role=role;

		this.amount = amount;
		this.vip = vip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Boolean getVip() {
		return vip;
	}
	public void setVip(Boolean vip) {
		this.vip = vip;
	}
	
}
