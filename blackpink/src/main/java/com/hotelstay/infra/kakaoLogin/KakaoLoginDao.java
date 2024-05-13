package com.hotelstay.infra.kakaoLogin;

public interface KakaoLoginDao {
	
	public KakaoLoginDto kakaoLogin(KakaoLoginDto dto);
	
	public int kakaoLoginInsert(KakaoLoginDto dto);
}
