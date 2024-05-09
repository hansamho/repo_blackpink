package com.hotelstay.infra.kakaologin;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoService {

	 public String getAccessToken(String code) {
	        // 카카오로부터 받은 인증 코드를 이용하여 액세스 토큰 요청
	        RestTemplate restTemplate = new RestTemplate();
	        String tokenUrl = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id={fc5f1385a98519af1cc8656e9fafcbdc}&redirect_uri={https://localhost:8085/oauth/callback/kakao}&code=" + code;
	        String response = restTemplate.postForObject(tokenUrl, null, String.class);
	        
	        // 응답에서 액세스 토큰 추출
	        // (실제로는 JSON 파싱 등을 통해 값을 추출해야 함)
	        String accessToken = extractAccessTokenFromResponse(response);

	        return accessToken;
	    }

	    // 액세스 토큰을 응답에서 추출하는 메서드
	    private String extractAccessTokenFromResponse(String response) {
	        // 구현 필요
	        return null;
	    }
}
