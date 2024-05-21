package com.hotelstay.infra.codegroup;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.hotelstay.common.base.BaseDto;

public class CodeGroupDto extends BaseDto {
	private String cgSeq;
	private String name;
	private Date cgRegDate;
	private Date cgUpdate;
	private Integer cgDelny;
	private String pseq;
	
	//파일 업로드 컬럼
//	private String seq; 
//	private int type; 
//	private Integer defaultNy; 
//	private Integer sort; 
//	private String path; 
//	private String originalName; 
//	private String uuidName; 
//	private String ext; 
//	private long size; 
//	private Integer delNy; 
//	private String pseq; 
//	private Date regDateTime;
	
	//파일 업로드
	private MultipartFile uploadFile;
	private MultipartFile[] uploadFiles;
	
	
//	public String getSeq() {
//		return seq;
//	}
//	public void setSeq(String seq) {
//		this.seq = seq;
//	}
//	public int getType() {
//		return type;
//	}
//	public void setType(int type) {
//		this.type = type;
//	}
//	public Integer getDefaultNy() {
//		return defaultNy;
//	}
//	public void setDefaultNy(Integer defaultNy) {
//		this.defaultNy = defaultNy;
//	}
//	public Integer getSort() {
//		return sort;
//	}
//	public void setSort(Integer sort) {
//		this.sort = sort;
//	}
//	public String getPath() {
//		return path;
//	}
//	public void setPath(String path) {
//		this.path = path;
//	}
//	public String getOriginalName() {
//		return originalName;
//	}
//	public void setOriginalName(String originalName) {
//		this.originalName = originalName;
//	}
//	public String getUuidName() {
//		return uuidName;
//	}
//	public void setUuidName(String uuidName) {
//		this.uuidName = uuidName;
//	}
//	public String getExt() {
//		return ext;
//	}
//	public void setExt(String ext) {
//		this.ext = ext;
//	}
//	
//	public long getSize() {
//		return size;
//	}
//	public void setSize(long size) {
//		this.size = size;
//	}
//	public Integer getDelNy() {
//		return delNy;
//	}
//	public void setDelNy(Integer delNy) {
//		this.delNy = delNy;
//	}
//	public String getPseq() {
//		return pseq;
//	}
//	public void setPseq(String pseq) {
//		this.pseq = pseq;
//	}
//	public Date getRegDateTime() {
//		return regDateTime;
//	}
//	public void setRegDateTime(Date regDateTime) {
//		this.regDateTime = regDateTime;
//	}
	
	
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public String getPseq() {
		return pseq;
	}
	public void setPseq(String pseq) {
		this.pseq = pseq;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
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
