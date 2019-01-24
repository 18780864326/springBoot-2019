package com.example.demo.m2.dto;

import org.baseRepository.dto.OraclePageDto;

public class MonitorInfoDto  extends OraclePageDto {
	private Long monitorId;
	private String monitorPlay;//播放路徑參數
	private Long monitorAreaId;
	private String monitorDescription;//鏡頭描述
	private String monitorNvrIp;//NVR IP
	private String monitorNvrPassword;//NVR PASSWORD
	private Integer monitorCh;//NVR 通道
	private String monitorNvrUser;//NVR 賬號
	private String monitorCameraIp;//攝像頭IP,一般情況無用
	private String lineAreaProcess;//所属制程
	public Long getMonitorId() {
		return monitorId;
	}
	public void setMonitorId(Number monitorId) {
		this.monitorId =Long.parseLong(monitorId+"");
	}
	public String getMonitorPlay() {
		return monitorPlay;
	}
	public void setMonitorPlay(String monitorPlay) {
		this.monitorPlay = monitorPlay;
	}
	public String getMonitorDescription() {
		return monitorDescription;
	}
	public void setMonitorDescription(String monitorDescription) {
		this.monitorDescription = monitorDescription;
	}
	public String getMonitorNvrIp() {
		return monitorNvrIp;
	}
	public void setMonitorNvrIp(String monitorNvrIp) {
		this.monitorNvrIp = monitorNvrIp;
	}
	public String getMonitorNvrPassword() {
		return monitorNvrPassword;
	}
	public void setMonitorNvrPassword(String monitorNvrPassword) {
		this.monitorNvrPassword = monitorNvrPassword;
	}
	public String getMonitorNvrUser() {
		return monitorNvrUser;
	}
	public void setMonitorNvrUser(String monitorNvrUser) {
		this.monitorNvrUser = monitorNvrUser;
	}
	public String getMonitorCameraIp() {
		return monitorCameraIp;
	}
	public void setMonitorCameraIp(String monitorCameraIp) {
		this.monitorCameraIp = monitorCameraIp;
	}
	public String getLineAreaProcess() {
		return lineAreaProcess;
	}
	public void setLineAreaProcess(String lineAreaProcess) {
		this.lineAreaProcess = lineAreaProcess;
	}
	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}
	public void setMonitorAreaId(Long monitorAreaId) {
		this.monitorAreaId = monitorAreaId;
	}
	public void setMonitorCh(Integer monitorCh) {
		this.monitorCh = monitorCh;
	}
	@Override
	public String toString() {
		return "MonitorInfoDto [monitorId=" + monitorId + ", monitorPlay=" + monitorPlay + ", monitorAreaId="
				+ monitorAreaId + ", monitorDescription=" + monitorDescription + ", monitorNvrIp=" + monitorNvrIp
				+ ", monitorNvrPassword=" + monitorNvrPassword + ", monitorCh=" + monitorCh + ", monitorNvrUser="
				+ monitorNvrUser + ", monitorCameraIp=" + monitorCameraIp + ", lineAreaProcess=" + lineAreaProcess
				+ "]";
	}

	
}
