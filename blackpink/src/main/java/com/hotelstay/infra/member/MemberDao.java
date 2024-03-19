package com.hotelstay.infra.member;

import java.util.List;

public interface MemberDao {
	
	public List<MemberDto> selectList();
}
