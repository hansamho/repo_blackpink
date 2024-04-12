package com.hotelstay.infra.hotel;

import com.hotelstay.common.base.BaseVo;

public class HotelVo extends BaseVo {
	
	private String hotelSeq;
	private String wishlist_seq;
	private Integer hotelTypeCD;
	private Integer areaCD;
	private double roomTotalRating;
	
	
	

	public double getRoomTotalRating() {
		return roomTotalRating;
	}

	public void setRoomTotalRating(double roomTotalRating) {
		this.roomTotalRating = roomTotalRating;
	}

	public Integer getHotelTypeCD() {
		return hotelTypeCD;
	}

	public void setHotelTypeCD(Integer hotelTypeCD) {
		this.hotelTypeCD = hotelTypeCD;
	}

	public String getHotelSeq() {
		return hotelSeq;
	}

	public void setHotelSeq(String hotelSeq) {
		this.hotelSeq = hotelSeq;
	}

	public String getWishlist_seq() {
		return wishlist_seq;
	}

	public void setWishlist_seq(String wishlist_seq) {
		this.wishlist_seq = wishlist_seq;
	}

	public Integer getAreaCD() {
		return areaCD;
	}

	public void setAreaCD(Integer areaCD) {
		this.areaCD = areaCD;
	}

	
	
}
