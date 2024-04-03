package com.hotelstay.infra.booking;

import java.util.Date;

public class BookingDto {
	private String bookingSeq;
	private Date bkCheckin; 
	private Date bkCheckout; 
	private int bkAdult; 
	private int bkChild;
	private double bkTotalPrice; 
	private String payType; 
	private String cardNumber; 
	private String cardDate; 
	private String cardYear; 
	private String cardCcv; 
	private Date bkRegDate; 
	private Date bkUpdate; 
	private Integer bkDelny; 
	private String member_seq; 
	private String roomDetail_seq;
	
	/*멤버*/
	private String memberSeq;
	private String memberName;
	
	/*객실정보*/
	private String roomName;
	private String roomTypeCD;
	private String roomPrice;
	
	
	public String getBookingSeq() {
		return bookingSeq;
	}
	public void setBookingSeq(String bookingSeq) {
		this.bookingSeq = bookingSeq;
	}
	public Date getBkCheckin() {
		return bkCheckin;
	}
	public void setBkCheckin(Date bkCheckin) {
		this.bkCheckin = bkCheckin;
	}
	public Date getBkCheckout() {
		return bkCheckout;
	}
	public void setBkCheckout(Date bkCheckout) {
		this.bkCheckout = bkCheckout;
	}
	public int getBkAdult() {
		return bkAdult;
	}
	public void setBkAdult(int bkAdult) {
		this.bkAdult = bkAdult;
	}
	public int getBkChild() {
		return bkChild;
	}
	public void setBkChild(int bkChild) {
		this.bkChild = bkChild;
	}
	public double getBkTotalPrice() {
		return bkTotalPrice;
	}
	public void setBkTotalPrice(double bkTotalPrice) {
		this.bkTotalPrice = bkTotalPrice;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardDate() {
		return cardDate;
	}
	public void setCardDate(String cardDate) {
		this.cardDate = cardDate;
	}
	public String getCardYear() {
		return cardYear;
	}
	public void setCardYear(String cardYear) {
		this.cardYear = cardYear;
	}
	public String getCardCcv() {
		return cardCcv;
	}
	public void setCardCcv(String cardCcv) {
		this.cardCcv = cardCcv;
	}
	public Date getBkRegDate() {
		return bkRegDate;
	}
	public void setBkRegDate(Date bkRegDate) {
		this.bkRegDate = bkRegDate;
	}
	public Date getBkUpdate() {
		return bkUpdate;
	}
	public void setBkUpdate(Date bkUpdate) {
		this.bkUpdate = bkUpdate;
	}
	public Integer getBkDelny() {
		return bkDelny;
	}
	public void setBkDelny(Integer bkDelny) {
		this.bkDelny = bkDelny;
	}
	public String getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}
	public String getRoomDetail_seq() {
		return roomDetail_seq;
	}
	public void setRoomDetail_seq(String roomDetail_seq) {
		this.roomDetail_seq = roomDetail_seq;
	}
	
	/*멤버*/
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	
	
	/*객실정보*/
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomTypeCD() {
		return roomTypeCD;
	}
	public void setRoomTypeCD(String roomTypeCD) {
		this.roomTypeCD = roomTypeCD;
	}
	public String getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	


}





