package com.example.demo.m2.service;

import com.example.demo.entity.LineArea;
import com.example.demo.m2.dto.LineAreaDto;
import com.example.demo.m2.dto.MonitorInfoDto;
import com.example.demo.utils.PagingTool;

public interface MonitorInfoService {

	/**
	 *存储监控设备信息
	 * @param monitorArea 出入格式
	 * @return Integer 1表示存储成功 0 表示失败
	 */
	public Integer saveMonitorInfo(MonitorInfoDto monitorInfoDto);
	
	/**
	 *更新监控设备信息
	 * @param monitorArea 出入格式
	 * @return Integer 1表示存储成功 0 表示失败
	 */
	public Integer updataMonitorInfo(MonitorInfoDto monitorInfoDto);
	
	/**
	 *存储	监控设备所属区域信息
	 * @param monitorArea 出入格式
	 * @return Integer 1表示存储成功 0 表示失败
	 */
	public Integer saveLineAreaInfo(LineAreaDto lineAreaDto);
	
	/**
	 *更新监控设备所属区域信息
	 * @param monitorArea 出入格式
	 * @return Integer 1表示存储成功 0 表示失败
	 */
	public Integer updateLineAreaInfo(LineAreaDto lineAreaDto);
	
	/**
	* @Title: deleteLineAreaInfo 
	* @Description:删除数据
	* @param id
	 */
	public void deleteLineAreaInfo(Long id);
	
	/**
	 * 
	* @Title: deleteMonitorInfo 
	* @Description:删除数据
	* @param id
	 */
	public void deleteMonitorInfo(Long  id);
	
	/**
	 *  分页查询监控设备信息
	 * @param dto 
	 * @param pagingSize
	 * @param pagingIndex
	 * @return
	 */
	public PagingTool<?> queryMonitorAreaInfoBypageInfo(MonitorInfoDto monitorInfoDto,int pagingSize,int pagingIndex);
	
	/**
	 * 分页查询 线区域信息
	 * @param dto
	 * @return
	 */
	public PagingTool<LineArea> queryLineAreaInfoInfoBypageInfo(LineAreaDto lineAreaDto,int pagingSize,int pagingIndex);
	
	/**
	 * 根据 查询id 查询监控设备某条数据
	 * @param monitorAreaId
	 * @return
	 */
	public MonitorInfoDto  queryMonitorAreaInfoById(Long monitorAreaId);
	
	/**
	 * 根据 查询id 查询线区某条数据
	 * @param lineAreaId
	 * @return
	 */
	public LineAreaDto queryLineAreaInfoInfoById(Long lineAreaId);
}
