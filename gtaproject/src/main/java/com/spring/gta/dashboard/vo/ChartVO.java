package com.spring.gta.dashboard.vo;

public class ChartVO {
    private String label;
    private float yesterdayData;
    private float todayData;
    private float totalModelData;
    
    

	public ChartVO() {
	
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public float getYesterdayData() {
		return yesterdayData;
	}



	public void setYesterdayData(float yesterdayData) {
		this.yesterdayData = yesterdayData;
	}



	public float getTodayData() {
		return todayData;
	}



	public void setTodayData(float todayData) {
		this.todayData = todayData;
	}



	public float getTotalModelData() {
		return totalModelData;
	}



	public void setTotalModelData(float totalModelData) {
		this.totalModelData = totalModelData;
	}



	@Override
	public String toString() {
		return "ChartVO [label=" + label + ", yesterdayData=" + yesterdayData + ", todayData=" + todayData
				+ ", totalModelData=" + totalModelData + "]";
	}
	
	
    
}
