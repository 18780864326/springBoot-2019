package com.example.demo.m2.dto;

import java.util.List;


public class LineAreaDto {
	private Long lineAreaId;
	private String lineAreaBuild;//所属楼栋
	private String lineAreaF;//所属楼层
	private String lineAreaLine;//所属线别/模组
	private String lineAreaName;//覆盖范围
	private String lineAreaDescription;//描述
	private String lineAreaProcess;//所属制程
	private List<MonitorInfoDto> list;
	public Long getLineAreaId() {
		return lineAreaId;
	}
	public void setLineAreaId(Long lineAreaId) {
		this.lineAreaId = lineAreaId;
	}
	public String getLineAreaBuild() {
		return lineAreaBuild;
	}
	public void setLineAreaBuild(String lineAreaBuild) {
		this.lineAreaBuild = lineAreaBuild;
	}
	public String getLineAreaF() {
		return lineAreaF;
	}
	public void setLineAreaF(String lineAreaF) {
		this.lineAreaF = lineAreaF;
	}
	public String getLineAreaLine() {
		return lineAreaLine;
	}
	public void setLineAreaLine(String lineAreaLine) {
		this.lineAreaLine = lineAreaLine;
	}
	public String getLineAreaName() {
		return lineAreaName;
	}
	public void setLineAreaName(String lineAreaName) {
		this.lineAreaName = lineAreaName;
	}
	public String getLineAreaDescription() {
		return lineAreaDescription;
	}
	public void setLineAreaDescription(String lineAreaDescription) {
		this.lineAreaDescription = lineAreaDescription;
	}
	public String getLineAreaProcess() {
		return lineAreaProcess;
	}
	public void setLineAreaProcess(String lineAreaProcess) {
		this.lineAreaProcess = lineAreaProcess;
	}
	public List<MonitorInfoDto> getList() {
		return list;
	}
	public void setList(List<MonitorInfoDto> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "LineAreaDto [lineAreaId=" + lineAreaId + ", lineAreaBuild=" + lineAreaBuild + ", lineAreaF=" + lineAreaF
				+ ", lineAreaLine=" + lineAreaLine + ", lineAreaName=" + lineAreaName + ", lineAreaDescription="
				+ lineAreaDescription + ", lineAreaProcess=" + lineAreaProcess + ", list=" + list + "]";
	}
	
}
