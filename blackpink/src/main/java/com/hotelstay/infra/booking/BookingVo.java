package com.hotelstay.infra.booking;

import com.hotelstay.common.base.BaseVo;

public class BookingVo extends BaseVo {
	
	private String bookingSeq;
	private String member_seq;
	private String roomDetail;
	public String getBookingSeq() {
		return bookingSeq;
	}
	public void setBookingSeq(String bookingSeq) {
		this.bookingSeq = bookingSeq;
	}
	public String getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}
	public String getRoomDetail() {
		return roomDetail;
	}
	public void setRoomDetail(String roomDetail) {
		this.roomDetail = roomDetail;
	}
	
	
	
}
