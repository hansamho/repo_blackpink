package com.hotelstay.infra.kakaonavi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoNaviService {
	
	@Value("${kakao_rest_key}")
    private String kakaoRestKey;
	
	 private final RestTemplate restTemplate = new RestTemplate();

	    public String getNaviRoute(String origin, String destination) {
	        String url = "https://apis-navi.kakaomobility.com/v1/directions?origin=" + origin + "&destination=" + destination;

	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "KakaoAK " + kakaoRestKey);

	        HttpEntity<String> entity = new HttpEntity<>(headers);
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

	        return response.getBody();
	    }
}
