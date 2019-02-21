package com.example.demo.repository;

import java.util.List;

import org.baseRepository.first.BaseRepository;

import com.example.demo.entity.MonitorArea;


public interface MonitorAreaRepository  extends BaseRepository<MonitorArea, Long>{
	MonitorArea findByMonitorIdAndValidFlag(long id,String validFlag);
	public List<MonitorArea> findAllByMonitorAreaIdAndValidFlag(Long monitorAreaId,String validFlag);
}
