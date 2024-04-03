package com.hotelstay.infra.booking;

import com.hotelstay.common.base.BaseVo;

public class BookingVo extends BaseVo {
	
	private String bookingSeq;
	private String memberSeqF;
	private String roomDetail;
	public String getBookingSeq() {
		return bookingSeq;
	}
	public void setBookingSeq(String bookingSeq) {
		this.bookingSeq = bookingSeq;
	}
	public String getMemberSeqF() {
		return memberSeqF;
	}
	public void setMemberSeqF(String memberSeqF) {
		this.memberSeqF = memberSeqF;
	}
	public String getRoomDetail() {
		return roomDetail;
	}
	public void setRoomDetail(String roomDetail) {
		this.roomDetail = roomDetail;
	}

	
	
	
}
