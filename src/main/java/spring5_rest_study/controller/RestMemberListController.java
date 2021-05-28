package spring5_rest_study.controller;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jndi.toolkit.url.Uri;

import spring5_rest_study.dto.Member;
import spring5_rest_study.exception.DuplicateMemberException;
import spring5_rest_study.service.MemberIdService;
import spring5_rest_study.service.MemberListService;
import spring5_rest_study.service.ModifyMemberService;
import spring5_rest_study.service.RegisterMemberService;
import spring5_rest_study.service.RemoveMemberSerivce;
import spring5_rest_study.service.impl.ModifyMemberServiceImpl;

@RestController
@RequestMapping("/api")
public class RestMemberListController {

	@Autowired
	private MemberListService listService;
	@Autowired
	private MemberIdService getService;
	@Autowired 
	private RegisterMemberService registerService;
	@Autowired
	private ModifyMemberService modifyService;
	@Autowired
	private RemoveMemberSerivce removeService;
	
	@GetMapping("/members")
	public ResponseEntity<Object> members(){
		System.out.println("members()");
		return ResponseEntity.ok(listService.getLists());
	}
	
	@GetMapping("/members/{id}")
	public ResponseEntity<Object> member(@PathVariable long id, HttpServletResponse response){
		Member member =  getService.getMember(id);
		if(member == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(member);
	}
	
	@PostMapping("/members/")
	public ResponseEntity<Object> newMember(@RequestBody Member member){
		System.out.println("newMember > " + member);
		try {
			registerService.registerMember(member);
			
			URI uri = URI.create("/api/members" + member.getId());
			return ResponseEntity.created(uri).body(member.getId());
		}catch(DuplicateMemberException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	@PatchMapping("/members/{id}")
	public ResponseEntity<Object> updateMember(@PathVariable long id, @RequestBody Member member){
		System.out.println("updateMember > "+ member);
		return ResponseEntity.ok(modifyService.modifyMember(member));
	}
	
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Object> deleteMember(@PathVariable long id){
		System.out.println("deleteMember > "+ id);
		return ResponseEntity.ok(removeService.removeMember(id));
	}
}

