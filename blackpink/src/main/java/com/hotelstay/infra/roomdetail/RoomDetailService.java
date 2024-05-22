package com.hotelstay.infra.roomdetail;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.hotelstay.common.util.UtilDateTime;
import com.hotelstay.infra.hotel.HotelDto;
import com.hotelstay.infra.hotel.HotelVo;


@Service
public class RoomDetailService {
	@Autowired
	RoomDetailDao dao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	
	public List<RoomDetailVo> selectList(RoomDetailVo vo){
		
		return dao.selectList(vo);
	}
	
	public RoomDetailDto selectOne(RoomDetailDto dto) {
		return dao.selectOne(dto);
	}
	
	
	public RoomDetailDto selectadmin(RoomDetailDto dto) {
		return dao.selectadmin(dto);
	}
	
	public RoomDetailDto selectOneReview(RoomDetailDto dto) {
		return dao.selectOneReview(dto);
	}
	
	public int reviewCount(RoomDetailDto dto) {
		return dao.reviewCount(dto);
	}
	
	public int roomInsert(RoomDetailDto dto,HotelDto hotelDto)  throws Exception{
		dao.hotelInsert(hotelDto);
		
		dao.roomInsert(dto);
		
		int i =0;
		
		for(MultipartFile multipartFile : dto.getUploadFiles()) {
			
			System.out.println(dto.getRoomSeq()+"@@@@@@@@@@@@@2");
			if(!multipartFile.isEmpty()) {
				if(i == 0) {
					dto.setDefaultNy(1);
				} else {
					dto.setDefaultNy(0);
				}
//				String className = dto.getClass().getSimpleName().toString().toLowerCase();		
				String fileName = multipartFile.getOriginalFilename();
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				String uuid = UUID.randomUUID().toString();
				String uuidFileName = uuid + "." + ext;
//				String pathModule = className;
				String nowString = UtilDateTime.nowString();
				String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
//				String path = pathModule + "/" + type + "/" + pathDate + "/";
//				String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
				
				System.out.println("multipartFile.getOriginalFilename() : " + multipartFile.getOriginalFilename());
				
		        ObjectMetadata metadata = new ObjectMetadata();
		        metadata.setContentLength(multipartFile.getSize());
		        metadata.setContentType(multipartFile.getContentType());
		        
		        amazonS3Client.putObject(bucket, uuidFileName, multipartFile.getInputStream(), metadata);
				
		        String objectUrl = amazonS3Client.getUrl(bucket,uuidFileName).toString();
		        
		        System.out.println(objectUrl);
		        
		        dto.setPath(objectUrl);
				dto.setOriginalName(fileName);
				dto.setUuidName(uuidFileName);
				dto.setExt(ext);
				dto.setSize(multipartFile.getSize());
				dto.setPseq(dto.getRoomSeq());
//				dto.setTableName(tableName);
//				dto.setType(type);
	//			dto.setDefaultNy();
//				dto.setSort(maxNumber + i);
//				dto.setPseq(pSeq);
		        
		        dao.imageUpload(dto);
				
			}
			i++;
		}
		
		
		
		return 1 ;
	}
	
	public int imageUpload(RoomDetailDto dto) {
		return dao.imageUpload(dto);
	}
	
	public int selectOneCount(RoomDetailVo vo) {
		return dao.selectOneCount(vo);
	}
	
	public List<RoomDetailDto> uploadList(RoomDetailDto dto){
		return dao.uploadList(dto);
	}
	
	public List<RoomDetailDto> uploadOne(RoomDetailDto dto) {
		return dao.uploadOne(dto);
	}
	
	public List<RoomDetailDto> uploadDoble(RoomDetailDto dto) {
		return dao.uploadDoble(dto);
	}
	
	public List<RoomDetailDto> uploadSingle(RoomDetailDto dto) {
		return dao.uploadSingle(dto);
	}
	
	public List<RoomDetailDto> uploadTwin(RoomDetailDto dto) {
		return dao.uploadTwin(dto);
	}
	public List<RoomDetailDto> uploadNy(RoomDetailDto dto) {
		return dao.uploadNy(dto);
	}
}