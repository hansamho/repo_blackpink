package com.hotelstay.infra.hotel;

import java.util.Date;

public class HotelDto {
	
	private String hotelSeq;
	private String hotelName; 
	private String hotelContent; 
	private double htTotalRating; 
	private double hotelRating; 
	private String hotelTypeCD;
	private String areaCD; 
	private Date htRegDate;
	private Date htUpdate;
	private Integer htDelny; 
	private String  wishlist_seq;
	
	private String roomSeq;
	private int roomPrice;
	private double roomTotalRating;
	
	
	public double getRoomTotalRating() {
		return roomTotalRating;
	}
	public void setRoomTotalRating(double roomTotalRating) {
		this.roomTotalRating = roomTotalRating;
	}
	public String getHotelSeq() {
		return hotelSeq;
	}
	public void setHotelSeq(String hotelSeq) {
		this.hotelSeq = hotelSeq;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelContent() {
		return hotelContent;
	}
	public void setHotelContent(String hotelContent) {
		this.hotelContent = hotelContent;
	}
	public double getHtTotalRating() {
		return htTotalRating;
	}
	public void setHtTotalRating(double htTotalRating) {
		this.htTotalRating = htTotalRating;
	}
	public double getHotelRating() {
		return hotelRating;
	}
	public void setHotelRating(double hotelRating) {
		this.hotelRating = hotelRating;
	}
	public String getHotelTypeCD() {
		return hotelTypeCD;
	}
	public void setHotelTypeCD(String hotelTypeCD) {
		this.hotelTypeCD = hotelTypeCD;
	}
	public String getAreaCD() {
		return areaCD;
	}
	public void setAreaCD(String areaCD) {
		this.areaCD = areaCD;
	}
	public Date getHtRegDate() {
		return htRegDate;
	}
	public void setHtRegDate(Date htRegDate) {
		this.htRegDate = htRegDate;
	}
	public Date getHtUpdate() {
		return htUpdate;
	}
	public void setHtUpdate(Date htUpdate) {
		this.htUpdate = htUpdate;
	}
	public Integer getHtDelny() {
		return htDelny;
	}
	public void setHtDelny(Integer htDelny) {
		this.htDelny = htDelny;
	}
	public String getWishlist_seq() {
		return wishlist_seq;
	}
	public void setWishlist_seq(String wishlist_seq) {
		this.wishlist_seq = wishlist_seq;
	}
	
	/*객실 가격*/
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRoomSeq() {
		return roomSeq;
	}
	public void setRoomSeq(String roomSeq) {
		this.roomSeq = roomSeq;
	}
	
	
	
	
}
