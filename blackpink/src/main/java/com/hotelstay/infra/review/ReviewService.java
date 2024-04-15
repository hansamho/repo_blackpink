package com.hotelstay.infra.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
	@Autowired
	ReviewDao dao;
	
	public List<ReviewDto> selectList(ReviewDto dto){
		return dao.selectList(dto);
	}
	
	public ReviewDto selectOne(ReviewDto dto) {
		return dao.selectOne(dto);
	}
	
	public int reviewInsert(ReviewDto dto) {
		return dao.reviewInsert(dto);
	}
	
	public ReviewDto selectOneCount(ReviewDto dto) {
		return dao.selectOneCount(dto);
	}
}
