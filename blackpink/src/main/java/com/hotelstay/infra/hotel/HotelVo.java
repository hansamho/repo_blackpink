package com.hotelstay.infra.hotel;

import com.hotelstay.common.base.BaseVo;

public class HotelVo extends BaseVo {
	
	private String hotelSeq;
	private String wishlist_seq;
	

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

	@Override
	public String toString() {
		return "HotelVo [hotelSeq=" + hotelSeq + ", wishlist_seq=" + wishlist_seq + "]";
	}
	
	
}
