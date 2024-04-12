package com.hotelstay.infra.roomdetail;

import java.util.Date;

public class RoomDetailDto {
	private String roomSeq;
	private String roomName; 
	private double roomPrice;
	private String roomContent;
	private String roominfo;
	private String roomTypeCD; 
	private Integer tvNy; 
	private Integer wifiNy; 
	private Integer poolNy; 
	private Integer airNy; 
	private Integer bathNy; 
	private Integer bathSuppliesNy; 
	private Date roomRegDate; 
	private Date roomUpdate; 
	private Integer roomDelny; 
	private String hotelList_seq;
	private String roomSeqF;
	
	
	
	/*멤버*/
	private String memberName;
	private String memberSeqF;
	
	/*호텔*/
	private String hotelName;
	
	/*예약*/
	private Date bkCheckin;
	private Date bkCheckout;
	private int bkAdult;
	private int bkChild;
	private double bkTotalPrice;
	
	/*foreign key*/
	private String member_seq;
	private String roomDetail_seq;
	private String roomDetail_roomSeq;
	
	/*객실*/
	public String getRoomSeq() {
		return roomSeq;
	}
	public void setRoomSeq(String roomSeq) {
		this.roomSeq = roomSeq;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRoomContent() {
		return roomContent;
	}
	public void setRoomContent(String roomContent) {
		this.roomContent = roomContent;
	}
	public String getRoominfo() {
		return roominfo;
	}
	public void setRoominfo(String roominfo) {
		this.roominfo = roominfo;
	}
	public String getRoomTypeCD() {
		return roomTypeCD;
	}
	public void setRoomTypeCD(String roomTypeCD) {
		this.roomTypeCD = roomTypeCD;
	}
	public Integer getTvNy() {
		return tvNy;
	}
	public void setTvNy(Integer tvNy) {
		this.tvNy = tvNy;
	}
	public Integer getWifiNy() {
		return wifiNy;
	}
	public void setWifiNy(Integer wifiNy) {
		this.wifiNy = wifiNy;
	}
	public Integer getPoolNy() {
		return poolNy;
	}
	public void setPoolNy(Integer poolNy) {
		this.poolNy = poolNy;
	}
	public Integer getAirNy() {
		return airNy;
	}
	public void setAirNy(Integer airNy) {
		this.airNy = airNy;
	}
	public Integer getBathNy() {
		return bathNy;
	}
	public void setBathNy(Integer bathNy) {
		this.bathNy = bathNy;
	}
	public Integer getBathSuppliesNy() {
		return bathSuppliesNy;
	}
	public void setBathSuppliesNy(Integer bathSuppliesNy) {
		this.bathSuppliesNy = bathSuppliesNy;
	}
	public Date getRoomRegDate() {
		return roomRegDate;
	}
	public void setRoomRegDate(Date roomRegDate) {
		this.roomRegDate = roomRegDate;
	}
	public Date getRoomUpdate() {
		return roomUpdate;
	}
	public void setRoomUpdate(Date roomUpdate) {
		this.roomUpdate = roomUpdate;
	}
	public Integer getRoomDelny() {
		return roomDelny;
	}
	public void setRoomDelny(Integer roomDelny) {
		this.roomDelny = roomDelny;
	}
	public String getHotelList_seq() {
		return hotelList_seq;
	}
	public void setHotelList_seq(String hotelList_seq) {
		this.hotelList_seq = hotelList_seq;
	}
	
	/*멤버*/
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
	public String getMemberSeqF() {
		return memberSeqF;
	}
	public void setMemberSeqF(String memberSeqF) {
		this.memberSeqF = memberSeqF;
	}
	/*예약*/
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
	
	/*foreign key*/
	
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
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getRoomDetail_roomSeq() {
		return roomDetail_roomSeq;
	}
	public void setRoomDetail_roomSeq(String roomDetail_roomSeq) {
		this.roomDetail_roomSeq = roomDetail_roomSeq;
	}
	public String getRoomSeqF() {
		return roomSeqF;
	}
	public void setRoomSeqF(String roomSeqF) {
		this.roomSeqF = roomSeqF;
	}
	
	
	
	
	
}
