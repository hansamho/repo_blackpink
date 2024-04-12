package com.hotelstay.infra.review;

import java.util.Date;

public class ReviewDto {
	private String reviewSeq;
	private double totalRating; 
	private int cleanRating; 
	private int comfortRating; 
	private int priceRating; 
	private int qualityRating;
	private String reviewContent; 
	private Date reRegDate; 
	private Date reUpdate; 
	private Integer reDelny;
	private String roomDetail_roomSeq;
	private String memberSeqF;
	private String roomSeq;
	private String roomSeqF;
	
	// 멤버 
	private String memberName;
	private String memberID;
	private String roomTypeCD;
	private String memberNickName;
	
	
	
	

	public String getRoomSeqF() {
		return roomSeqF;
	}
	public void setRoomSeqF(String roomSeqF) {
		this.roomSeqF = roomSeqF;
	}
	public String getRoomSeq() {
		return roomSeq;
	}
	public void setRoomSeq(String roomSeq) {
		this.roomSeq = roomSeq;
	}
	public String getMemberNickName() {
		return memberNickName;
	}
	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}
	public String getReviewSeq() {
		return reviewSeq;
	}
	public void setReviewSeq(String reviewSeq) {
		this.reviewSeq = reviewSeq;
	}
	public double getTotalRating() {
		return totalRating;
	}
	public void setTotalRating(double totalRating) {
		this.totalRating = totalRating;
	}
	public int getCleanRating() {
		return cleanRating;
	}
	public void setCleanRating(int cleanRating) {
		this.cleanRating = cleanRating;
	}
	public int getComfortRating() {
		return comfortRating;
	}
	public void setComfortRating(int comfortRating) {
		this.comfortRating = comfortRating;
	}
	public int getPriceRating() {
		return priceRating;
	}
	public void setPriceRating(int priceRating) {
		this.priceRating = priceRating;
	}
	public int getQualityRating() {
		return qualityRating;
	}
	public void setQualityRating(int qualityRating) {
		this.qualityRating = qualityRating;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReRegDate() {
		return reRegDate;
	}
	public void setReRegDate(Date reRegDate) {
		this.reRegDate = reRegDate;
	}
	public Date getReUpdate() {
		return reUpdate;
	}
	public void setReUpdate(Date reUpdate) {
		this.reUpdate = reUpdate;
	}
	public Integer getReDelny() {
		return reDelny;
	}
	public void setReDelny(Integer reDelny) {
		this.reDelny = reDelny;
	}
	public String getRoomDetail_roomSeq() {
		return roomDetail_roomSeq;
	}
	public void setRoomDetail_roomSeq(String roomDetail_roomSeq) {
		this.roomDetail_roomSeq = roomDetail_roomSeq;
	}
	public String getMemberSeqF() {
		return memberSeqF;
	}
	public void setMemberSeqF(String memberSeqF) {
		this.memberSeqF = memberSeqF;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getRoomTypeCD() {
		return roomTypeCD;
	}
	public void setRoomTypeCD(String roomTypeCD) {
		this.roomTypeCD = roomTypeCD;
	}
	
	
	
	
	
	
}
