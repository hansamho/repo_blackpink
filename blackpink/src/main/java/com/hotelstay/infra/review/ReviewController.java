package com.hotelstay.infra.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotelstay.infra.booking.BookingDto;
import com.hotelstay.infra.roomdetail.RoomDetailDto;
import com.hotelstay.infra.roomdetail.RoomDetailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {

	@Autowired
	ReviewService service;
	
	@Autowired
	RoomDetailService detailService;
	
	@RequestMapping(value = "/reviewInset")
	public String reviewInset(ReviewDto dto,RoomDetailDto detailDto,Model model,HttpSession httpSession ) throws Exception{
		dto.setMemberSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		
		System.out.println("dto.getRoomDetail_roomSeq()"+ " " + dto.getRoomDetail_roomSeq());
		
		service.reviewInsert(dto);
		
		model.addAttribute("list", service.selectList(dto));
		
		return "redirect:/roomDetail";  //
		
	}
}
