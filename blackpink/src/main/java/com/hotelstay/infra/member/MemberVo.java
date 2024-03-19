package com.hotelstay.infra.member;

public class MemberVo {
	private Integer shUseNy ; 									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shcdDelny ; 								/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOptionDate ;							/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shDateStart;
	private String shDateEnd;
	private Integer shOption;									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String ShValue;
	
	private String memberSeq;

	public Integer getShUseNy() {
		return shUseNy;
	}

	public void setShUseNy(Integer shUseNy) {
		this.shUseNy = shUseNy;
	}

	public Integer getShcdDelny() {
		return shcdDelny;
	}

	public void setShcdDelny(Integer shcdDelny) {
		this.shcdDelny = shcdDelny;
	}

	public Integer getShOptionDate() {
		return shOptionDate;
	}

	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
	}

	public String getShDateStart() {
		return shDateStart;
	}

	public void setShDateStart(String shDateStart) {
		this.shDateStart = shDateStart;
	}

	public String getShDateEnd() {
		return shDateEnd;
	}

	public void setShDateEnd(String shDateEnd) {
		this.shDateEnd = shDateEnd;
	}

	public Integer getShOption() {
		return shOption;
	}

	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}

	public String getShValue() {
		return ShValue;
	}

	public void setShValue(String shValue) {
		ShValue = shValue;
	}

	public String getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	
	
}
