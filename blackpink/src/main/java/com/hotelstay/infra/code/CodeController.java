package com.hotelstay.infra.code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hotelstay.common.contents.Constants;
import com.hotelstay.common.util.UtilDateTime;
import com.hotelstay.infra.codegroup.CodeGroupService;


@Controller
public class CodeController {
	
	@Autowired
	CodeService service;
	
	@Autowired
	CodeGroupService codeGroupService;
	

	
	public void setSearch(CodeVo vo) throws Exception {
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
	
	
	
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception{
	
			setSearch(vo);
			
			model.addAttribute("count", service.selectOneCount(vo));
			
			vo.setParamsPaging(service.selectOneCount(vo));
			
			if (vo.getTotalRows() > 0) {
				model.addAttribute("list", service.selectList(vo));
			}
			
//			model.addAttribute("list", service.selectList(vo));
//			model.addAttribute("vo",vo);
			
			
			return "/adm/infra/code/codeXdmList";
  	}
	
	
	
	@RequestMapping(value = "/codeView")
	public String codeView(CodeDto dto, Model model,@ModelAttribute("vo") CodeVo vo,RedirectAttributes redirectAttributes) throws Exception{
		model.addAttribute("item", service.selectOne(dto));
		redirectAttributes.addFlashAttribute("vo", vo);
		return "/adm/infra/code/codeView"; //
		
	}
	
	@RequestMapping(value = "/codeForm")
	public String codeForm(CodeDto dto, Model model) throws Exception{
		model.addAttribute("item", service.selectOne(dto));
		
		return "/adm/infra/code/codeForm"; //
		
	}
	
	@RequestMapping(value = "/codeAdd")
	public String codeAdd(CodeDto dto, Model model) throws Exception{
		model.addAttribute("listcodegroup", codeGroupService.selectListWithoutPaging());
		
		return "/adm/infra/code/codeAdd"; //
		
	}
	
	 
	@RequestMapping(value = "/codeInsert")
	public String codeInsert(CodeDto dto,RedirectAttributes redirectAttributes) throws Exception{
		
		service.insert(dto);
		
		redirectAttributes.addFlashAttribute("vo", dto);
	
		return "redirect:/codeXdmList";   //
		
	}
	
	@RequestMapping(value = "/codeupdate")
	public String codeupdate(CodeDto dto ) throws Exception{

		service.update(dto);
	
		return "redirect:/codeXdmList";   //
		
	}
	
	@RequestMapping(value = "/codeupdateDelete")
	public String codeupdateDelete(CodeDto dto ) throws Exception{

		service.updateDelete(dto);
	
		return "redirect:/codeXdmList";   //
		
	}
	
	@RequestMapping(value = "/codeDelete")
	public String codeDelete(CodeDto dto ) throws Exception{

		service.delete(dto);
	
		return "redirect:/codeXdmList";   //
		
	}
	
	
	
}