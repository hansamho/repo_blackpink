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
//		setRegMod(dto);
		dao.insert(dto);
		
		for(MultipartFile multipartFile : dto.getUploadFiles()) {
			
			System.out.println(dto.getCgSeq()+"@@@@@@@@@@@@@2");
			if(!multipartFile.isEmpty()) {
				
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
				dto.setPseq(dto.getCgSeq());
//				dto.setTableName(tableName);
//				dto.setType(type);
	//			dto.setDefaultNy();
//				dto.setSort(maxNumber + i);
//				dto.setPseq(pSeq);
		        
		        dao.imageUpload(dto);
				
			}
		}
		
		
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