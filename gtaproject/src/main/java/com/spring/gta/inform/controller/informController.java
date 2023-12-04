package com.spring.gta.inform.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.gta.inform.service.InformService;
import com.spring.gta.inform.vo.InformVO;
import com.spring.gta.inform.vo.SearchVO;

@Controller
public class informController {
	  private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	InformService informservice;

	// 6. 게시글 목록 화면으로 이동
	@RequestMapping("/inform")
	public String inform(Model model) {
		List<InformVO> informList =informservice.getInformList();
		model.addAttribute("informList", informList);
		return "ex/inform";
	}

	// 6.1 게시글 작성 화면으로 이동
	@RequestMapping("/inform/write")
	public String informWrite() {
		return "ex/informWrite";
	}

	// 6.1.0.1 게시글 작성 처리
	@PostMapping("/inform/write.do")
	public String informWriteDo(InformVO info) throws Exception {
		info.setbId("123"); // 예시로 고정된 게시자 ID를 설정
		informservice.writeInform(info);
		return "redirect:/inform";
	}

	// 6.2 게시글 상세 화면으로 이동
	@RequestMapping("/inform/detail")
	public String informDetail(Model model, int iNum) throws Exception {
		
		InformVO informVO = informservice.getInform(iNum);

	    model.addAttribute("inform", informVO);
		
		return "ex/informDetail";
	}

    // 6.2.1 게시글 수정 화면으로 이동
    @RequestMapping("/inform/rewrite")
    public String informRewrite(Model model, int iNum, String password,
                                RedirectAttributes redirectAttributes) throws Exception {
        InformVO informVO = informservice.getInform(iNum);

        // 로그 추가
        logger.debug("iNum: {}", iNum);
        logger.debug("password: {}", password);
        logger.debug("informVO.getiPwd(): {}", informVO.getiPwd());

        // 비밀번호 일치 여부 로그
        if (informVO.getiPwd().equals(password)) {
            logger.debug("비밀번호 일치");
            model.addAttribute("inform", informVO);
            return "ex/informRewrite";
        } else {
            logger.debug("비밀번호 불일치");

            // 비밀번호 불일치 시 에러 메시지와 함께 상세 화면으로 리다이렉트
            redirectAttributes.addFlashAttribute("errorMsg", "비밀번호가 옳바르지 않습니다.");
            return "redirect:/inform/detail?iNum=" + iNum;
        }
    }
 // 6.2.0.1 게시글 삭제기능
    @RequestMapping("/inform/delete.do")
    public String informDelete(Model model, int iNum, String password,
                               RedirectAttributes redirectAttributes) throws Exception {
        InformVO informVO = informservice.getInform(iNum);

        // 비밀번호 일치 여부
        if (informVO.getiPwd().equals(password)) {
            informservice.deleteInform(informVO);
            return "redirect:/inform";
        } else {
            // 비밀번호 불일치 시 에러 메시지와 함께 상세 화면으로 리다이렉트
            redirectAttributes.addFlashAttribute("errorMsg", "비밀번호가 옳바르지 않습니다.");
            return "redirect:/inform/detail?iNum=" + iNum;
        }
    }
    
    

	// 6.2.1.1 게시글 수정 처리
	@PostMapping("/inform/rewrite.do")
	public String informRewriteDo(InformVO inform) {
		informservice.rewriteinform(inform);
		return "redirect:/inform";
	
	}
	//6.0.0.1 게시글 검색
	@ResponseBody
    @RequestMapping("/inform/search")
    public List<InformVO> informSearchAsync(@RequestParam("searchOption") String searchOption,
                                           @RequestParam("keyword") String keyword) {
        SearchVO searchVO = new SearchVO();
        searchVO.setSearchOption(searchOption);
        searchVO.setKeyword(keyword);
        System.out.print(searchOption);
        System.out.print(keyword);
        List<InformVO> informList = informservice.searchInformList(searchVO);
        System.out.print(informList);
        return informList;
    }
}
