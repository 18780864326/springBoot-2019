package com.example.demo.entity;
// Generated 2019/1/18 ���� 05:06:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysUser generated by hbm2java
 */
@Entity
@Table(name = "SYS_USER", schema = "SCOTT")
public class SysUser implements java.io.Serializable {

	private Long sysUserId;
	private String userName;
	private String userPassword;

	public SysUser() {
	}

	public SysUser(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public SysUser(Long sysUserId, String userName, String userPassword) {
		this.sysUserId = sysUserId;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	@Id

	@Column(name = "SYS_USER_ID", unique = true, nullable = false, precision = 18, scale = 0)
	public Long getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	@Column(name = "USER_NAME", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_PASSWORD", length = 20)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
