package com.hotelstay.infra.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotelstay.infra.code.CodeDto;
import com.hotelstay.infra.member.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {
	@Autowired
	BookingService service;
	
	@RequestMapping(value = "/myPage")
	public String myPage(BookingDto dto,Model model,HttpSession httpSession) throws Exception{
		
		System.out.println(httpSession.getAttribute("sessSeqUsr"));
		
		dto.setMemberSeqF((String)httpSession.getAttribute("sessSeqUsr"));
		model.addAttribute("list", service.selectMy(dto));
		model.addAttribute("item", service.selectOne(dto));
		model.addAttribute("listwish", service.selectWish(dto));
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

		dto.setMemberSeqF((String)httpSession.getAttribute("sessSeqUsr"));
		service.memberUpdate(dto);
	
		return "redirect:/myPage";  //
		
	}
	
}
