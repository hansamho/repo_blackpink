package com.hotelstay.infra.roomdetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomDetailService {
	@Autowired
	RoomDetailDao dao;
	
	public List<RoomDetailDto> selectList(RoomDetailVo vo){
		
		return dao.selectList(vo);
	}
	
	public RoomDetailDto selectadmin(RoomDetailDto dto) {
		return dao.selectadmin(dto);
	}
	
	
}