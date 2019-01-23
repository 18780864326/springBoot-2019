package com.example.demo.m2.service;

import com.example.demo.entity.MonitorArea;
import com.example.demo.m2.dto.LineAreaDto;
import com.example.demo.m2.dto.MonitorInfoDto;
import com.example.demo.utils.PagingTool;

public interface MonitorInfoService {

	/**
	 *存储更新监控设备信息
	 * @param monitorArea 出入格式
	 * @return Integer 1表示存储成功 0 表示失败
	 */
	public Integer saveOrUpdateMonitorInfo(MonitorArea monitorArea);
	
	/**
	 *存储更新	监控设备所属区域信息
	 * @param monitorArea 出入格式
	 * @return Integer 1表示存储成功 0 表示失败
	 */
	public Integer saveOrUpdateLineAreaInfo(LineAreaDto lineAreaDto);
	
	/**
	 *  分页查询监控设备信息
	 * @param dto 
	 * @param pagingSize
	 * @param pagingIndex
	 * @return
	 */
	public PagingTool<MonitorInfoDto> queryMonitorAreaInfoBypageInfo(MonitorInfoDto dto,int pagingSize,int pagingIndex);
	
	/**
	 * 分页查询 线区域信息
	 * @param dto
	 * @return
	 */
	public PagingTool<LineAreaDto> queryLineAreaInfoInfoBypageInfo(LineAreaDto dto);
}
