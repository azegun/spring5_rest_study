package spring5_rest_study.service.impl;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mapper.MemberMapper;
import spring5_rest_study.service.RegisterMemberService;

public class RegisterMemberServiceImpl implements RegisterMemberService {
	
	static final Log log = LogFactory.getLog(RegisterMemberServiceImpl.class);
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int registerMember(Member member) {
		log.debug("service - registerMember() > " + member);

		return mapper.insert(member);
	}

}
