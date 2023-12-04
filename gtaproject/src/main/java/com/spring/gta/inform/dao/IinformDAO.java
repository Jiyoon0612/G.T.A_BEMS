package com.spring.gta.inform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.gta.inform.vo.InformVO;
import com.spring.gta.inform.vo.SearchVO;

@Mapper
public interface IinformDAO {
	public List<InformVO> getInformList();
	public void writeInform(InformVO inform);
	public InformVO getInform(int iNum);
	public void rewriteInform(InformVO inform);
	public int deleteInform(InformVO idel);
	public List<InformVO> searchInformList(SearchVO searchVO);
}
