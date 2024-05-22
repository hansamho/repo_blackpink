package com.hotelstay.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/member")
public class MemberRestController {
	
		@Autowired
		MemberService service;
		
		@RequestMapping(value = "", method = RequestMethod.GET)
	//	@GetMapping("")
		public List<MemberDto> selectList(MemberVo vo) throws Exception {
			List<MemberDto> list = service.selectList(vo);
			return list;
		}
		
	
		@RequestMapping(value = "/{seq}", method = RequestMethod.GET)
	//	@GetMapping("/{seq}")
		public MemberDto selectOne(@PathVariable String seq, MemberDto dto) throws Exception {
			dto.setMemberSeq(seq);
			MemberDto item = service.selectOne(dto);
			return item;
		}
		
	
		@RequestMapping(value = "", method = RequestMethod.POST)
	//	@PostMapping("")
		public String insert(MemberDto dto) throws Exception {
			
			System.out.println("dto.getMemberID(): " + dto.getMemberID());
			System.out.println("dto.getMemberName(): " + dto.getMemberName());
			
			service.insert(dto);
			return dto.getMemberSeq();
		}
		
		
		@RequestMapping(value = "/{seq}", method = RequestMethod.PUT)
	//	@PatchMapping("/{seq}")
	//	@PutMapping("/{seq}")
		public void update(@PathVariable String seq, MemberDto dto) throws Exception {
			
			
			System.out.println("seq: " + seq);
			System.out.println("dto.getMemberID(): " + dto.getMemberID());
			System.out.println("dto.getMemberName(): " + dto.getMemberName());
			
			dto.setMemberSeq(seq);
			service.update(dto);
		}
		
	
}
