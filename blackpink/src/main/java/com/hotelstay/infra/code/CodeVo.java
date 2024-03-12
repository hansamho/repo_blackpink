package com.hotelstay.infra.code;

public class CodeVo {
	private Integer shUseNy ; 									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shcodeDelete ; 								/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOptionDate ;							/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shDateStart;
	private String shDateEnd;
	private Integer shOption;									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String ShValue;
	
	private String Seq;
	private String code_seq;
	
	
	
	public Integer getShUseNy() {
		return shUseNy;
	}
	public void setShUseNy(Integer shUseNy) {
		this.shUseNy = shUseNy;
	}
	public Integer getShcodeDelete() {
		return shcodeDelete;
	}
	public void setShcodeDelete(Integer shcodeDelete) {
		this.shcodeDelete = shcodeDelete;
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
	public String getSeq() {
		return Seq;
	}
	public void setSeq(String seq) {
		Seq = seq;
	}
	public String getCode_seq() {
		return code_seq;
	}
	public void setCode_seq(String code_seq) {
		this.code_seq = code_seq;
	}

	

}
