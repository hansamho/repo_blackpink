package com.hotelstay.infra.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelstay.common.contents.Constants;
import com.hotelstay.common.util.UtilDateTime;
import com.hotelstay.infra.codegroup.CodeGroupService;
import com.hotelstay.infra.hotel.HotelDto;
import com.hotelstay.infra.hotel.HotelService;
import com.hotelstay.infra.hotel.HotelVo;
import com.hotelstay.infra.roomdetail.RoomDetailDto;
import com.hotelstay.infra.roomdetail.RoomDetailService;

import jakarta.servlet.http.HttpSession;





@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	RoomDetailService detailService;
	
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
		
		model.addAttribute("count", service.selectOneCount(vo));
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
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

		
		dto.setMemberPassword(encodeBcrypt(dto.getMemberPassword(),10));
		
		
		service.insert(dto);

	return "redirect:/memberAdmList"; //
	
	}

	@RequestMapping(value = "/memberUpdt")
	public String memberUpdt(MemberDto dto) throws Exception{
	
		dto.setMemberPassword(encodeBcrypt(dto.getMemberPassword(),10));
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
	
	/* 첫 화면 페이지*/
	@RequestMapping(value = "/main")
	public String main() throws Exception{
	
		return "/main/infra/index/mainindex";
	}
	
	/* =====관리자===== */
	
	@RequestMapping(value = "/admLogin")
	public String admLogin(MemberDto dto) throws Exception{
	
		return "/adm/infra/index/admlogin";
	}
	
	@RequestMapping(value = "/admIndex")
	public String admIndex(MemberDto dto) throws Exception{
	
		return "/adm/infra/index/admindex";
	}
	
	@ResponseBody
	@RequestMapping(value = "/signinAdm")
	public Map<String, Object> signinAdm(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		System.out.println("aaaaaaaaaaa");
		System.out.println(dto.getMemberID());
		
		
		MemberDto rtDto = service.selectLogin(dto);
		
//		System.out.println(service.selectLogin(dto).getMemberPassword());
		
		
		if(rtDto != null) {
			
			String loginId = dto.getMemberID();
			String loginpwd = dto.getMemberPassword();
			
			
			httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqXdm", rtDto.getMemberSeq());
			httpSession.setAttribute("sessIdXdm", rtDto.getMemberID());
			httpSession.setAttribute("sessNameXdm", rtDto.getMemberName());
			
			System.out.println("---------------------");
			System.out.println("httpSession.getAttribute(\"sessNameXdm\"): " + httpSession.getAttribute("sessNameXdm"));
			System.out.println("---------------------");
			
			if(loginId.equals(rtDto.getMemberID())) {
				
				if(matchesBcrypt(loginpwd, rtDto.getMemberPassword(),10)) {
					returnMap.put("rt","success");
				} else {
					returnMap.put("rt", "passfail");
				}
				
			} else {
				returnMap.put("rt", "idfail");
			}
		} else {
			returnMap.put("rt", "notId");
		}
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/signoutAdm")
	public Map<String, Object> signoutAdm(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		returnMap.put("rt", "success");
		httpSession.invalidate();
		return returnMap;
	}
	
	
	/* ------------------사용자------------------------------- */
	
	
	@RequestMapping(value = "/usrLogin")
	public String usrLogin(MemberDto dto) throws Exception{
	
		return "/usr/infra/index/usrlogin";
	}
	
	@RequestMapping(value = "/usrIndex")
	public String usrIndex(@ModelAttribute("vo") HotelVo vo,HotelDto dto,RoomDetailDto detailDto, Model model) throws Exception{
		
		model.addAttribute("listCodeGroup",codeGroupService.selectListWithoutPaging());
			
		 List<HotelDto> highRatedHotels = hotelService.selectList(vo).stream()
		            .filter(hotel -> hotel.getHotelRating() >= 4.0 )
		            .collect(Collectors.toList());
			
			model.addAttribute("list", hotelService.selectList(vo));
		
		
		return "/usr/infra/index/usrindex";
	}
	
	//로그인
	@ResponseBody
	@RequestMapping(value = "/signinUsr")
	public Map<String, Object> signinUsr(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		
		
		MemberDto rtDto = service.selectLogin(dto);
		
//		System.out.println(service.selectLogin(dto).getMemberPassword());
		
		
		if(rtDto != null) {
			
			
			String loginId = dto.getMemberID();
			String loginpwd = dto.getMemberPassword();
			
			
			httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
			httpSession.setAttribute("sessSeqUsr", rtDto.getMemberSeq());
			httpSession.setAttribute("sessIdUsr", rtDto.getMemberID());
			httpSession.setAttribute("sessNameUsr", rtDto.getMemberName());
			
			System.out.println("---------------------");
			System.out.println("httpSession.getAttribute(\"sessNameUsr\"): " + httpSession.getAttribute("sessNameUsr"));
			System.out.println("---------------------");
			
			if(loginId.equals(rtDto.getMemberID())) {
				
				if(matchesBcrypt(loginpwd, rtDto.getMemberPassword(),10)) {
					returnMap.put("rt","success");
				} else {
					returnMap.put("rt", "passfail");
				}
				
			} else {
				returnMap.put("rt", "idfail");
			}
		} else {
			returnMap.put("rt", "notId");
		}
		return returnMap;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/signoutUsr")
	public Map<String, Object> signoutUsr(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		returnMap.put("rt", "success");
		httpSession.invalidate();
		return returnMap;
	}
	
	//  회원가입	
	@RequestMapping(value = "/register")
	public String register(MemberDto dto,Model model) throws Exception{
		model.addAttribute("listCodeGroup", codeGroupService.selectListWithoutPaging());
		
		
		return "/usr/infra/index/register";
	}
	
	
	@RequestMapping(value = "/usrInsert")
	public String usrInsert(MemberDto dto) throws Exception{

		
		dto.setMemberPassword(encodeBcrypt(dto.getMemberPassword(),10));
		
		
		service.usrInsert(dto);

	return "redirect:/usrIndex"; //
	
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/usrInsert")
//	public Map<String, Object> usrInsert(MemberDto dto, HttpSession httpSession,Model model) throws Exception {
//			Map<String, Object> returnMap = new HashMap<String, Object>();
//			
//			MemberDto rtPwd = service.pwdcheck(dto);
//			
//			
//			if(rtPwd != null) {
//			
//			if(dto.getChangePwd().equals(dto.getCheckPwd())) {
//				dto.setMemberPassword(encodeBcrypt(dto.getChangePwd(),10));
//				service.passwordUpdate(dto);
//				returnMap.put("rt", "success") ;
//			} else {
//				returnMap.put("rt", "fail");
//			} 
//			
//			}
//			return returnMap ;
//			
//	}
	
	//비밀번호 체크
	@ResponseBody
	@RequestMapping(value = "/passwordUpdate")
	public Map<String, Object> passwordUpdate(MemberDto dto, HttpSession httpSession,Model model) throws Exception {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			
			dto.setMemberSeqF((String)httpSession.getAttribute("sessSeqUsr"));
			
			MemberDto rtPwd = service.pwdcheck(dto);
			
			
			if(rtPwd != null) {
			
			if(dto.getChangePwd().equals(dto.getCheckPwd())) {
				dto.setMemberPassword(encodeBcrypt(dto.getChangePwd(),10));
				service.passwordUpdate(dto);
				returnMap.put("rt", "success") ;
			} else {
				returnMap.put("rt", "fail");
			} 
			
			}
			return returnMap ;
	}
	//암호화
	
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
	
}



