package com.hotelstay.infra.kakaoLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotelstay.infra.member.MemberDto;
import com.hotelstay.infra.member.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class KakaoLoginController {
	
    @Autowired
    KakaoLoginService service;
    
    @Autowired
    MemberService memberService;
    
    @Value("${kakao_rest_key}")
    private String kakaoRestKey;

    @Value("${kakao_redirect_url}")
    private String kakakoRedirectUrl;
    
    @Value("${kakao_location}")
    private String location;

    @RequestMapping(value="/kakaoLogin")
    public String kakaoLogin(Model model) throws Exception {
        String location = "https://kauth.kakao.com/oauth/authorize?client_id="+kakaoRestKey+"&redirect_uri="+kakakoRedirectUrl+"&response_type=code&scope=account_email";
        System.out.println(location);
        model.addAttribute("location", location);
        model.addAttribute("kakaoRestKey", kakaoRestKey);
        model.addAttribute("kakaoRedirectUri", kakakoRedirectUrl);
        return "usr/infra/index/kakaoLogin";
    }

    @RequestMapping(value="/redirectKakao")
    public String loginKakaoRedirect(KakaoLoginDto dto,KakaoLoginDto isDto,MemberDto dto2,Model model,HttpSession httpSession) throws Exception {
        System.out.println("dto.getCode()================"+dto.getCode());
        // 토큰 받기 
        String accessToken = service.getAccessTokenFromKakao(kakaoRestKey, dto.getCode());
        dto = service.getUserInfo(accessToken, dto);
        
        model.addAttribute("info", dto);
  
        String id =dto.getEmail();
        dto2.setMemberID(id);
        MemberDto dDto = memberService.selectLogin(dto2);
        String loginUrl = null;
        
        
        if(dDto != null){
        	if(id.equals(dDto.getMemberID())) 
        	{
        		httpSession.setAttribute("sessSeqUsr", dDto.getMemberSeq());
    			httpSession.setAttribute("sessIdUsr", dDto.getMemberID());
    			httpSession.setAttribute("sessNameUsr", dDto.getMemberName());
    			
    			System.out.println("httpSession.getAttribute(\"sessSeqUsr\"): " + httpSession.getAttribute("sessSeqUsr"));
            	loginUrl="/usrIndex";
        	}
        	
        }
        else 
        {
        	service.kakaoLoginInsert(isDto);
        	loginUrl="/usrIndex";
        }
        		
        
        return "redirect:/usrIndex";
    }
}
	
	

