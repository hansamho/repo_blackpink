package com.hotelstay.infra.wishlist;

import java.util.Date;

public class WishListDto {
	private Date wishRegDate; 
	private Date wishlUpdate;
	private Integer wishDelny; 
	private String member_seq;
	
	
	
	
	public Date getWishRegDate() {
		return wishRegDate;
	}
	public void setWishRegDate(Date wishRegDate) {
		this.wishRegDate = wishRegDate;
	}
	public Date getWishlUpdate() {
		return wishlUpdate;
	}
	public void setWishlUpdate(Date wishlUpdate) {
		this.wishlUpdate = wishlUpdate;
	}
	public Integer getWishDelny() {
		return wishDelny;
	}
	public void setWishDelny(Integer wishDelny) {
		this.wishDelny = wishDelny;
	}
	public String getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}
	
	
	
	
}
