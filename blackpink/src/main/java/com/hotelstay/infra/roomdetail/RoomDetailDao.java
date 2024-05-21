package com.hotelstay.infra.roomdetail;

import java.util.List;

import com.hotelstay.infra.hotel.HotelDto;
import com.hotelstay.infra.hotel.HotelVo;

public interface RoomDetailDao {
	
	public List<RoomDetailVo> selectList(RoomDetailVo vo);
	
	public RoomDetailDto selectOne(RoomDetailDto dto);
	
	public RoomDetailDto selectadmin(RoomDetailDto dto);
	
	public RoomDetailDto selectOneReview(RoomDetailDto dto);
	
	public int reviewCount(RoomDetailDto dto);
	
	public int roomInsert(RoomDetailDto dto);
	
	public int hotelInsert(HotelDto dto);
	
	public int imageUpload(RoomDetailDto dto);
	
	public int selectOneCount(RoomDetailVo vo);
	
	public List<RoomDetailDto> uploadList(RoomDetailDto dto);
	
	public List<RoomDetailDto> uploadOne(RoomDetailDto dto);
	
	public List<RoomDetailDto> uploadDoble(RoomDetailDto dto);
	
	public List<RoomDetailDto> uploadSingle(RoomDetailDto dto);
	
	public List<RoomDetailDto> uploadTwin(RoomDetailDto dto);
	
	public List<RoomDetailDto> uploadNy(RoomDetailDto dto);
}
