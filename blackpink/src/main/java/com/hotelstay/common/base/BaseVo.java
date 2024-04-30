package com.hotelstay.common.base;

import java.util.Date;

import com.hotelstay.common.contents.Constants;

public class BaseVo {
	
	// search
	private Integer shUseNy ; 									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shDelny = 0 ; 								/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private Integer shOptionDate = 1;							/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String shDateStart;
	private String shDateEnd;
	private Integer shOption;									/* null 값을 받아야 되는 경우가 있어서 int 대신 Integer 사용 */
	private String ShValue;
	
	// 체크인,체크아웃
	private String shCheckIn;
	private String shCheckOut;
	
	//체크박스 
	private String[] shCheckboxHotelTypeArray ; // 호텔 유형
	private String[] shCheckboxAreaArray ;      // 지역
	private String[] shCheckboxRoomArray ;      // 객실 내 시설
	
	
	// 공통코드
		private String shGenderCD;
		private String shAreaCD;
		private String shRoomTypeCD;
		private String shPayTypeCD;
		
		
	
	public String[] getShCheckboxHotelTypeArray() {
		return shCheckboxHotelTypeArray;
	}

	public void setShCheckboxHotelTypeArray(String[] shCheckboxHotelTypeArray) {
		this.shCheckboxHotelTypeArray = shCheckboxHotelTypeArray;
	}

	public String[] getShCheckboxAreaArray() {
		return shCheckboxAreaArray;
	}

	public void setShCheckboxAreaArray(String[] shCheckboxAreaArray) {
		this.shCheckboxAreaArray = shCheckboxAreaArray;
	}

	public String[] getShCheckboxRoomArray() {
		return shCheckboxRoomArray;
	}

	public void setShCheckboxRoomArray(String[] shCheckboxRoomArray) {
		this.shCheckboxRoomArray = shCheckboxRoomArray;
	}

	public String getShRoomTypeCD() {
		return shRoomTypeCD;
	}

	public void setShRoomTypeCD(String shRoomTypeCD) {
		this.shRoomTypeCD = shRoomTypeCD;
	}
	
	public String getShPayTypeCD() {
		return shPayTypeCD;
	}

	public void setShPayTypeCD(String shPayTypeCD) {
		this.shPayTypeCD = shPayTypeCD;
	}




	//paging
	private int thisPage = 1;				// 현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;		// 화면에 보여줄 데이터 줄 갯수
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW; 	// 화면에 보여줄 페이징 번호 갯수

	private int totalRows;					// 전체 데이터 갯수
	private int totalPages;				//전체 페이지 번호
	private int startPage;					// 시작 페이지 번호
	private int endPage;					// 마지막 페이지 번호
	
	private int startRnumForOracle = 1;		// 쿼리 시작 row
	private int endRnumForOracle;			// 쿼리 끝 row
	private Integer RNUM;
	
	private int startRnumForMysql = 0;		// 쿼리 시작 row

	
	
	public Integer getShUseNy() {
		return shUseNy;
	}

	public void setShUseNy(Integer shUseNy) {
		this.shUseNy = shUseNy;
	}

	public Integer getShDelny() {
		return shDelny;
	}

	public void setShDelny(Integer shDelny) {
		this.shDelny = shDelny;
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

	
	public String getShGenderCD() {
		return shGenderCD;
	}

	public void setShGenderCD(String shGenderCD) {
		this.shGenderCD = shGenderCD;
	}
	
	

	public String getSgRoomTypeCD() {
		return shRoomTypeCD;
	}

	public void setSgRoomTypeCD(String sgRoomTypeCD) {
		this.shRoomTypeCD = sgRoomTypeCD;
	}

	public int getThisPage() {
		return thisPage;
	}

	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	public int getRowNumToShow() {
		return rowNumToShow;
	}

	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	public int getPageNumToShow() {
		return pageNumToShow;
	}

	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRnumForOracle() {
		return startRnumForOracle;
	}

	public void setStartRnumForOracle(int startRnumForOracle) {
		this.startRnumForOracle = startRnumForOracle;
	}

	public int getEndRnumForOracle() {
		return endRnumForOracle;
	}

	public void setEndRnumForOracle(int endRnumForOracle) {
		this.endRnumForOracle = endRnumForOracle;
	}

	public Integer getRNUM() {
		return RNUM;
	}

	public void setRNUM(Integer rNUM) {
		RNUM = rNUM;
	}

	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}

	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}
	
	
	public String getShAreaCD() {
		return shAreaCD;
	}

	public void setShAreaCD(String shAreaCD) {
		this.shAreaCD = shAreaCD;
	}
	
	
	

	
	
	public String getShCheckIn() {
		return shCheckIn;
	}

	public void setShCheckIn(String shCheckIn) {
		this.shCheckIn = shCheckIn;
	}

	public String getShCheckOut() {
		return shCheckOut;
	}

	public void setShCheckOut(String shCheckOut) {
		this.shCheckOut = shCheckOut;
	}

	



	public void setParamsPaging(int totalRows) {
		
//		setThisPage(3);

		setTotalRows(totalRows);

		if (getTotalRows() == 0) {
			setTotalPages(1);
		} else {
			setTotalPages(getTotalRows() / getRowNumToShow());
		}
		
		if (getTotalRows() % getRowNumToShow() > 0) {
			setTotalPages(getTotalPages() + 1);
		}

		if (getTotalPages() < getThisPage()) {
			setThisPage(getTotalPages());
		}
		
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

		setEndPage(getStartPage() + getPageNumToShow() - 1);
		
		if (getEndPage() > getTotalPages()) {
			setEndPage(getTotalPages());
		}
		
		setEndRnumForOracle((getRowNumToShow() * getThisPage()));
		setStartRnumForOracle((getEndRnumForOracle() - getRowNumToShow()) + 1);
		if (getStartRnumForOracle() < 1) setStartRnumForOracle(1);
		
		if (thisPage == 1) {
			setStartRnumForMysql(0);
		} else {
			setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1)));
		}
		
//		System.out.println("getThisPage():" + getThisPage());
//		System.out.println("getTotalRows():" + getTotalRows());
//		System.out.println("getRowNumToShow():" + getRowNumToShow());
//		System.out.println("getTotalPages():" + getTotalPages());
//		System.out.println("getStartPage():" + getStartPage());
//		System.out.println("getEndPage():" + getEndPage());		
//		System.out.println("getStartRnumForOracle():" + getStartRnumForOracle());
//		System.out.println("getEndRnumForOracle():" + getEndRnumForOracle());
//		System.out.println("getStartRnumForMysql(): " + getStartRnumForMysql());
		
	}
	
	
	
}
