package com.hotelstay.infra.codegroup;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService service;
//	CodeGroupService codeGroupService;
	
	
//	@RequestMapping(value = "/codeGroupXdmList")
//	public String codeGroupXdmList(Model model) throws Exception{
////		List<CodeGroupDto> list = service.selectList();
////		
////		List<CodeGroupDto> codeGroupDtos = service.selectList();
////		
////		for(CodeGroupDto a:codeGroupDtos) {
////			System.out.println(a.getName());
////		}
//		
//		model.addAttribute("list", service.selectList());
//		
//		return "/adm/infra/codegroup/codeGroupXdmList"; 
//	}
	
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(CodeGroupVo vo, Model model) throws Exception{
	
			model.addAttribute("list", service.selectList(vo));
			model.addAttribute("vo",vo);

        return "/adm/infra/codegroup/codeGroupXdmList";
  	}
	
	
	
	@RequestMapping(value = "/codeGroupAdmView")
		public String codeGroupAdmView(CodeGroupDto dto, Model model) throws Exception{
			model.addAttribute("item", service.selectOne(dto));
		
			return "/adm/infra/codegroup/codeGroupAdmView"; //
			
		}
	@RequestMapping(value = "/codeGroupForm")
	public String codeGroupForm(CodeGroupDto dto, Model model) throws Exception{
		model.addAttribute("item", service.selectOne(dto));
	
		return "/adm/infra/codegroup/codeGroupForm"; //
		
	}
	
	@RequestMapping(value = "/codeGroupLogin")
	public String codeGroupLogin() throws Exception{
		
	
		return "/adm/infra/codegroup/codeGroupLogin"; //
		
	}
	
	@RequestMapping(value = "/codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto) throws Exception{
		
		service.insert(dto);
		return "redirect:/codeGroupXdmList"; //
		
	}
	
	@RequestMapping(value = "/codeGroupUpdt")
	public String codeGroupUpdt(CodeGroupDto dto) throws Exception{

		service.update(dto);
		
		return "redirect:/codeGroupXdmList"; //
		
	}
	
	@RequestMapping(value = "/codeGroupUpdtDt")
	public String codeGroupUpdtDt(CodeGroupDto dto) throws Exception{

		service.updateDelete(dto);
		
		return "redirect:/codeGroupXdmList"; //
		
	}
	
	@RequestMapping(value = "/codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto dto) throws Exception{

		service.delete(dto);
		
		return "redirect:/codeGroupXdmList"; //
		
	}
	
	
}