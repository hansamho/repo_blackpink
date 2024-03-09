package com.hotelstay.infra.code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CodeController {
	
	@Autowired
	CodeService service;
//	CodeGroupService codeGroupService;
	
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(Model model) throws Exception{
//		List<CodeGroupDto> list = service.selectList();
		
//		List<CodeGroupDto> codeGroupDtos = service.selectList();
		
//		for(CodeGroupDto a:codeGroupDtos) {
//			System.out.println(a.getName());
//		}
		
		model.addAttribute("list", service.selectList());
		
		return "/adm/infra/code/codeXdmList";
	}
	
	@RequestMapping(value = "/codeView")
	public String codeView(CodeDto dto, Model model) throws Exception{
		model.addAttribute("item", service.selectOne(dto));
	
		return "/adm/infra/code/codeView"; //
		
	}
	
	@RequestMapping(value = "/codeForm")
	public String codeForm(CodeDto dto, Model model) throws Exception{
		model.addAttribute("item", service.selectOne(dto));
	
		return "/adm/infra/code/codeForm"; //
		
	}
	
	@RequestMapping(value = "/codeLogin")
	public String codeLogin() throws Exception{
		
		return "/adm/infra/code/codeLogin"; //
		
	}
	
	 
	@RequestMapping(value = "/codeInsert")
	public String codeInsert(CodeDto dto) throws Exception{
		
		service.insert(dto);
	
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