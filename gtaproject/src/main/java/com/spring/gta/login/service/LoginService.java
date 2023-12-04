// LoginService.java

package com.spring.gta.login.service;

import javax.security.auth.RefreshFailedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gta.login.dao.ILoginDAO;
import com.spring.gta.login.vo.LoginVO;

@Service
public class LoginService {
    
    @Autowired
    ILoginDAO dao;

    public boolean login(String username, String password) {
        // 사용자가 입력한 아이디로 데이터베이스에서 사용자 정보를 가져옴
        LoginVO user = dao.getUserByUsername(username);

        // 사용자 정보가 존재하고, 비밀번호가 일치하면 로그인 성공
        return user != null && user.getbPwd().equals(password);
    }

    // 회원가입
    public void registUser(LoginVO vo) throws RefreshFailedException {
        int result = dao.registUser(vo);
        if (result == 0) {
            throw new RefreshFailedException("회원가입에 실패했습니다. 다시 시도해주세요");
        }
    }

	public boolean isIdDuplicate(String bId) {
		// TODO Auto-generated method stub
		return false;
	}

    
 
    }

