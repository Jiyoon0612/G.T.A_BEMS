package com.spring.gta.inform.vo;

public class SearchVO {

	private String keyword;
	private String searchOption;

	public SearchVO() {
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	@Override
	public String toString() {
		return "SearchVO [keyword=" + keyword + ", searchOption=" + searchOption + "]";
	}

}