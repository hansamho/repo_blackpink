package com.hotelstay.infra.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelstay.common.base.BaseVo;
import com.hotelstay.infra.member.MemberVo;

@Service
public class HotelService {
	
	@Autowired
	HotelDao dao;
	
	public List<HotelDto> selectList(HotelVo vo){
		return dao.selectList(vo);
	}
	public int selectOneCount(HotelVo vo) {
		return dao.selectOneCount(vo);
	}
	
	public HotelDto selectOne(HotelDto dto) {
		return dao.selectOne(dto);
	}
}
