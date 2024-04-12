package com.hotelstay.infra.review;

import java.util.List;

public interface ReviewDao {
	
	public List<ReviewDto> selectList(ReviewDto dto);
	
	public ReviewDto selectOne(ReviewDto dto);
	
	public int reviewInsert(ReviewDto dto);
}
