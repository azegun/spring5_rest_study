package spring5_rest_study.service.impl;

import org.apache.ibatis.logging.Log;

import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mapper.MemberMapper;
import spring5_rest_study.service.MemberIdService;
@Service
public class MemberIdServiceImpl implements MemberIdService {
	
	static final Log log = LogFactory.getLog(MemberIdServiceImpl.class);
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public Member getMember(long id) {
		log.debug("service - getMember() >>" + id);

		return mapper.selectById(id);
	}

}
