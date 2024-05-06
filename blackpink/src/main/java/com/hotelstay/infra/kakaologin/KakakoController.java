package com.hotelstay.infra.kakaologin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakakoController {
	

	    @GetMapping("/login/kakao")
	    public String kakaoLogin() {
	        return "redirect:https://kauth.kakao.com/oauth/authorize?response_type=code&client_id={fc5f1385a98519af1cc8656e9fafcbdc}&redirect_uri={fc5f1385a98519af1cc8656e9fafcbdc}";
	    }

	    // 카카오 콜백 처리
	    @GetMapping("/oauth/callback/kakao")
	    public String kakaoCallback(String code) {
	        // 인증 코드를 받아서 처리하는 로직
	        return "redirect:/";
	    }
	}
	
	

