package com.hotelstay.infra.code;

import com.hotelstay.common.base.BaseVo;

public class CodeVo extends BaseVo{
	
	private String Seq;
	private String code_seq;
	private String cdSeq;
	
	
	
	public String getCdSeq() {
		return cdSeq;
	}
	public void setCdSeq(String cdSeq) {
		this.cdSeq = cdSeq;
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
