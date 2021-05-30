package spring5_rest_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import spring5_rest_study.service.RemoveMemberSerivce;
@RestController
public class RemoveMemberController {


	@Autowired
	private RemoveMemberSerivce removeService;
	
	@DeleteMapping("/api/members/{id}")
	public ResponseEntity<Object> deleteMember(@PathVariable long id){
		System.out.println("deleteMember > "+ id);
		return ResponseEntity.ok(removeService.removeMember(id));
	}
}
