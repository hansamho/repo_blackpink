package com.hotelstay.infra.hotel;

import java.util.List;


public interface HotelDao {
	
	public List<HotelDto> selectList(HotelVo vo);
	
	public int selectOneCount(HotelVo vo);
	
	public HotelDto selectOne(HotelDto dto);
}
