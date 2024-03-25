package com.hotelstay.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;



@Service
public class CodeService {
	
	@Autowired
	CodeDao dao;
//	CodeGroupDao dao = new CodeGroupDao();
	
//	public List<CodeGroupDto> selectList(){
//		 
//		List<CodeGroupDto> list = dao.selectList();
//		
//		return list;
//	}
	
//	public List<CodeDto> selectList(){ return dao.selectList();}  
	
	public List<CodeDto> selectList(CodeVo vo) { 
    	return dao.selectList(vo); 
    }
	
	public CodeDto selectOne(CodeDto dto) {                       
		
		return dao.selectOne(dto);
	}
	
	public int insert(CodeDto dto) {                             
		
		return dao.insert(dto);
	}
	
	public int update(CodeDto dto) {                             
		
		return dao.update(dto);
	}
	
	public int updateDelete(CodeDto dto) {
		return dao.updateDelete(dto);
	}
	
	public int delete(CodeDto dto) {
		return dao.delete(dto);
	}
	
	public List<CodeDto> selectListWithoutPaging(){
		return dao.selectListWithoutPaging();
	}
	
	
	 @PostConstruct
		public void selectListCachedCodeArrayList() throws Exception {
			List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) dao.selectListCachedCodeArrayList();
//			codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
			CodeDto.cachedCodeArrayList.clear(); 
			CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
			System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
		}
	
	 public static String selectOneCachedCode(int code) throws Exception {
			String rt = "";
			for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
				if (codeRow.getCdSeq().equals(Integer.toString(code))) {
					rt = codeRow.getName();
				} else {
					// by pass
				}
			}
			return rt;
		}
	 
//	 
	 public static List<CodeDto> selectListCachedCode(String cgSeq) throws Exception {
			List<CodeDto> rt = new ArrayList<CodeDto>();
			for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
				if (codeRow.getCodeGroup_seq().equals(cgSeq)) {
				rt.add(codeRow);
				} else {
					// by pass
				}
			}
			return rt;
		}
	 
	
	 
}