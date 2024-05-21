package com.hotelstay.infra.hotel;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.hotelstay.common.util.UtilDateTime;
import com.hotelstay.infra.codegroup.CodeGroupDao;
import com.hotelstay.infra.codegroup.CodeGroupDto;
import com.hotelstay.infra.roomdetail.RoomDetailDao;
import com.hotelstay.infra.roomdetail.RoomDetailDto;

@Service
public class HotelService {
	
	@Autowired
	HotelDao dao;
	
	@Autowired
	RoomDetailDao detailDao;
	
	@Autowired
	CodeGroupDao codeGroupDao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	
	public List<HotelDto> selectList(HotelVo vo){
		return dao.selectList(vo);
	}
	public int selectOneCount(HotelVo vo) {
		return dao.selectOneCount(vo);
	}
	
	public HotelDto selectOne(HotelDto dto) {
		return dao.selectOne(dto);
	}
	
	public int roomInsert(RoomDetailDto dto)  throws Exception{
		dao.roomInsert(dto);
		
		
		return 1 ;
	}
}
