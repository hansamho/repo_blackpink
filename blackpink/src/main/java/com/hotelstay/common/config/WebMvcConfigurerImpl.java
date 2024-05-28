package com.hotelstay.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hotelstay.common.contents.Constants;
import com.hotelstay.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler(Constants.UPLOADED_RESSOURCE_HANDLER)
	                .addResourceLocations(Constants.UPLOADED_RESSOURCE_LOCATIONS);
	        
	    }
	    
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			
			registry.addInterceptor(new CheckLoginSessionInterceptor()) //LoginCheckInterceptor 등록
//					.order(2)
					.addPathPatterns("/**")
					.excludePathPatterns(
//							"/resources/**",
							"/adm/**",
							"/usr/**",
							"/main/**",
							"/usrLogin",
							"/admLogin",
							"/signinUsr",
							"/signinAdm",
							"/usrIndex",
							"/admIndex",
							"/codeXdmList",
							"/codeAdd",
							"/codeForm",
							"/codeView",
							"/codeInsert",
							"/codeupdate",
							"/codeupdateDelete",
							"/codeDelete",
							"/codeGroupXdmList",
							"/codeGroupAdd",
							"/codeGroupForm",
							"/codeGroupAdmView",
							"/codeGroupInsert",
							"/codeGroupUpdt",
							"/codeGroupUpdtDt",
							"/codeGroupDelete",
							"/memberAdmList",
							"/memberAdmView",
							"/memberAdmForm",
							"/memberAdmAdd",
							"/memberInsert",
							"/memberUpdt",
							"/memberUpdtDt",
							"/memberDelete",
							"/register",
							"/hotelList",
							"/roomDetail",
							"/main",
							"/kakaoLogin",
							"/redirectKakao",
							"/cgInsert",
							"/hotelAdmList",
							"/hotelAdd",
							"/hotelAdmView",
							"/test",
							"/hotelInsert",
							"/test2",
							"/publicCorona1List",
							"/publicCorona2List",
							"/tests",
							"/codeGroupAjaxList",
							"/codeGroupAjaxLita"
							
//							"/usr/infra/index/register",
//							"/usr/infra/index/usrindex"
//							"/usr/infra/index/mypage"
//							"/v1/infra/member/signoutXdmProc"
//							"/v1/infra/index/indexXdmView"
//							"/members/add", 
//							"/login", 
//							"/logout", 
					)
			;
		}
		
	}

