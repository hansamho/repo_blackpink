package com.hotelstay.infra.kakaonavi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KakaoNaviController {
	
	 @Autowired
	    private KakaoNaviService kakaoNaviService;

	   @RequestMapping(value="/route")
	    public String getRoute(String origin, String destination) {
	        return kakaoNaviService.getNaviRoute(origin, destination);
	    }
}
