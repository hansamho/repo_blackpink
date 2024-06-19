package com.hotelstay.infra.code;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CodeDto {              
	
	private String cdSeq;
	private String name;
	private Date cdRegDate;
	private Date cdUpdate;
	private Integer cdDelny;
	
	private String codeGroup_seq;
	private String codeGroup_name;
	
	private String[] checkboxSeqArray  = null;
	
//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	
	
	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	
	public String getCdSeq() {
		return cdSeq;
	}
	public void setCdSeq(String cdSeq) {
		this.cdSeq = cdSeq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCdRegDate() {
		return cdRegDate;
	}
	public void setCdRegDate(Date cdRegDate) {
		this.cdRegDate = cdRegDate;
	}
	public Date getCdUpdate() {
		return cdUpdate;
	}
	public void setCdUpdate(Date cdUpdate) {
		this.cdUpdate = cdUpdate;
	}
	public Integer getCdDelny() {
		return cdDelny;
	}
	public void setCdDelny(Integer cdDelny) {
		this.cdDelny = cdDelny;
	}
	public String getCodeGroup_seq() {
		return codeGroup_seq;
	}
	public void setCodeGroup_seq(String codeGroup_seq) {
		this.codeGroup_seq = codeGroup_seq;
	}
	public String getCodeGroup_name() {
		return codeGroup_name;
	}
	public void setCodeGroup_name(String codeGroup_name) {
		this.codeGroup_name = codeGroup_name;
	}
	public String[] getCheckboxSeqArray() {
		return checkboxSeqArray;
	}
	public void setCheckboxSeqArray(String[] checkboxSeqArray) {
		this.checkboxSeqArray = checkboxSeqArray;
	}
	
}



