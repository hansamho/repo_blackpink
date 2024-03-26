package com.hotelstay.infra.codegroup;

import java.util.List;

import com.hotelstay.infra.code.CodeDto;

public interface CodeGroupDao {
	
//	public List<CodeGroupDto> selectList(); // 여러개 데이터를 보낼떄는 list 
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo);
	
	public CodeGroupDto selectOne(CodeGroupDto dto); //한개의 데이터를 보낼때
	
	public int insert(CodeGroupDto dto);
	
	public int update(CodeGroupDto dto);
	
	public int updateDelete(CodeGroupDto dto);
	
	public int delete(CodeGroupDto dto);
	
	public List<CodeGroupDto> selectListWithoutPaging();
	
	public int selectOneCount();
}
