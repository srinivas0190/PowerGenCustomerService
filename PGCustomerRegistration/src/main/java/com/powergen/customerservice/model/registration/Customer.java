package com.powergen.customerservice.model.registration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Override
	public String toString() {
		 String str = uname + ":" + email + ":" + phoneNum;
		return str;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="uname", nullable = true)
	private String uname;
	
	@Column(name="password", nullable = true)
	private String password;
	
	@Column(name="email", nullable = true)
	private String email;
	
	@Column(name="phoneNum", nullable = true)
	private String phoneNum;	
	
	@Column(name="serv_id", nullable = true)
	private int serv_id;	
	
	public int getServ_id() {
		return serv_id;
	}
	public void setServ_id(int serv_id) {
		this.serv_id = serv_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
}
