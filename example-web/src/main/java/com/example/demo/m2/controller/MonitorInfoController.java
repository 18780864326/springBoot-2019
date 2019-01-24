package com.example.demo.m2.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.LineArea;
import com.example.demo.m2.dto.LineAreaDto;
import com.example.demo.m2.dto.MonitorInfoDto;
import com.example.demo.m2.service.MonitorInfoService;
import com.example.demo.utils.PagingTool;
import com.example.demo.vo.MessageInfo;

@RequestMapping("/monitorArea")
@RestController
public class MonitorInfoController {

	@Resource
	private MonitorInfoService monitorInfoService;
	
	@RequestMapping("queryMonitorInfo")
	public String  queryMonitorInfo(MonitorInfoDto monitorInfoDto,int pageSize,int pageIndex) {
		PagingTool<?> pagingTool = monitorInfoService.queryMonitorAreaInfoBypageInfo(monitorInfoDto, pageSize, pageIndex);
	   MessageInfo messageInfo = new 	MessageInfo();
	   messageInfo.setStatus(0);
	   messageInfo.setMsg("ok");
	   messageInfo.setData(pagingTool);
		JSONObject object = (JSONObject) JSONObject.toJSON(messageInfo);
		return JSONObject.toJSONString(object);
	}
	
	@RequestMapping("queryLineAreaInfo")
	public String queryLineAreaInfo(LineAreaDto lineAreaDto,int pageSize,int pageIndex) {
		PagingTool<LineArea> pagingTool = monitorInfoService.queryLineAreaInfoInfoBypageInfo(lineAreaDto, pageSize, pageIndex);
		 MessageInfo messageInfo = new 	MessageInfo();
		   messageInfo.setStatus(0);
		   messageInfo.setMsg("ok");
		   messageInfo.setData(pagingTool);
		JSONObject object = (JSONObject) JSONObject.toJSON(messageInfo);
		return JSONObject.toJSONString(object);
	}
	
	@RequestMapping("saveMonitorInfo")
	public String saveMonitorInfo(MonitorInfoDto monitorInfoDto) {
		Integer status = monitorInfoService.saveMonitorInfo(monitorInfoDto);
		return "ok";
	}
	
	@RequestMapping("saveLineAreaInfo")
	public String saveLineAreaInfo(LineAreaDto lineAreaDto) {
		Integer status = monitorInfoService.saveLineAreaInfo(lineAreaDto);
		return "ok";
	}
	
	@RequestMapping("updateLineAreaInfo")
	public String updateLineAreaInfo(LineAreaDto lineAreaDto) {
		Integer status = monitorInfoService.updateLineAreaInfo(lineAreaDto);
		return "ok";
	}
	
	@RequestMapping("updateMonitorInfo")
	public String updateMonitorInfo(MonitorInfoDto monitorInfoDto) {
		Integer status = monitorInfoService.updataMonitorInfo(monitorInfoDto);
		return "ok";
	}
	@RequestMapping("getMonitorInfo")
	public String getMonitorInfo(Long monitorAreaId) {
		MonitorInfoDto monitorInfoDto = monitorInfoService.queryMonitorAreaInfoById(monitorAreaId);
	    MessageInfo messageInfo = new MessageInfo();
	    int  status = 0;
		if(monitorInfoDto != null ) {
			status=1;
		}
		messageInfo.setStatus(status);
		messageInfo.setData(monitorInfoDto);
		JSONObject obj = (JSONObject) JSONObject.toJSON(messageInfo);
		return JSONObject.toJSONString(obj);
	}
	
	@RequestMapping("getLineAreaInfo")
	public String getLineAreaInfo(Long lineAreaId) {
		LineAreaDto lineAreaDto = monitorInfoService.queryLineAreaInfoInfoById(lineAreaId);
		 MessageInfo messageInfo = new MessageInfo();
		    int  status = 0;
			if(lineAreaDto != null ) {
				status=1;
			}
			messageInfo.setStatus(status);
			messageInfo.setData(lineAreaDto);
			JSONObject obj = (JSONObject) JSONObject.toJSON(messageInfo);
			return JSONObject.toJSONString(obj);
	}
}
