package spring5_rest_study.mapper;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_rest_study.config.ContextRoot;
import spring5_rest_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberMapperTest {

	private static final Log log = LogFactory.getLog(MemberMapperTest.class);
	
	@Autowired
	private MemberMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test05SelectAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Member> list = mapper.selectAll();
		list.stream().forEach(System.out::println);
		Assert.assertNotNull(list);
	}

	@Test
	public void test01SelectById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member selectMembers = mapper.selectById((long) 68);
		Assert.assertNotNull(selectMembers);

	}

	@Test
	public void test03Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member newMember = new Member("test64@test.com", "11111", "김상건");
		int res = mapper.insert(newMember);
		Assert.assertEquals(1, res);
		
		log.debug("res id >>" +res);
		
		mapper.delete(newMember.getId());
	}

	@Test
	public void test04Update() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Member newMember = new Member("test64@test.com", "123456", "test");
		newMember.setId(74L);
		int res = mapper.update(newMember);
		
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05Delete() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		int res = mapper.delete((long) 80);
		Assert.assertEquals(1, res);
	}

}
