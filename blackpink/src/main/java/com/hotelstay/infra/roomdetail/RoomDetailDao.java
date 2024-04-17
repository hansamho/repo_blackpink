package com.hotelstay.infra.roomdetail;

import java.util.List;

public interface RoomDetailDao {
	
	public List<RoomDetailDto> selectList(RoomDetailDto dto);
	
	public RoomDetailDto selectOne(RoomDetailDto dto);
	
	public RoomDetailDto selectadmin(RoomDetailDto dto);
	
	public RoomDetailDto selectOneReview(RoomDetailDto dto);
	
	public RoomDetailDto reviewCount(RoomDetailDto dto);
}
