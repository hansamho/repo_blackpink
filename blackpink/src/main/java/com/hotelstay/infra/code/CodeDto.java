package com.hotelstay.infra.code;

import java.sql.Date;

public class CodeDto {              

	private String seq;
	private String name;
	private Date codeCreate;
	private Date codeUpdate;
	private Integer codeDelete;
	
	
	private String code_seq; //그룹코드seq
	private String codegroup_name; //그룹코드name
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() { 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCodeCreate() {
		return codeCreate;
	}
	public void setCodeCreate(Date codeCreate) {
		this.codeCreate = codeCreate;
	}
	public Date getCodeUpdate() {
		return codeUpdate;
	}
	public void setCodeUpdate(Date codeUpdate) {
		this.codeUpdate = codeUpdate;
	}
	public Integer getCodeDelete() {
		return codeDelete;
	}
	public void setCodeDelete(Integer codeDelete) {
		this.codeDelete = codeDelete;
	}
	public String getCode_seq() {
		return code_seq;
	}
	public void setCode_seq(String code_seq) {
		this.code_seq = code_seq;
	}
	public String getCodegroup_name() {
		return codegroup_name;
	}
	public void setCodegroup_name(String codegroup_name) {
		this.codegroup_name = codegroup_name;
	}
	
	
	
	
	
	
	
	
}
