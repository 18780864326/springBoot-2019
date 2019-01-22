package com.example.demo.entity;
// Generated 2019/1/19 ���� 08:44:26 by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LineArea generated by hbm2java
 */
@Entity
@Table(name = "LINE_AREA", schema = "SCOTT")
public class LineArea implements java.io.Serializable {

	private Long lineAreaId;
	private String lineAreaBuild;
	private String lineAreaF;
	private String lineAreaLine;
	private String lineAreaName;
	private String lineAreaDescription;
	private String lineAreaProcess;

	public LineArea() {
	}

	public LineArea(Long lineAreaId) {
		this.lineAreaId = lineAreaId;
	}

	public LineArea(Long lineAreaId, String lineAreaBuild, String lineAreaF, String lineAreaLine,
			String lineAreaName, String lineAreaDescription, String lineAreaProcess) {
		this.lineAreaId = lineAreaId;
		this.lineAreaBuild = lineAreaBuild;
		this.lineAreaF = lineAreaF;
		this.lineAreaLine = lineAreaLine;
		this.lineAreaName = lineAreaName;
		this.lineAreaDescription = lineAreaDescription;
		this.lineAreaProcess = lineAreaProcess;
	}

	@Id

	@Column(name = "LINE_AREA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getLineAreaId() {
		return this.lineAreaId;
	}

	public void setLineAreaId(Long lineAreaId) {
		this.lineAreaId = lineAreaId;
	}

	@Column(name = "LINE_AREA_BUILD", length = 40)
	public String getLineAreaBuild() {
		return this.lineAreaBuild;
	}

	public void setLineAreaBuild(String lineAreaBuild) {
		this.lineAreaBuild = lineAreaBuild;
	}

	@Column(name = "LINE_AREA_F", precision = 22, scale = 0)
	public String getLineAreaF() {
		return this.lineAreaF;
	}

	public void setLineAreaF(String lineAreaF) {
		this.lineAreaF = lineAreaF;
	}

	@Column(name = "LINE_AREA_LINE", length = 100)
	public String getLineAreaLine() {
		return this.lineAreaLine;
	}

	public void setLineAreaLine(String lineAreaLine) {
		this.lineAreaLine = lineAreaLine;
	}

	@Column(name = "LINE_AREA_NAME", length = 100)
	public String getLineAreaName() {
		return this.lineAreaName;
	}

	public void setLineAreaName(String lineAreaName) {
		this.lineAreaName = lineAreaName;
	}

	@Column(name = "LINE_AREA_DESCRIPTION", length = 200)
	public String getLineAreaDescription() {
		return this.lineAreaDescription;
	}

	public void setLineAreaDescription(String lineAreaDescription) {
		this.lineAreaDescription = lineAreaDescription;
	}

	@Column(name = "LINE_AREA_PROCESS", length = 200)
	public String getLineAreaProcess() {
		return this.lineAreaProcess;
	}

	public void setLineAreaProcess(String lineAreaProcess) {
		this.lineAreaProcess = lineAreaProcess;
	}

}
