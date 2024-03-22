package com.hotelstay.infra.Hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelstay.common.base.BaseVo;

@Service
public class HotelService {
	
	@Autowired
	HotelDao dao;
	
	public List<HotelDto> selectList(BaseVo vo){
		return dao.selectList(vo);
		}
}
