package com.hotelstay.infra.kakaopay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelstay.infra.roomdetail.RoomDetailDto;
import com.hotelstay.infra.roomdetail.RoomDetailService;

@Controller
public class KakakoPayController {
	@Autowired
	KakaoPayService service;
	
	@Autowired
	RoomDetailService roomDetailService;
	
	
//	@ResponseBody
//    @RequestMapping(value="/kakaopay")
//	public  Map<String, Object>  kakaopay(RoomDetailDto dto) {
//    	Map<String, Object> returnMap = new HashMap<String, Object>();
//    	returnMap.put("rt", service.kakaoPayReady(dto));
//    	System.out.println(".................................................... kakaopay");
//    	
//    	service.kakaoPrice(dto);
//    	
//        return returnMap;
//	}
//    
//    // 결제성공
//    @RequestMapping(value="/kakaoPaySuccess")
//    public String kakaoPaySuccess(RoomDetailDto dto) {
////    	model.addAttribute("info", kakaoPayService.kakaoPayInfo(pg_token, httpSession));
//    	
//    	return "redirect:/booking";
//    }  
}
