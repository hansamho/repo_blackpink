package com.hotelstay.infra.Hotel;

import java.util.List;

import com.hotelstay.common.base.BaseVo;

public interface HotelDao {
	
	public List<HotelDto> selectList(BaseVo vo);
}
