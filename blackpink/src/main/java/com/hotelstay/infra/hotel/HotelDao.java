package com.hotelstay.infra.hotel;

import java.util.List;

import com.hotelstay.infra.roomdetail.RoomDetailDto;


public interface HotelDao {
	
	public List<HotelDto> selectList(HotelVo vo);
	
	public int selectOneCount(HotelVo vo);
	
	public HotelDto selectOne(HotelDto dto);
	
	public int roomInsert(RoomDetailDto dto);
	
}
