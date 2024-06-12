package com.hotelstay.infra.kakaopay;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hotelstay.infra.roomdetail.RoomDetailDao;
import com.hotelstay.infra.roomdetail.RoomDetailDto;

@Service
public class KakaoPayService {
	private static final String Host = "https://kapi.kakao.com";
	
//	@Value("${kakao_admin_key}")
//	private String kakaoAdminKey;
//	
//	@Autowired
//	RoomDetailDao roomDetailDao;
//	
//	private KakaoPayDto kakaoPayDto;
	
	 // 결제요청
//    public String kakaoPayReady(RoomDetailDto dto) {
//        RestTemplate restTemplate = new RestTemplate();
//        //restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory()); // 정확한 에러 파악을 위해 생성
//        // Server Request Header : 서버 요청 헤더
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "KakaoAK " + kakaoAdminKey); // 어드민 키
//        System.out.println(kakaoAdminKey + "@@@@@@@@@@@@#####################");
//        headers.add("Accept", "application/json");
//        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//        
//        // Server Request Body : 서버 요청 본문
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//
//        params.add("cid", "TC0ONETIME"); // 가맹점 코드 - 테스트용
//        params.add("partner_order_id", dto.getRoomSeq()); // 주문 번호
//        System.out.println(dto.getRoomSeq()+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@kakaopay");
//        params.add("partner_user_id", dto.getMemberSeqF()); // 회원 아이디
//        params.add("item_name", dto.getRoomName()); // 상품 명
//        System.out.println(dto.getRoomName()+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@kakaopay");
////        params.add("quantity", dto.getProductCount()); // 상품 수량
////        System.out.println(dto.getProductCount()+"@@@@@@@@@@@@");
//        params.add("total_amount",dto.getKakaoPrice()); // 상품 가격
//        System.out.println(dto.getKakaoPrice()+"@@@@############!!!!!!!!!!!");
//        params.add("tax_free_amount", "0"); // 상품 비과세 금액
//        params.add("approval_url", "http://localhost:8085/kakaoPaySuccess"); // 성공시 url
////        params.add("cancel_url", "http://localhost:8085/checkout"+"?"+dto.getOrderurl()); // 실패시 url
//        params.add("fail_url", "http://localhost:8085/kakao");
//        
//        // 헤더와 바디 붙이기
//        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
//
//        try {
//            kakaoPayDto = restTemplate.postForObject(new URI(Host + "/v1/payment/ready"), body, KakaoPayDto.class);
//            return kakaoPayDto.getNext_redirect_pc_url();
//
//        } catch (RestClientException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        return "/kakao";
//    }
//
//	public int kakaoPrice(RoomDetailDto dto) {
//		
//		
//		return 1;
//	}

}
