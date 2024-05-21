package com.hotelstay.infra.roomdetail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.services.s3.AmazonS3Client;
import com.hotelstay.common.contents.Constants;
import com.hotelstay.common.util.UtilDateTime;
import com.hotelstay.infra.booking.BookingDto;
import com.hotelstay.infra.hotel.HotelDto;
import com.hotelstay.infra.hotel.HotelService;
import com.hotelstay.infra.hotel.HotelVo;
import com.hotelstay.infra.member.MemberDto;
import com.hotelstay.infra.review.ReviewDto;
import com.hotelstay.infra.review.ReviewService;
import com.hotelstay.infra.review.ReviewVo;

import jakarta.servlet.http.HttpSession;


@Controller
public class RoomDetailController {
	@Autowired
	RoomDetailService service;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	HotelService hotelService;
	
	
	public void setSearch(RoomDetailVo vo) throws Exception {
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
	 
	@RequestMapping(value = "/roomDetail")
	public String roomDetail(@ModelAttribute("vo") RoomDetailVo vo, RoomDetailDto dto,ReviewDto rdto, Model model) throws Exception{
		
		
		model.addAttribute("item", service.selectOne(dto));
		
		model.addAttribute("count", service.reviewCount(dto));
		
		model.addAttribute("list", reviewService.selectList(rdto));
		
		model.addAttribute("imglist", service.uploadOne(dto));
		
		model.addAttribute("imgdouble", service.uploadDoble(dto));
		
		model.addAttribute("imgsingle", service.uploadSingle(dto));
		
		model.addAttribute("imgtwin", service.uploadTwin(dto));
		
        return "usr/infra/index/roomDetail";
  	}
		
	
	//리뷰 작성
	@ResponseBody
	@RequestMapping(value = "/reviewInsert")
	public Map<String, Object> reviewInsert(ReviewDto rdto,RoomDetailDto dto, HttpSession httpSession) throws Exception {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			
			dto.setMemberSeqF((String) httpSession.getAttribute("sessSeqUsr"));
			
			System.out.println("dto.getRoomSeq()" +" "+ dto.getRoomSeq());
			
			rdto.setRoomSeqF(dto.getRoomSeq());  
			
			reviewService.reviewInsert(rdto);  
			
			returnMap.put("seq", dto.getRoomSeq());  
			
			returnMap.put("rt", "success") ;    

			
			return returnMap;
	}
	
	
	@RequestMapping(value = "/hotelAdmList")
	public String hotelAdmList(@ModelAttribute("vo") RoomDetailVo vo,HotelVo hotelVo ,Model model) throws Exception{
			
		setSearch(vo);
		
		model.addAttribute("count", service.selectOneCount(vo));
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", hotelService.selectList(hotelVo));
		}
			

        return "adm/infra/hotel/hotelAdmList";
  	}
	
	@RequestMapping(value = "/hotelInsert")
	public String hotelInsert(RoomDetailDto dto,HotelDto hotelDto) throws Exception{
		
		service.roomInsert(dto, hotelDto);
		
		return "redirect:/hotelAdmList"; //
		
	}
	
	@RequestMapping(value = "/hotelAdd")
	public String hotelAdd() throws Exception{
		
	
		return "adm/infra/hotel/hotelAdd"; //
		
	}
	
	@RequestMapping(value = "/hotelAdmView")
	public String hotelAdmView(HotelDto dto,Model model) throws Exception{
		 
		model.addAttribute("item", hotelService.selectOne(dto));
		
		return "adm/infra/hotel/hotelAdmView";
		
	}
}