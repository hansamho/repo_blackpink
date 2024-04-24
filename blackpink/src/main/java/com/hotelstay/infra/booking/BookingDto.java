package com.hotelstay.infra.booking;

import java.util.Date;

public class BookingDto {
	private String bookingSeq;
	private String bkCheckIn; 
	private String bkCheckOut; 
	private int bkAdult; 
	private int bkChild;
	private int bkTotalPrice; 
	private String payType; 
	private String cardNumber; 
	private String cardDate; 
	private String cardYear; 
	private String cardCcv; 
	private Date bkRegDate; 
	private Date bkUpdate; 
	private Integer bkDelny; 
	private String memberSeqF; 
	private String roomDetail_roomSeq;
	private String roomSeqF;
	private String member_seq;
	
	/*멤버*/
	private String memberSeq;
	private String memberName;
	private String memberID;
	private String memberPhone;
	private String birthday;
	private String codeNumber;
	private String roadName;
	private String addrDetail;
	
	
	/*객실정보*/
	private String roomName;
	private String roomTypeCD;
	private String roomPrice;
	private String roomRating;
	private Date roomRegDate;
	private String roomSeq;
	private String singleRoomPrice;
	private String doubleRoomPrice;
	private String twinRoomPrice;
	
	
	
	
	public void setBkCheckIn(String bkCheckIn) {
		this.bkCheckIn = bkCheckIn;
	}
	public void setBkCheckOut(String bkCheckOut) {
		this.bkCheckOut = bkCheckOut;
	}
	public String getRoomSeqF() {
		return roomSeqF;
	}
	public void setRoomSeqF(String roomSeqF) {
		this.roomSeqF = roomSeqF;
	}
	public String getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(String member_seq) {
		this.member_seq = member_seq;
	}
	public String getSingleRoomPrice() {
		return singleRoomPrice;
	}
	public void setSingleRoomPrice(String singleRoomPrice) {
		this.singleRoomPrice = singleRoomPrice;
	}
	public String getDoubleRoomPrice() {
		return doubleRoomPrice;
	}
	public void setDoubleRoomPrice(String doubleRoomPrice) {
		this.doubleRoomPrice = doubleRoomPrice;
	}
	public String getTwinRoomPrice() {
		return twinRoomPrice;
	}
	public void setTwinRoomPrice(String twinRoomPrice) {
		this.twinRoomPrice = twinRoomPrice;
	}
	public String getRoomDetail_roomSeq() {
		return roomDetail_roomSeq;
	}
	public void setRoomDetail_roomSeq(String roomDetail_roomSeq) {
		this.roomDetail_roomSeq = roomDetail_roomSeq;
	}
	public String getRoomSeq() {
		return roomSeq;
	}
	public void setRoomSeq(String roomSeq) {
		this.roomSeq = roomSeq;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	public String getCodeNumber() {
		return codeNumber;
	}
	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}

	
	public Date getRoomRegDate() {
		return roomRegDate;
	}
	public void setRoomRegDate(Date roomRegDate) {
		this.roomRegDate = roomRegDate;
	}
	public String getRoomRating() {
		return roomRating;
	}
	public void setRoomRating(String roomRating) {
		this.roomRating = roomRating;
	}
	public String getBookingSeq() {
		return bookingSeq;
	}
	public void setBookingSeq(String bookingSeq) {
		this.bookingSeq = bookingSeq;
	}
	public String getBkCheckIn() {
		return bkCheckIn;
	}
	public void setBkCheckin(String bkCheckIn) {
		this.bkCheckIn = bkCheckIn;
	}
	public String getBkCheckOut() {
		return bkCheckOut;
	}
	public void setBkCheckout(String bkCheckOut) {
		this.bkCheckOut = bkCheckOut;
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
	public int getBkTotalPrice() {
		return bkTotalPrice;
	}
	public void setBkTotalPrice(int bkTotalPrice) {
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
	public String getMemberSeqF() {
		return memberSeqF;
	}
	public void setMemberSeqF(String memberSeqF) {
		this.memberSeqF = memberSeqF;
	}
	public String getRoomDetail_seq() {
		return roomDetail_roomSeq;
	}
	public void setRoomDetail_seq(String roomDetail_roomSeq) {
		this.roomDetail_roomSeq = roomDetail_roomSeq;
	}
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
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
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	
	
	}





