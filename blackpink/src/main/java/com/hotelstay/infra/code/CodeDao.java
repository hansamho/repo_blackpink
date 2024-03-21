package com.hotelstay.infra.code;

import java.util.ArrayList;
import java.util.List;


public interface CodeDao {
	
//	public List<CodeDto> selectList();         //데이터 여러개 가져올떄
	
	public List<CodeDto> selectList(CodeVo vo);
	
	public CodeDto selectOne(CodeDto dto); 	   // 데이터 한개만 가져올때
	
	public int insert(CodeDto dto);
	
	public int update(CodeDto dto); 
	
	public int updateDelete(CodeDto dto);
	
	public int delete(CodeDto dto);

	public List<CodeDto> selectListCachedCodeArrayList();
}