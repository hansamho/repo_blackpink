package com.hotelstay.infra.hotel;

import com.hotelstay.common.base.BaseVo;

public class HotelVo extends BaseVo {
	
	private String hotelSeq;
	private String wishlist_seq;
	private Integer hotelTypeCD;
	private Integer areaCD;
	private double roomTotalRating;
	private int hotelRating;
	
	//체크박스 
	private String[] shCheckboxHotelTypeArray = null; // 호텔 유형
	private String[] shCheckboxAreaArray = null;      // 지역
	private String[] shCheckboxRoomArray = null;      // 객실 내 시설
	
	
	
	

	public String[] getShCheckboxHotelTypeArray() {
		return shCheckboxHotelTypeArray;
	}

	public void setShCheckboxHotelTypeArray(String[] shCheckboxHotelTypeArray) {
		this.shCheckboxHotelTypeArray = shCheckboxHotelTypeArray;
	}

	public String[] getShCheckboxAreaArray() {
		return shCheckboxAreaArray;
	}

	public void setShCheckboxAreaArray(String[] shCheckboxAreaArray) {
		this.shCheckboxAreaArray = shCheckboxAreaArray;
	}

	public String[] getShCheckboxRoomArray() {
		return shCheckboxRoomArray;
	}

	public void setShCheckboxRoomArray(String[] shCheckboxRoomArray) {
		this.shCheckboxRoomArray = shCheckboxRoomArray;
	}

	public int getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(int hotelRating) {
		this.hotelRating = hotelRating;
	}

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
