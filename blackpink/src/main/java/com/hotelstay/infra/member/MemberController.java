package com.hotelstay.infra.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/memberAdmList")
	public String memberAdmList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception{
		
		model.addAttribute("list", service.selectList(vo));
		
		return "/adm/infra/member/memberAdmList";
	}
	
}
