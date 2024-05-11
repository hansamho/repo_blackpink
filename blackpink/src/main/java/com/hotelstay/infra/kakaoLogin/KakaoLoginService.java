package com.hotelstay.infra.kakaoLogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KakaoLoginService {
	
	@Autowired
	KakaoLoginDao dao;
	
	
	
	// 토큰요청
		public String getAccessTokenFromKakao(String client_id, String code) throws IOException {
	        //------kakao POST 요청------
	        String reqURL = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id="+client_id+"&code="+code;
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	        String line = "";
	        String result = "";

	        while ((line = br.readLine()) != null) {
	            result += line;
	        }

	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {});

	        //System.out.println("Response Body : " + result);

	        String accessToken = (String) jsonMap.get("access_token");
	        //String refreshToken = (String) jsonMap.get("refresh_token");
	        //String scope = (String) jsonMap.get("scope");

	        return accessToken;
	    }
		
		// 사용자정보조회
		public KakaoLoginDto getUserInfo(String access_Token, KakaoLoginDto dto) throws IOException {
	        //------kakao GET 요청------
	        String reqURL = "https://kapi.kakao.com/v2/user/me";
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Authorization", "Bearer " + access_Token);

	        int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : " + responseCode);

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	        String line = "";
	        String result = "";

	        while ((line = br.readLine()) != null) {
	            result += line;
	        }

	        System.out.println("Response Body : " + result);

	        // jackson objectmapper 객체 생성
	        ObjectMapper objectMapper = new ObjectMapper();
	        // JSON String -> Map
	        Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
	        });

	        //사용자 정보 추출
	        //Map<String, Object> properties = (Map<String, Object>) jsonMap.get("properties");
	        Map<String, Object> kakao_account = (Map<String, Object>) jsonMap.get("kakao_account");

//	        Long id       = (Long) jsonMap.get("id");
//	        String name   = kakao_account.get("name").toString();
	        String email  = kakao_account.get("email").toString();
//	        String gender = kakao_account.get("gender").toString();
//	        String phone  = kakao_account.get("phone_number").toString();
	        
	        /*
	        if(properties != null) {
	        	String nickname     = properties.get("nickname").toString();
	        	String profileImage = properties.get("profile_image").toString();  
	        	
	            dto.setNickname(nickname);
	            dto.setProfile_image(profileImage);        	
	        }
	        */

	        //userInfo에 넣기
//	        dto.setId(id);
//	        dto.setName(name);
	        dto.setEmail(email);
//	        dto.setPhone(phone);
	        
	        // 성별
//	        if(gender.equals("male")) {
//	        	dto.setGenderCd(null); // 남
//	        } else {
//	        	dto.setGenderCd(null); // 여
//	        }

	        return dto;
	    }	
		
		// 로그인 id 확인
		public KakaoLoginDto kakaoSelectOne(KakaoLoginDto dto) {
			return dao.kakaoSelectOne(dto);
		};
	
		// 회원등록
		public int kakaoLoginInsert(KakaoLoginDto dto) {
			return dao.kakaoLoginInsert(dto);
		}

		
	}

		


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	 public String getAccessToken(String code) {
//	        // 카카오로부터 받은 인증 코드를 이용하여 액세스 토큰 요청
//	        RestTemplate restTemplate = new RestTemplate();
//	        String tokenUrl = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id={fc5f1385a98519af1cc8656e9fafcbdc}&redirect_uri={https://localhost:8085/oauth/callback/kakao}&code=" + code;
//	        String response = restTemplate.postForObject(tokenUrl, null, String.class);
//	        
//	        // 응답에서 액세스 토큰 추출
//	        // (실제로는 JSON 파싱 등을 통해 값을 추출해야 함)
//	        String accessToken = extractAccessTokenFromResponse(response);
//
//	        return accessToken;
//	    }
//
//	    // 액세스 토큰을 응답에서 추출하는 메서드
//	    private String extractAccessTokenFromResponse(String response) {
//	        // 구현 필요
//	        return null;
//	    }
//}

