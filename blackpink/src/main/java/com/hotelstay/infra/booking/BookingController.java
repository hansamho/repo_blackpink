package com.hotelstay.infra.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotelstay.infra.code.CodeDto;
import com.hotelstay.infra.member.MemberDto;
import com.hotelstay.infra.member.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {
	@Autowired
	BookingService service;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/myPage")
	public String myPage(BookingDto dto,Model model,HttpSession httpSession) throws Exception{
		
		System.out.println(httpSession.getAttribute("sessSeqUsr"));
		
		dto.setMemberSeqF((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("list", service.selectMy(dto));
		model.addAttribute("item", service.selectOne(dto));
		model.addAttribute("wish", service.selectWish(dto));
		return "/usr/infra/index/mypage";
  	}
	
	@RequestMapping(value = "/memberForm")
	public String memberForm(BookingDto dto,Model model,HttpSession httpSession ) throws Exception{

		dto.setMemberSeqF((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("item", service.selectOne(dto));
	
		return "/usr/infra/index/memberForm";   //
	}
	
	@RequestMapping(value = "/memberUpdate")
	public String memberUpdate(BookingDto dto,HttpSession httpSession ) throws Exception{

		dto.setMemberSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		service.memberUpdate(dto);
	
		return "redirect:/myPage";  //
		
	}
	
	@RequestMapping(value = "/booking")
	public String booking(BookingDto dto,HttpSession httpSession ) throws Exception{

	
		return "/usr/infra/index/booking";  //
		
	}
	
	@RequestMapping(value = "/payhotel")
	public String payhotel(BookingDto dto,HttpSession httpSession ) throws Exception{

	
		return "/usr/infra/index/payhotel";  //
		
	}
}
