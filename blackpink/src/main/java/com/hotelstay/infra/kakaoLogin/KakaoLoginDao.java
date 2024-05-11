package com.hotelstay.infra.kakaoLogin;

public interface KakaoLoginDao {
	
	public KakaoLoginDto kakaoSelectOne(KakaoLoginDto dto);
	
	public int kakaoLoginInsert(KakaoLoginDto dto);
}
