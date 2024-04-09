package com.hotelstay.infra.booking;

import java.util.List;


public interface BookingDao {
	
	public List<BookingDto> selectMy(BookingDto dto);
	
	public BookingDto selectOne(BookingDto dto);
	
	public BookingDto selectWish(BookingDto dto);
	
	public List<BookingDto> selectUsr(BookingDto dto);
	
	public int memberUpdate(BookingDto dto);
}
