package spring5_rest_study.service.impl;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.mapper.MemberMapper;
import spring5_rest_study.service.RemoveMemberSerivce;
@Service
public class RemoveMemberImpl implements RemoveMemberSerivce {

	static final Log log = LogFactory.getLog(RemoveMemberImpl.class);
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int removeMember(long id) {
		log.debug("service - removeMemberByNo() > " + id);
		return mapper.delete(id);
	}

}
