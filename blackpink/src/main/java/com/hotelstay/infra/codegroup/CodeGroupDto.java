package com.hotelstay.infra.codegroup;

import java.util.Date;

public class CodeGroupDto {
	private String cgSeq;
	private String name;
	private Date cgRegDate;
	private Date cgUpdate;
	private Integer cgDelny;
	public String getCgSeq() {
		return cgSeq;
	}
	public void setCgSeq(String cgSeq) {
		this.cgSeq = cgSeq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCgRegDate() {
		return cgRegDate;
	}
	public void setCgRegDate(Date cgRegDate) {
		this.cgRegDate = cgRegDate;
	}
	public Date getCgUpdate() {
		return cgUpdate;
	}
	public void setCgUpdate(Date cgUpdate) {
		this.cgUpdate = cgUpdate;
	}
	public Integer getCgDelny() {
		return cgDelny;
	}
	public void setCgDelny(Integer cgDelny) {
		this.cgDelny = cgDelny;
	}
	
	
	
	
}
