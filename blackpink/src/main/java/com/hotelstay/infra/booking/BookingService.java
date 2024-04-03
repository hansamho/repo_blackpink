package com.hotelstay.infra.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookingService {
	@Autowired
	BookingDao dao;
	
	public List<BookingDto> selectMy(BookingDto dto ){
		return dao.selectMy(dto);
	}
	
	public List<BookingDto> selectUsr(BookingDto dto){
		return dao.selectUsr(dto);
	}
}
