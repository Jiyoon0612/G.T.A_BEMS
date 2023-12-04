/**
 * 
 */
package com.spring.gta.dashboard.vo;

/**
 * Class Name  : DashboardsearchVO
 * Author      : ksj
 * Created Date: 2023. 11. 23.
 * Version: 1.0
 * Purpose:   
 * Description: 
 */
public class DashboardsearchVO {
	
	private String starDt;
	private String endDt;
	private String searchType;
	private String bId;
	
	public String getStarDt() {
		return starDt;
	}
	@Override
	public String toString() {
		return "DashboardsearchVO [starDt=" + starDt + ", endDt=" + endDt + ", searchType=" + searchType + ", bId="
				+ bId + "]";
	}
	public void setStarDt(String starDt) {
		this.starDt = starDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}

	public DashboardsearchVO() {
	}
	
}
