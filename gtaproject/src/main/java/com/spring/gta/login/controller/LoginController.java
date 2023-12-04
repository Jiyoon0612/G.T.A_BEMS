package com.spring.gta.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.gta.login.service.LoginService;
import com.spring.gta.login.vo.LoginVO;

/**
 * Class Name  : LoginController
 * Author      : LYG
 * Created Date: 2023. 11. 21.
 * Version: 1.0
 * Purpose:  1.0.0.1
 * Description: 로그인 기능
 */
/**
/**
 * Class Name  : LoginController
 * Author      : LYG
 * Created Date: 2023. 11. 21.
 * Version: 1.0
 * Purpose: 1.2.0.1  
 * Description: 회원가입 기능
 */

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginservice;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        return "login/login"; // 로그인 페이지로 이동
    }
    

    @RequestMapping("/login.do")
    public String loginDo(Model model, HttpServletRequest request,
                          RedirectAttributes redirectAttributes, HttpSession session,
                          HttpServletResponse response) {
        String username = request.getParameter("memId");
        String password = request.getParameter("memPw");

        // loginservice가 null이 아닌지 확인합니다.
        if (loginservice != null) {
            // 실제 로그인 검증 로직을 수행합니다.
            boolean loginSuccess = loginservice.login(username, password);

            if (loginSuccess) {
                // 로그인이 성공하면 대시보드로 바로 리다이렉트합니다.
                session.setAttribute("login", username);

                // 로그인 성공 시 쿠키를 생성합니다.
                Cookie cookie = new Cookie("rememberId", username);
                cookie.setMaxAge(7 * 24 * 60 * 60); // 7일 동안 유효
                response.addCookie(cookie);

                return "redirect:/dashboard"; // 홈 페이지로 리다이렉트합니다.
            } else {
                // 로그인이 실패하면 로그인 화면으로 다시 이동합니다.
                redirectAttributes.addFlashAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
                return "redirect:/"; // 로그인 페이지로 리다이렉트합니다.
            }
        } else {
            // loginservice가 예상치 못하게 null일 경우 에러를 기록하거나 처리합니다.
            // 예를 들어 에러 메시지를 기록할 수 있습니다:
            logger.error("LoginService is null in login.do method.");
            // 또는 다른 방법으로 에러 상황을 처리할 수 있습니다.
            return "login/error"; // 에러 페이지로 리다이렉트하거나 필요한 대로 조정하세요.
        }
    }




// 3. 회원가입 페이지로 이동
	@RequestMapping("/join")
   		public String join() {
       // 회원가입 페이지로 이동합니다.
	   return "join/join";
    }
	
			

	 // 4. 회원가입 처리 메서드
    @RequestMapping(value = "/joinDo", method = RequestMethod.POST)
    public String joinDo(HttpServletRequest request, Model model) {
        String bId = request.getParameter("bId");
        String bPwd = request.getParameter("bPwd");
        String bName = request.getParameter("bName");
        String bAddr = request.getParameter("bAddr");
        String bHp = request.getParameter("bHp");

        LoginVO vo = new LoginVO(bId, bPwd, bName, bAddr, bHp);

        try {
            loginservice.registUser(vo);
            model.addAttribute("joinSuccess", "회원가입이 완료되었습니다. 로그인해주세요.");

            // JavaScript로 메시지 박스를 띄우기 위한 스크립트 추가
            model.addAttribute("joinSuccessScript", "alert('회원가입이 완료되었습니다. 로그인해주세요.');");

            return "redirect:/"; // 회원가입 성공 시 로그인 화면으로 리다이렉트
        } catch (DuplicateKeyException e) {
            // 중복된 아이디인 경우
            model.addAttribute("joinError", "중복된 아이디입니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return "login/error";
        }

        return "login/join";
    }
}





