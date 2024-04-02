package com.hotelstay.infra.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelstay.common.base.BaseVo;

@Service
public class HotelService {
	
	@Autowired
	HotelDao dao;
	
	public List<HotelDto> selectList(HotelVo vo){
		return dao.selectList(vo);
		}
}
