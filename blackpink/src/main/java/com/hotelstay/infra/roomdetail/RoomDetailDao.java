package com.hotelstay.infra.roomdetail;

import java.util.List;

public interface RoomDetailDao {
	public List<RoomDetailDto> selectList(RoomDetailVo vo);
}
