package com.spring.gta.dashboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.gta.dashboard.vo.ChartVO;
import com.spring.gta.dashboard.vo.DashboardVO;
import com.spring.gta.dashboard.vo.DashboardsearchVO;

/**
 * Class Name  : IDashboardDAO
 * Author      : ksj
 * Created Date: 2023. 11. 22.
 * Version: 1.0
 * Purpose:   
 * Description: 
 */
@Mapper
public interface IDashboardDAO {

	//대시보드
	public DashboardVO getmonth(DashboardsearchVO search);
	public DashboardVO getdashboardSearchList(DashboardsearchVO search) ;
	public List<ChartVO> getChartData(String currentDataset);
	public DashboardVO getHorizontal();
}
