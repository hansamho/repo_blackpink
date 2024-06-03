package com.hotelstay.infra.codegroup;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.hotelstay.common.util.UtilDateTime;


@Service
public class CodeGroupService {
//	CodeGroupDao codeGroupDao;
	
	@Autowired
	CodeGroupDao dao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo) { 
    	return dao.selectList(vo); 
    }
	
	
	public CodeGroupDto selectOne(CodeGroupDto dto) {
		return dao.selectOne(dto);
	}
	
	public int insert(CodeGroupDto dto)  throws Exception {

		dao.insert(dto);
		
		return 1;
		
	}
	
	public int update(CodeGroupDto dto) {
		return dao.update(dto);
	}
	
	public int updateDelete(CodeGroupDto dto) {
		return dao.updateDelete(dto);
	}
	
	public int delete(CodeGroupDto dto) {
		return dao.delete(dto);
	}
	
	public List<CodeGroupDto> selectListWithoutPaging(){
		return dao.selectListWithoutPaging();
	}
	public int selectOneCount(CodeGroupVo vo) {
		return dao.selectOneCount(vo);
	}
	
	public CodeGroupDto uploadOne(CodeGroupDto dto) {
		return dao.uploadOne(dto);
	}
	
}