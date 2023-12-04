/**
 * 
 */
package com.spring.gta.dashboard.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.gta.dashboard.service.DashboardService;
import com.spring.gta.dashboard.vo.ChartVO;
import com.spring.gta.dashboard.vo.DashboardVO;
import com.spring.gta.dashboard.vo.DashboardsearchVO;

/**
 * Class Name  : DashboardController
 * Author      : ksj
 * Created Date: 2023. 11. 22.
 * Version: 1.0
 * Purpose:   
 * Description: 
 */
@Controller
public class DashboardController {
	
	@Autowired
	DashboardService dashBoardService;
	
	@RequestMapping("/dashboard")
	public String dashBoardList(Model model) {
		
		return "dashboard/dashboard";
	}
	
	@ResponseBody
	@PostMapping("/dashBoardData.do")
    public DashboardVO dashBoardData(@RequestBody DashboardsearchVO search,HttpSession session) throws Exception {
		search.setbId((String)session.getAttribute("login"));
		DashboardVO result = dashBoardService.getdashboardSearchList(search);
		return result;
	}
	@PostMapping("/chart.do")
	@ResponseBody
	public List<ChartVO> getChartData(@RequestBody Map<String, String> requestData) {
	    String currentDataset = requestData.get("dataset");
	    return dashBoardService.getChartData(currentDataset);
	}
	@PostMapping("/chart2.do")
	@ResponseBody
	public DashboardVO getChart2Data() {
		DashboardVO horizontalData = dashBoardService.getHorizontal();
		
		return horizontalData;
	}

}
