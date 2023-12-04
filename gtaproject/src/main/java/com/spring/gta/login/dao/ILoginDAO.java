package com.spring.gta.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.gta.login.vo.LoginVO;

@Mapper
public interface ILoginDAO {
    
    // 1. 회원 등록
    //    이 메서드는 회원을 등록하는 데 사용됩니다. 
    //    파라미터로는 `LoginVO` 객체(`vo`)를 받고, 등록 프로세스의 결과를 나타내는 정수를 반환합니다.
    public int registMember(LoginVO vo);

    // 2. 회원 로그인
    //    이 메서드는 제공된 로그인 정보를 기반으로 회원을 검색하는 데 사용됩니다.
    //    로그인 프로세스에 문제가 발생하면 예외를 던집니다.
    public LoginVO loginMember(LoginVO vo) throws Exception;

    // 3. 로그인 사용자 목록 가져오기
    //    이 메서드는 모든 로그인 사용자의 목록을 가져옵니다.
    public List<LoginVO> getLoginList();

    // 4. 사용자 등록
    //    이 메서드는 사용자 등록에 사용됩니다.
    //    파라미터로는 `LoginVO` 객체(`vo`)를 받고, 등록 프로세스의 결과를 나타내는 정수를 반환합니다.
    public int registUser(LoginVO vo);

    // 5. 사용자명에 따라 사용자 가져오기
    //    이 메서드는 제공된 사용자명(`bId`)을 기반으로 사용자를 검색합니다.
    public LoginVO getUserByUsername(String bId);
    boolean isDuplicateId(String bId);
}
