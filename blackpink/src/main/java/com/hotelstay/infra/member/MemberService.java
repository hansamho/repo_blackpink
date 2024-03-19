package com.hotelstay.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao dao;
	
	public List<MemberDto> selectList(MemberVo vo){
		
		return dao.selectList(vo);
		
	}
}
