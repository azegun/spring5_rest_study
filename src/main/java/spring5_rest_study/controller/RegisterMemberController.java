package spring5_rest_study.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring5_rest_study.dto.Member;
import spring5_rest_study.exception.DuplicateMemberException;
import spring5_rest_study.service.RegisterMemberService;

@RestController
public class RegisterMemberController {

	
	@Autowired 
	private RegisterMemberService registerService;
	
	@PostMapping("/api/members")
	public ResponseEntity<Object> newMember(@RequestBody Member member){
		
		try {
			registerService.registerMember(member);
			
			URI uri = URI.create("/api/members" + member.getId());
			return ResponseEntity.created(uri).body(member.getId());
		}catch(DuplicateMemberException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
