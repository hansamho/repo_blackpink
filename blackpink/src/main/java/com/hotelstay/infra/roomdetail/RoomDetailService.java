package com.hotelstay.infra.roomdetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomDetailService {
	@Autowired
	RoomDetailDao dao;
	
	public List<RoomDetailDto> selectList(RoomDetailDto dto){
		
		return dao.selectList(dto);
	}
	
	public RoomDetailDto selectOne(RoomDetailDto dto) {
		return dao.selectOne(dto);
	}
	
	
	public RoomDetailDto selectadmin(RoomDetailDto dto) {
		return dao.selectadmin(dto);
	}
	
	public RoomDetailDto selectOneReview(RoomDetailDto dto) {
		return dao.selectOneReview(dto);
	}
	
	public RoomDetailDto reviewCount(RoomDetailDto dto) {
		return dao.reviewCount(dto);
	}
}