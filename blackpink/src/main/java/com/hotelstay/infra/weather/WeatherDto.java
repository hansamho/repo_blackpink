package com.hotelstay.infra.weather;

public class WeatherDto {
	
	private String baseDate;
	private String baseTime;
	private int nx;
	private int ny;
	private String obsrValue;
	
	public String getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}
	public String getBaseTime() {
		return baseTime;
	}
	public void setBaseTime(String baseTime) {
		this.baseTime = baseTime;
	}
	public int getNx() {
		return nx;
	}
	public void setNx(int nx) {
		this.nx = nx;
	}
	public int getNy() {
		return ny;
	}
	public void setNy(int ny) {
		this.ny = ny;
	}
	public String getObsrValue() {
		return obsrValue;
	}
	public void setObsrValue(String obsrValue) {
		this.obsrValue = obsrValue;
	}
	
	
	
}
