package com.hotelstay.infra.codegroup;

import java.util.Date;

public class CodeGroupDto {
	private String seq;
	private String name;
	private Date cgCreate;
	private Date cgUpdate;
	private Integer cgDelete;
	
	private Integer xifcdSeqCount;
	
	
	
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
	public Date getCgCreate() {
		return cgCreate;
	}
	public void setCgCreate(Date cgCreate) {
		this.cgCreate = cgCreate;
	}
	public Date getCgUpdate() {
		return cgUpdate;
	}
	public void setCgUpdate(Date cgUpdate) {
		this.cgUpdate = cgUpdate;
	}
	public Integer getCgDelete() {
		return cgDelete;
	}
	public void setCgDelete(Integer cgDelete) {
		this.cgDelete = cgDelete;
	}
	public Integer getXifcdSeqCount() {
		return xifcdSeqCount;
	}
	public void setXifcdSeqCount(Integer xifcdSeqCount) {
		this.xifcdSeqCount = xifcdSeqCount;
	}
	
	
	
}
