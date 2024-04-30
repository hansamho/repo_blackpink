package com.hotelstay.infra.booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String booking(@RequestParam("bookingSeq") String booking , BookingDto dto,Model model,HttpSession httpSession ) throws Exception{
		dto.setMemberSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		
		System.out.println("dto.getBookingSeq()"+" "+dto.getBookingSeq());
		
		System.out.println("booking"+" "+booking);
		
		model.addAttribute("item", service.bookingSelectOne(dto));
		
		return "/usr/infra/index/booking";  //
		
	}
	
	@RequestMapping(value = "/bookinginfo")
	public String bookinginfo(BookingDto dto,Model model,HttpSession httpSession ) throws Exception{
		dto.setMemberSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		
		
//		model.addAttribute("item", service.bookingSelectOne(dto));
		
		return "/usr/infra/index/bookinginfo";  //
		
	}
	
	@RequestMapping(value = "/bookingInsert")
	public String bookingInsert(BookingDto dto,Model model,HttpSession httpSession,RedirectAttributes redirectAttributes  ) throws Exception{
		
		dto.setMemberSeqF((String) httpSession.getAttribute("sessSeqUsr"));
		
		service.bookingInsert(dto);
		
		redirectAttributes.addAttribute("bookingSeq", dto.getBookingSeq());
		
		return "redirect:/booking";  //
		
	}
	
//	@RequestMapping(value = "/payInsert")
//	public String payInsert(BookingDto dto,Model model,HttpSession httpSession,RedirectAttributes redirectAttributes  ) throws Exception{
//		
//		dto.setMemberSeqF((String) httpSession.getAttribute("sessSeqUsr"));
//		
//		service.payInsert(dto);
//		
//		
//		return "redirect:/bookingInfo";  //
//		
//	}
	
}
