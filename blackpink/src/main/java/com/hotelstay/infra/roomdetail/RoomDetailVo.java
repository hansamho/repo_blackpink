package com.hotelstay.infra.roomdetail;

import com.hotelstay.common.base.BaseVo;

public class RoomDetailVo extends BaseVo {
	private String roomSeq;
	private String hotellist_seq;
	public String getRoomSeq() {
		return roomSeq;
	}
	public void setRoomSeq(String roomSeq) {
		this.roomSeq = roomSeq;
	}
	public String getHotellist_seq() {
		return hotellist_seq;
	}
	public void setHotellist_seq(String hotellist_seq) {
		this.hotellist_seq = hotellist_seq;
	}
	
	
}
