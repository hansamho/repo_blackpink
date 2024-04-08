package com.hotelstay.infra.member;

import java.util.List;

import com.hotelstay.infra.codegroup.CodeGroupDto;

public interface MemberDao {
	
	public List<MemberDto> selectList(MemberVo vo);
	
	public MemberDto selectOne(MemberDto dto);
	
	public int insert(MemberDto dto);
	
	public int update(MemberDto dto);
	
	public int updateDelete(MemberDto dto);
	
	public int delete(MemberDto dto);
	
	public int selectOneCount(MemberVo vo);
	
	public MemberDto selectLogin(MemberDto dto);
	
	public int usrInsert(MemberDto dto);
	
	public int passwordUpdate(MemberDto dto);
	
	public MemberDto pwdcheck(MemberDto dto);
}
