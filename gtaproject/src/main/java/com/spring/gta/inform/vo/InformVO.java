package com.spring.gta.inform.vo;

public class InformVO {
	private String bId;
	private String iDate;
	private String iName;
	private String iRank;
	private String iTitle;
	private String iContents;
	private String iPwd;
	private String iNum;
	
	
	
	
	public InformVO() {
		
	}




	public InformVO(String bId, String iDate, String iName, String iRank, String iTitle, String iContents, String iPwd,
			String iNum) {
	
		this.bId = bId;
		this.iDate = iDate;
		this.iName = iName;
		this.iRank = iRank;
		this.iTitle = iTitle;
		this.iContents = iContents;
		this.iPwd = iPwd;
		this.iNum = iNum;
	}




	public String getbId() {
		return bId;
	}




	public void setbId(String bId) {
		this.bId = bId;
	}




	public String getiDate() {
		return iDate;
	}




	public void setiDate(String iDate) {
		this.iDate = iDate;
	}




	public String getiName() {
		return iName;
	}




	public void setiName(String iName) {
		this.iName = iName;
	}




	public String getiRank() {
		return iRank;
	}




	public void setiRank(String iRank) {
		this.iRank = iRank;
	}




	public String getiTitle() {
		return iTitle;
	}




	public void setiTitle(String iTitle) {
		this.iTitle = iTitle;
	}




	public String getiContents() {
		return iContents;
	}




	public void setiContents(String iContents) {
		this.iContents = iContents;
	}




	public String getiPwd() {
		return iPwd;
	}




	public void setiPwd(String iPwd) {
		this.iPwd = iPwd;
	}




	public String getiNum() {
		return iNum;
	}




	public void setiNum(String iNum) {
		this.iNum = iNum;
	}




	@Override
	public String toString() {
		return "InformVO [bId=" + bId + ", iDate=" + iDate + ", iName=" + iName + ", iRank=" + iRank + ", iTitle="
				+ iTitle + ", iContents=" + iContents + ", iPwd=" + iPwd + ", iNum=" + iNum + "]";
	}
	
	
}
