package spring5_rest_study.mapper;

import java.util.List;

import spring5_rest_study.dto.Member;

public interface MemberMapper {
		
		List<Member> selectAll();
		Member selectById(Long memId);
		
		int insert(Member member);
		int update(Member member);
		int delete(Member member);
		
		
}
