package com.hotelstay.infra.kakaologin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KakakoController {
	

	    @RequestMapping(value = "/login/kakao")
	    public String kakaoLogin() {
	        return "redirect:https://kauth.kakao.com/oauth/authorize?response_type=code&client_id={fc5f1385a98519af1cc8656e9fafcbdc}&redirect_uri={https://localhost:8085/oauth/callback/kakao}";
	    }

	    // 카카오 콜백 처리
	    @RequestMapping(value ="/oauth/callback/kakao")
	    public String kakaoCallback(String code) {
	        
	        return "redirect:/usrIndex";
	    }
	}
	
	

