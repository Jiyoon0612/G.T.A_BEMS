package com.spring.gta.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gta.dashboard.dao.IDashboardDAO;
import com.spring.gta.dashboard.vo.ChartVO;
import com.spring.gta.dashboard.vo.DashboardVO;
import com.spring.gta.dashboard.vo.DashboardsearchVO;

/**
 * Class Name : DashboardService Author : ksj Created Date: 2023. 11. 22.
 * Version: 1.0 Purpose: Description:
 */
@Service("DashboardService")
public class DashboardService {

	@Autowired
	IDashboardDAO dao;

	public DashboardVO getdashboardSearchList(DashboardsearchVO search) {
		DashboardVO result = dao.getdashboardSearchList(search);
		DashboardVO result2 = dao.getmonth(search);
		result.setMonth(result2.getMonth());
		return result;
	}
	public List<ChartVO> getChartData(String currentDataset) {
        return dao.getChartData(currentDataset);
    }
	public DashboardVO getHorizontal() {
		
		return dao.getHorizontal();
	}
}