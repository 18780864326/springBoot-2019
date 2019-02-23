package com.example.demo.m2.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LineArea;
import com.example.demo.entity.MonitorArea;
import com.example.demo.m2.dto.LineAreaDto;
import com.example.demo.m2.dto.MonitorInfoDto;
import com.example.demo.m2.service.MonitorInfoService;
import com.example.demo.repository.LineAreaRepository;
import com.example.demo.repository.MonitorAreaRepository;
import com.example.demo.utils.PagingTool;

@Service
public class MonitorInfoServiceImpl  implements  MonitorInfoService{
	
	
	@Resource
	private LineAreaRepository lineAreaRepository;
	
	@Resource
	private MonitorAreaRepository monitorAreaRepository;

	@Override
	public PagingTool<?> queryMonitorAreaInfoBypageInfo(MonitorInfoDto monitorInfoDto, int pageSize,
			int pageIndex) {
		 PagingTool<Map<String, Object>> pagingTool = new PagingTool<Map<String, Object>>();
		 pagingTool.setPageSize(pageSize);
		 pagingTool.setCurrentPage(pageIndex);
		 String lineAreaProcess = monitorInfoDto.getLineAreaProcess();
		 
		String sql = "\r\n" + 
				"select  t.monitor_id as \"monitorId\",\r\n" + 
				"               t.monitor_play as \"monitorPlay\",\r\n" + 
				"               t.monitor_area_id as \"monitorAreaId\",\r\n" + 
				"               t.monitor_description as \"monitorDescription\",\r\n" + 
				"               t.monitor_nvr_ip as \"monitorNvrIp\",\r\n" + 
				"               t.monitor_nvr_password as \"monitorNvrPassword\",\r\n" + 
				"               t.monitor_ch as \"monitorCh\",\r\n" + 
				"               t.monitor_nvr_user as \"monitorNvrUser\",\r\n" + 
				"               t.monitor_camera_ip as \"monitorCameraIp\",\r\n" + 
				"               t.line_area_process as \"lineAreaProcess\"\r\n" + 
				"  from (select t.monitor_id,\r\n" + 
				"               t.monitor_play,\r\n" + 
				"               t.monitor_area_id,\r\n" + 
				"               t.monitor_description,\r\n" + 
				"               t.monitor_nvr_ip,\r\n" + 
				"               t.monitor_nvr_password,\r\n" + 
				"               t.monitor_ch,\r\n" + 
				"               t.monitor_nvr_user,\r\n" + 
				"               t.monitor_camera_ip,\r\n" + 
				"               a.line_area_process\r\n" + 
				"          from MONITOR_AREA t, LINE_AREA a\r\n" + 
				"         where t.valid_flag = 1 and t.monitor_area_id = a.line_area_id(+)) t\r\n" + 
				" where 1 = 1 \r\n" ;
			if(lineAreaProcess != null && !"".equals(lineAreaProcess)) {
				sql += " and upper(t.line_area_process) like upper('%"+lineAreaProcess+"%') " ;
			}
			Integer countNumber = monitorAreaRepository.countBySqlToInteger(sql);
			pagingTool.setTotalNumber(countNumber);
			
			 List<Map<String, Object>> list = monitorAreaRepository.ListBySqlAndPageInfoToMap
					(sql, pagingTool.getDbIndex(), pagingTool.getDbEnd());
			pagingTool.setDataList(list);
		return pagingTool;
	}

	@Override
	public PagingTool<LineArea> queryLineAreaInfoInfoBypageInfo(LineAreaDto lineAreaDto ,int pageSize,
			int pageIndex) {
		 PagingTool<LineArea> pagingTool = new PagingTool<LineArea>();
		 pagingTool.setPageSize(pageSize);
		 pagingTool.setCurrentPage(pageIndex);
		 String lineAreaProcess = lineAreaDto.getLineAreaProcess(); //条件参数 制程
		 String lineAreaBuild = lineAreaDto.getLineAreaBuild();//条件 参数 楼栋
		 String lineAreaF = lineAreaDto.getLineAreaF();//条件 参数 楼层
//		 String lineAreaLine = lineAreaDto.getLineAreaLine();//条件 参数 区别/模组
		String sql = 
				"select t.line_area_id,\r\n" + 
				"       t.line_area_build,\r\n" + 
				"       t.line_area_f,\r\n" + 
				"       t.line_area_line,\r\n" + 
				"       t.line_area_name,\r\n" + 
				"       t.line_area_description,\r\n" + 
				"       t.line_area_process, \r\n" + 
				"      	t.valid_flag\r\n" + 
				"  from LINE_AREA t\r\n" +
				" where t.valid_flag = 1 ";
		if(lineAreaF != null && !"".equals(lineAreaF)) {
			sql += " and t.line_area_f = upper('"+lineAreaF+"')\r\n";
		}
		if(lineAreaBuild != null && !"".equals(lineAreaBuild)) {
			sql += " and t.line_area_build like upper('%"+lineAreaBuild+"%')\r\n";
		}
		if(lineAreaProcess != null && !"".equals(lineAreaProcess)) {
			sql += " and upper(t.line_area_process) like upper('%"+lineAreaProcess+"%') " ;
		}
		Integer countNumber = monitorAreaRepository.countBySqlToInteger(sql);
		pagingTool.setTotalNumber(countNumber);
		List<LineArea> list = lineAreaRepository.listBySqlAndPageInfoToListEntity(sql, pagingTool.getDbIndex(), pagingTool.getDbEnd(), LineArea.class);
		pagingTool.setDataList(list);
		return pagingTool;
	}

	
	@Override
	public Integer saveLineAreaInfo(LineAreaDto lineAreaDto) {
		Integer status = null ;
	    Long  lineAreaId =
	    lineAreaRepository.getTableSequencesToLong("SEQ_LINE_AREA");
	     lineAreaDto.setLineAreaId(lineAreaId);
	      LineArea lineArea = new LineArea();
	     BeanUtils.copyProperties(lineAreaDto, lineArea);
	     lineArea.setValidFlag("1"); //有效
	     LineArea save = lineAreaRepository.save(lineArea);
	     if(save != null) {
	    	 status =1;
	     }
		return status;
	}


	@Override
	public Integer saveMonitorInfo(MonitorInfoDto monitorInfoDto) {
		Integer status = null ;
	    Long  monitorId =
	    		monitorAreaRepository.getTableSequencesToLong("SEQ_MONITOR_AREA");
	    monitorInfoDto.setMonitorId(monitorId);
	      MonitorArea monitorArea = new MonitorArea();
	     BeanUtils.copyProperties(monitorInfoDto, monitorArea);
	     monitorArea.setValidFlag("1"); //有效标识
	     MonitorArea save = monitorAreaRepository.save(monitorArea);
	     if(save != null) {
	    	 status =1;
	     }
		return status;
	}

	@Override
	public Integer updataMonitorInfo(MonitorInfoDto monitorInfoDto) {
		Integer status = null ;
	      MonitorArea monitorArea = new MonitorArea();
	     BeanUtils.copyProperties(monitorInfoDto, monitorArea);
	     MonitorArea save = monitorAreaRepository.save(monitorArea);
	     if(save != null) {
	    	 status =1;
	     }
		return status;
	}

	@Override
	public Integer updateLineAreaInfo(LineAreaDto lineAreaDto) {
		 LineArea lineArea = new LineArea();
		 BeanUtils.copyProperties(lineAreaDto, lineArea);
		 LineArea save = lineAreaRepository.save(lineArea);
		  Integer status = null;
		if(save != null) {
		    	 status =1;
		     }
		return status;
	}

	@Override
	public MonitorInfoDto queryMonitorAreaInfoById(Long monitorAreaId) {
		MonitorArea monitorArea = monitorAreaRepository.findByMonitorIdAndValidFlag(monitorAreaId,"1");
		MonitorInfoDto monitorInfoDto = null;
		if(monitorArea != null) {
			monitorInfoDto = new  MonitorInfoDto();
			BeanUtils.copyProperties(monitorArea,monitorInfoDto);
		}
		return monitorInfoDto;
	}

	@Override
	public LineAreaDto queryLineAreaInfoInfoById(Long lineAreaId) {
		  LineAreaDto lineAreaDto = null ;
		  if(lineAreaId == null) {
			  return lineAreaDto;
		  }
		  LineArea lineArea = lineAreaRepository.findBylineAreaIdAndValidFlag(lineAreaId,"1");
		 if(lineArea != null) {
			 lineAreaDto = new LineAreaDto();
			 BeanUtils.copyProperties(lineArea,lineAreaDto);
		 }
		 return lineAreaDto;
	}

	@Override
	public Integer deleteLineAreaInfo(Long id) {
		  LineArea lineArea = lineAreaRepository.findBylineAreaIdAndValidFlag(id,"1");
		  if(lineArea == null) {
			  return 2;
		  }
		  lineArea.setValidFlag("0"); //0标识 此条数据无效
		  lineAreaRepository.save(lineArea);
		 return 1;
	}

	@Override
	public Integer deleteMonitorInfo(Long id) {
		MonitorArea monitorArea = monitorAreaRepository.findByMonitorIdAndValidFlag(id,"1");
		 if(monitorArea == null) {
			  return 2;
		  }
		 monitorArea.setValidFlag("0");//0标识 此条数据无效
		monitorAreaRepository.save(monitorArea);
		 return 1;
	}
}	
