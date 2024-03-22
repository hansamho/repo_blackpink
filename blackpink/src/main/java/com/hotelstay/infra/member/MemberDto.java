package com.hotelstay.infra.member;

import java.util.Date;

public class MemberDto {
	
	private String memberSeq;
	private String fristName;
	private String lastName;
	private String birthday;
	private String memberID;
	private String memberPassword;
	private String memberPhone;
	private String codeNumber;
	private String roadName;
	private String addrDetail;
	private Integer genderCD;
	private Date mbRegDate;
	private Date mbUpdate;
	private Integer mbDelny;
	
	
	
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
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
	public Integer getGenderCD() {
		return genderCD;
	}
	public void setGenderCD(Integer genderCD) {
		this.genderCD = genderCD;
	}
	public Date getMbRegDate() {
		return mbRegDate;
	}
	public void setMbRegDate(Date mbRegDate) {
		this.mbRegDate = mbRegDate;
	}
	public Date getMbUpdate() {
		return mbUpdate;
	}
	public void setMbUpdate(Date mbUpdate) {
		this.mbUpdate = mbUpdate;
	}
	public Integer getMbDelny() {
		return mbDelny;
	}
	public void setMbDelny(Integer mbDelny) {
		this.mbDelny = mbDelny;
	}
	
}
