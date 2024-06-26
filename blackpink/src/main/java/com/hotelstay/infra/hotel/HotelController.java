package com.hotelstay.infra.hotel;

import java.util.Date;
import java.util.Locale;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hotelstay.common.contents.Constants;
import com.hotelstay.common.util.UtilDateTime;
import com.hotelstay.infra.codegroup.CodeGroupService;
import com.hotelstay.infra.roomdetail.RoomDetailDto;
import com.hotelstay.infra.roomdetail.RoomDetailService;

@Controller
public class HotelController {
	@Autowired
	HotelService service;
		
	@Autowired
	CodeGroupService codeGroupService;
	
	@Autowired
	RoomDetailService detailService;
	
	
	public void setSearch(HotelVo vo) throws Exception {
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
	
	
//	@RequestMapping(value = "/hotelAdmList")
//	public String hotelAdmList(@ModelAttribute("vo") HotelVo vo, Model model) throws Exception{
//			
//		setSearch(vo);
//		
//		model.addAttribute("count", service.selectOneCount(vo));
//		
//		vo.setParamsPaging(service.selectOneCount(vo));
//		
//		if (vo.getTotalRows() > 0) {
//			model.addAttribute("list", service.selectList(vo));
//		}
//			
//
//        return "adm/infra/hotel/hotelAdmList";
//  	}
//	
//	@RequestMapping(value = "/hotelInsert")
//	public String hotelInsert(RoomDetailDto dto) throws Exception{
//		
//		service.roomInsert(dto);
//		
//		return "redirect:/hotelAdmList"; //
//		
//	}
//	
//	@RequestMapping(value = "/hotelAdd")
//	public String hotelAdd() throws Exception{
//		
//	
//		return "adm/infra/hotel/hotelAdd"; //
//		
//	}
	
	@RequestMapping(value = "/hotelList")
	public String hotelList(@ModelAttribute("vo") HotelVo vo,RoomDetailDto detailDto, Model model) throws Exception{
		
		
		model.addAttribute("count", service.selectOneCount(vo));
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		vo.setHotelTypeCD(vo.getHotelTypeCD() == null
			    ? null
			    : vo.getHotelTypeCD());
			vo.setAreaCD(vo.getAreaCD() == null
			    ? null
			    : vo.getAreaCD());
			
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
			
			
		}
		
//		model.addAttribute("imglist", detailService.uploadNy(detailDto));
		
//		model.addAttribute("imgitem", detailService.uploadOne(detailDto));
//		
//		model.addAttribute("imgdouble", detailService.uploadDoble(detailDto));
		
        return "usr/infra/index/hotelList";
  	}
	
	@RequestMapping(value="/tests")
	public String tests()throws Exception{
		
		return "usr/infra/index/test2";
	}
	
	@RequestMapping(value="/kakaoTest")
	public String kakaoTest()throws Exception{
		
		return "usr/infra/index/kakaoTest";
	}
}
