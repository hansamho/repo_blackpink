package com.hotelstay.infra.kakaoLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KakakoLoginController {
	
    @Autowired
    KakaoLoginService service;

    @Value("${kakao.rest_key}")
    private String kakaoRestKey;

    @Value("${kakao.redirect_url}")
    private String kakakoRedirectUrl;

    @RequestMapping(value="/kakaologin")
    public String kakaologin(Model model) throws Exception {
        String location = "https://kauth.kakao.com/oauth/authorize?client_id="+kakaoRestKey+"&redirect_uri="+kakakoRedirectUrl+"&response_type=code&scope=account_email";
        System.out.println(location);
        model.addAttribute("location", location);
        model.addAttribute("kakaoRestKey", kakaoRestKey);
        model.addAttribute("kakaoRedirectUri", kakakoRedirectUrl);
        return "kakaologin/kakaoLogin";
    }

    @RequestMapping(value="/redirectKakao")
    public String loginKakaoRedirect(KakaoLoginDto dto, KakaoLoginDto isDto, Model model) throws Exception {
        System.out.println("dto.getCode()================"+dto.getCode());
        // 토큰 받기 
        String accessToken = service.getAccessTokenFromKakao(kakaoRestKey, dto.getCode());
        dto = service.getUserInfo(accessToken, dto);
        model.addAttribute("info", dto);
        return "kakaologin/kakaoLoginCallBack";
    }
}
	
	

