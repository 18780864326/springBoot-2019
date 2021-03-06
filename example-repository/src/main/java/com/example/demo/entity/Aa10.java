package com.example.demo.entity;
// Generated 2019/1/18 ���� 05:06:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Aa10 generated by hbm2java
 */
@Entity
@Table(name = "AA10", schema = "SCOTT")
public class Aa10 implements java.io.Serializable {

	private String id;
	private String aaa100;
	private String aaa101;
	private String aaa102;
	private String aaa103;
	private String aae100;

	public Aa10() {
	}

	public Aa10(String id, String aaa100, String aaa102) {
		this.id = id;
		this.aaa100 = aaa100;
		this.aaa102 = aaa102;
	}

	public Aa10(String id, String aaa100, String aaa101, String aaa102, String aaa103, String aae100) {
		this.id = id;
		this.aaa100 = aaa100;
		this.aaa101 = aaa101;
		this.aaa102 = aaa102;
		this.aaa103 = aaa103;
		this.aae100 = aae100;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "AAA100", nullable = false, length = 20)
	public String getAaa100() {
		return this.aaa100;
	}

	public void setAaa100(String aaa100) {
		this.aaa100 = aaa100;
	}

	@Column(name = "AAA101", length = 50)
	public String getAaa101() {
		return this.aaa101;
	}

	public void setAaa101(String aaa101) {
		this.aaa101 = aaa101;
	}

	@Column(name = "AAA102", nullable = false, length = 20)
	public String getAaa102() {
		return this.aaa102;
	}

	public void setAaa102(String aaa102) {
		this.aaa102 = aaa102;
	}

	@Column(name = "AAA103", length = 100)
	public String getAaa103() {
		return this.aaa103;
	}

	public void setAaa103(String aaa103) {
		this.aaa103 = aaa103;
	}

	@Column(name = "AAE100", length = 1)
	public String getAae100() {
		return this.aae100;
	}

	public void setAae100(String aae100) {
		this.aae100 = aae100;
	}

}
