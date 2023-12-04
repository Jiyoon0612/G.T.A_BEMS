package com.spring.gta.inform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gta.inform.dao.IinformDAO;
import com.spring.gta.inform.vo.InformVO;
import com.spring.gta.inform.vo.SearchVO;

@Service
public class InformService {

	
	@Autowired
	IinformDAO dao;
	
	public List<InformVO> getInformList() {
		List<InformVO> informlist = dao.getInformList();

		return informlist;
	}
	public void writeInform(InformVO info) throws Exception {
            dao.writeInform(info);
         
	}
	public InformVO getInform(int iNum) throws Exception {
		InformVO result = dao.getInform(iNum);
		if(result == null) {
			throw new Exception();
		}
		return result;
	}	
	public void rewriteinform(InformVO inform) {
		dao.rewriteInform(inform);
	}

	public void deleteInform(InformVO boardNo) throws Exception {
		int result = dao.deleteInform(boardNo);
		if(result == 0) {
			throw new Exception();
	}
	}
	public List<InformVO> searchInformList(SearchVO searchVO) {
		List<InformVO> result=dao.searchInformList(searchVO);
		//System.out.print(result);
		return result;
    }
	
}
