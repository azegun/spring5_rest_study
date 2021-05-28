package spring5_rest_study.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import spring5_rest_study.exception.WrongIdPasswordException;

@JsonIgnoreProperties({"password"})
public class Member {

	private Long id;
	private String email;
	@JsonIgnore
	private String password;
	private String name;
//	@JsonFormat(pattern = "yyyyMMddHHmmss")
	private LocalDateTime registerDateTime;
	
	public void changePassword(String oldPassword, String  newPassword) {
		
		if(!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		//else 생략
		this.password = newPassword;
	}
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
	
	


	public Member(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}
	public Member(Long id) {
		this.id = id;
	}
	public Member() {
	}


	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("id=%s,  name=%s, password=%s,  registerDateTime=%s",
				id,  name, password,	 registerDateTime);
	}	
}
