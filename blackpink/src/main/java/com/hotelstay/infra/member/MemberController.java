package com.hotelstay.infra.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotelstay.common.contents.Constants;
import com.hotelstay.common.util.UtilDateTime;
import com.hotelstay.infra.codegroup.CodeGroupDto;
import com.hotelstay.infra.codegroup.CodeGroupVo;





@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	
	public void setSearch(MemberVo vo) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/*이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다.*/
		/*해서 BaseVo.java 에서 기본값을 주어서 처리*/
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.add59TimeString(vo.getShDateEnd()));		
		
//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		
	}
	
	
	@RequestMapping(value = "/memberAdmList")
	public String memberAdmList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception{
		
		setSearch(vo);
		model.addAttribute("list", service.selectList(vo));
		
		return "/adm/infra/member/memberAdmList";
	}
	
	@RequestMapping(value = "/memberAdmView")
	public String memberAdmView(MemberDto dto, Model model) throws Exception{
		model.addAttribute("item", service.selectOne(dto));
	
		return "/adm/infra/member/memberAdmView"; //
		
	}
	@RequestMapping(value = "/memberAdmForm")
	public String memberAdmForm(MemberDto dto, Model model) throws Exception{
		model.addAttribute("item", service.selectOne(dto));

	return "/adm/infra/member/memberAdmForm"; //
	
	}

	@RequestMapping(value = "/memberAdmAdd")
	public String memberAdmAdd() throws Exception{
	

	return "/adm/infra/member/memberAdmAdd"; //
	
	}

	@RequestMapping(value = "/memberInsert")
	public String memberInsert(MemberDto dto) throws Exception{
	
	service.insert(dto);
	return "redirect:/memberAdmList"; //
	
	}

	@RequestMapping(value = "/memberUpdt")
	public String memberUpdt(MemberDto dto) throws Exception{

	service.update(dto);
	
	return "redirect:/memberAdmList"; //
	
	}

	@RequestMapping(value = "/memberUpdtDt")
	public String memberUpdtDt(MemberDto dto) throws Exception{

	service.updateDelete(dto);
	
	return "redirect:/memberAdmList"; //
	
	}

	@RequestMapping(value = "/memberDelete")
	public String memberDelete(MemberDto dto) throws Exception{

	service.delete(dto);
	
	return "redirect:/memberAdmList"; //
	
	}
}



