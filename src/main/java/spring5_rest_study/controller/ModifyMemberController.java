package spring5_rest_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring5_rest_study.dto.Member;
import spring5_rest_study.service.ModifyMemberService;

@RestController
public class ModifyMemberController {
	
	
	@Autowired
	private ModifyMemberService modifyService;
	
	@PatchMapping("/api/members/{id}")
	public ResponseEntity<Object> updateMember(@PathVariable long id, @RequestBody Member member){
		System.out.println("updateMember > "+ member);
		return ResponseEntity.ok(modifyService.modifyMember(member));
	}
	

}
